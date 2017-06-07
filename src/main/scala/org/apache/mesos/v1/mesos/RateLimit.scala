// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO2

package org.apache.mesos.v1.mesos

/** *
  * Rate (queries per second, QPS) limit for messages from a framework to master.
  * Strictly speaking they are the combined rate from all frameworks of the same
  * principal.
  *
  * @param qps
  *   Leaving QPS unset gives it unlimited rate (i.e., not throttled),
  *   which also implies unlimited capacity.
  * @param principal
  *   Principal of framework(s) to be throttled. Should match
  *   FrameworkInfo.principal and Credential.principal (if using authentication).
  * @param capacity
  *   Max number of outstanding messages from frameworks of this principal
  *   allowed by master before the next message is dropped and an error is sent
  *   back to the sender. Messages received before the capacity is reached are
  *   still going to be processed after the error is sent.
  *   If unspecified, this principal is assigned unlimited capacity.
  *   NOTE: This value is ignored if 'qps' is not set.
  */
@SerialVersionUID(0L)
final case class RateLimit(
    qps: scala.Option[Double] = None,
    principal: String,
    capacity: scala.Option[Long] = None
    ) extends com.trueaccord.scalapb.GeneratedMessage with com.trueaccord.scalapb.Message[RateLimit] with com.trueaccord.lenses.Updatable[RateLimit] {
    @transient
    private[this] var __serializedSizeCachedValue: Int = 0
    private[this] def __computeSerializedValue(): Int = {
      var __size = 0
      if (qps.isDefined) { __size += _root_.com.google.protobuf.CodedOutputStream.computeDoubleSize(1, qps.get) }
      __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(2, principal)
      if (capacity.isDefined) { __size += _root_.com.google.protobuf.CodedOutputStream.computeUInt64Size(3, capacity.get) }
      __size
    }
    final override def serializedSize: Int = {
      var read = __serializedSizeCachedValue
      if (read == 0) {
        read = __computeSerializedValue()
        __serializedSizeCachedValue = read
      }
      read
    }
    def writeTo(`_output__`: _root_.com.google.protobuf.CodedOutputStream): Unit = {
      qps.foreach { __v =>
        _output__.writeDouble(1, __v)
      };
      _output__.writeString(2, principal)
      capacity.foreach { __v =>
        _output__.writeUInt64(3, __v)
      };
    }
    def mergeFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): org.apache.mesos.v1.mesos.RateLimit = {
      var __qps = this.qps
      var __principal = this.principal
      var __capacity = this.capacity
      var __requiredFields0: Long = 0x1L
      var _done__ = false
      while (!_done__) {
        val _tag__ = _input__.readTag()
        _tag__ match {
          case 0 => _done__ = true
          case 9 =>
            __qps = Some(_input__.readDouble())
          case 18 =>
            __principal = _input__.readString()
            __requiredFields0 &= 0xfffffffffffffffeL
          case 24 =>
            __capacity = Some(_input__.readUInt64())
          case tag => _input__.skipField(tag)
        }
      }
      if (__requiredFields0 != 0L) { throw new _root_.com.google.protobuf.InvalidProtocolBufferException("Message missing required fields.") } 
      org.apache.mesos.v1.mesos.RateLimit(
          qps = __qps,
          principal = __principal,
          capacity = __capacity
      )
    }
    def getQps: Double = qps.getOrElse(0.0)
    def clearQps: RateLimit = copy(qps = None)
    def withQps(__v: Double): RateLimit = copy(qps = Some(__v))
    def withPrincipal(__v: String): RateLimit = copy(principal = __v)
    def getCapacity: Long = capacity.getOrElse(0L)
    def clearCapacity: RateLimit = copy(capacity = None)
    def withCapacity(__v: Long): RateLimit = copy(capacity = Some(__v))
    def getFieldByNumber(__fieldNumber: Int): scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => qps.orNull
        case 2 => principal
        case 3 => capacity.orNull
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => qps.map(_root_.scalapb.descriptors.PDouble(_)).getOrElse(_root_.scalapb.descriptors.PEmpty)
        case 2 => _root_.scalapb.descriptors.PString(principal)
        case 3 => capacity.map(_root_.scalapb.descriptors.PLong(_)).getOrElse(_root_.scalapb.descriptors.PEmpty)
      }
    }
    override def toString: String = _root_.com.trueaccord.scalapb.TextFormat.printToUnicodeString(this)
    def companion = org.apache.mesos.v1.mesos.RateLimit
}

