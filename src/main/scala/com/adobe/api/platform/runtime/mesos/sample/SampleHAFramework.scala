package com.adobe.api.platform.runtime.mesos.sample

import akka.actor.ActorRef
import akka.actor.Address
import akka.actor.{Actor, ActorLogging, ActorSystem, Props}
import akka.cluster.{Cluster, ClusterEvent}
import akka.cluster.ClusterEvent._
import com.adobe.api.platform.runtime.mesos.MesosClient
import com.adobe.api.platform.runtime.mesos.Subscribe
import com.adobe.api.platform.runtime.mesos.SubscribeComplete
import com.typesafe.config.{Config, ConfigFactory}
import scala.concurrent.duration._
import akka.pattern.ask

object SampleHAFramework {
 /* def _simple_main(args: Array[String]): Unit = {
    val marathonConfig = MarathonConfig.discoverAkkaConfig()
    val clusterName: String = marathonConfig.getString("akka.cluster.name")

    // Create an Akka system
    val system = ActorSystem(clusterName, marathonConfig)

    // Create an actor that handles cluster domain events
    system.actorOf(Props[SimpleClusterListener], name = "clusterListener")
  }*/


  def main(args: Array[String]): Unit = {
    val config: Config = ConfigFactory.load()

    System.out.println(config.toString)

    val clusterName: String = config.getString("akka.cluster.name")

    System.out.println(s"Starting a cluster named: ${clusterName}" )

    // Create an Akka system
    val system = ActorSystem(clusterName)

    // Create an actor that handles cluster domain events
    system.actorOf(Props[SimpleClusterListener], name = "clusterListener")

    val seedNodes = MarathonConfig.getSeedNodes(config)
    System.out.println(s"joining cluster with seed nodes ${seedNodes}")
    Cluster(system).joinSeedNodes(seedNodes.toList)

  }
}

class SimpleClusterListener extends Actor with ActorLogging {

  val cluster = Cluster(context.system)
  var isSubscribed = false
  var mesosClientActor:ActorRef = null
  val subscribeTimeout = 30.seconds
  val teardownTimeout = 30.seconds

  implicit val ec = context.system.dispatcher

  // subscribe to cluster changes, re-subscribe when restart
  override def preStart(): Unit = {
    cluster.subscribe(self,
      classOf[MemberEvent],
      classOf[UnreachableMember],
      classOf[ClusterEvent.LeaderChanged])
  }
  override def postStop(): Unit = cluster.unsubscribe(self)

  var leader:Option[Address] = None
  def receive = {
    case state: CurrentClusterState =>
      log.info("Current members: {}. Leader: {}", state.members.size, state.getLeader)
    case MemberUp(member) =>
      log.info("Member is Up: {}", member.address)
    case UnreachableMember(member) =>
      log.info("Member detected as unreachable: {}", member)
    case MemberRemoved(member, previousStatus) =>
      log.info("Member is Removed: {} after {}",
        member.address, previousStatus)
    case LeaderChanged(node) =>
      log.info("Leader changed to {}", node)
      leader = node
      if (node.exists(_ == cluster.selfAddress)) {
          context.system.scheduler.scheduleOnce(5.seconds) {
            subscribe()
          }

      } else {
        unsubscribe()
      }
    case event: MemberEvent =>
      log.info("Member event at {}, status: {}", event.member.address, event.member.status)
    // ignore

  }

  def unsubscribe(): Unit = {
    if (mesosClientActor != null){
      log.info("disconnecting as mesos framework")
      context.stop(mesosClientActor)
      mesosClientActor = null
    }
  }

  def subscribe(): Unit = {
    if (leader.exists(_ == cluster.selfAddress)) {
      log.info("subscribing as mesos framework")

      mesosClientActor = context.system.actorOf(MesosClient.props(
        "sample-" + "12345678",//UUID.randomUUID()
        "sample-framework",
        "http://192.168.99.100:5050",
        "sample-role",
        5.minutes
      ))

      mesosClientActor.ask(Subscribe)(subscribeTimeout).mapTo[SubscribeComplete].onComplete(complete => {
        log.info("subscribe completed successfully...")
        isSubscribed = true
      })
    } else {
      log.info("leader changed before subscribe was fired")
    }

  }
}