object RateLimit extends com.trueaccord.scalapb.GeneratedMessageCompanion[org.apache.mesos.v1.mesos.RateLimit] {
  implicit def messageCompanion: com.trueaccord.scalapb.GeneratedMessageCompanion[org.apache.mesos.v1.mesos.RateLimit] = this
  def fromFieldsMap(__fieldsMap: scala.collection.immutable.Map[_root_.com.google.protobuf.Descriptors.FieldDescriptor, scala.Any]): org.apache.mesos.v1.mesos.RateLimit = {
    require(__fieldsMap.keys.forall(_.getContainingType() == javaDescriptor), "FieldDescriptor does not match message type.")
    val __fields = javaDescriptor.getFields
    org.apache.mesos.v1.mesos.RateLimit(
      __fieldsMap.get(__fields.get(0)).asInstanceOf[scala.Option[Double]],
      __fieldsMap(__fields.get(1)).asInstanceOf[String],
      __fieldsMap.get(__fields.get(2)).asInstanceOf[scala.Option[Long]]
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[org.apache.mesos.v1.mesos.RateLimit] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      require(__fieldsMap.keys.forall(_.containingMessage == scalaDescriptor), "FieldDescriptor does not match message type.")
      org.apache.mesos.v1.mesos.RateLimit(
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).flatMap(_.as[scala.Option[Double]]),
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).get.as[String],
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).flatMap(_.as[scala.Option[Long]])
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = MesosProto.javaDescriptor.getMessageTypes.get(51)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = MesosProto.scalaDescriptor.messages(51)
  def messageCompanionForFieldNumber(__fieldNumber: Int): _root_.com.trueaccord.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__fieldNumber)
  def enumCompanionForFieldNumber(__fieldNumber: Int): _root_.com.trueaccord.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = org.apache.mesos.v1.mesos.RateLimit(
    principal = ""
  )
  implicit class RateLimitLens[UpperPB](_l: _root_.com.trueaccord.lenses.Lens[UpperPB, org.apache.mesos.v1.mesos.RateLimit]) extends _root_.com.trueaccord.lenses.ObjectLens[UpperPB, org.apache.mesos.v1.mesos.RateLimit](_l) {
    def qps: _root_.com.trueaccord.lenses.Lens[UpperPB, Double] = field(_.getQps)((c_, f_) => c_.copy(qps = Some(f_)))
    def optionalQps: _root_.com.trueaccord.lenses.Lens[UpperPB, scala.Option[Double]] = field(_.qps)((c_, f_) => c_.copy(qps = f_))
    def principal: _root_.com.trueaccord.lenses.Lens[UpperPB, String] = field(_.principal)((c_, f_) => c_.copy(principal = f_))
    def capacity: _root_.com.trueaccord.lenses.Lens[UpperPB, Long] = field(_.getCapacity)((c_, f_) => c_.copy(capacity = Some(f_)))
    def optionalCapacity: _root_.com.trueaccord.lenses.Lens[UpperPB, scala.Option[Long]] = field(_.capacity)((c_, f_) => c_.copy(capacity = f_))
  }
  final val QPS_FIELD_NUMBER = 1
  final val PRINCIPAL_FIELD_NUMBER = 2
  final val CAPACITY_FIELD_NUMBER = 3
}