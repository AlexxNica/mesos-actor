// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO2

package org.apache.mesos.v1.mesos

/** *
  * Named WeightInfo to indicate resource allocation
  * priority between the different roles.
  *
  * @param role
  *   Related role name.
  */
@SerialVersionUID(0L)
final case class WeightInfo(
    weight: Double,
    role: scala.Option[String] = None
    ) extends com.trueaccord.scalapb.GeneratedMessage with com.trueaccord.scalapb.Message[WeightInfo] with com.trueaccord.lenses.Updatable[WeightInfo] {
    @transient
    private[this] var __serializedSizeCachedValue: Int = 0
    private[this] def __computeSerializedValue(): Int = {
      var __size = 0
      __size += _root_.com.google.protobuf.CodedOutputStream.computeDoubleSize(1, weight)
      if (role.isDefined) { __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(2, role.get) }
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
      _output__.writeDouble(1, weight)
      role.foreach { __v =>
        _output__.writeString(2, __v)
      };
    }
    def mergeFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): org.apache.mesos.v1.mesos.WeightInfo = {
      var __weight = this.weight
      var __role = this.role
      var __requiredFields0: Long = 0x1L
      var _done__ = false
      while (!_done__) {
        val _tag__ = _input__.readTag()
        _tag__ match {
          case 0 => _done__ = true
          case 9 =>
            __weight = _input__.readDouble()
            __requiredFields0 &= 0xfffffffffffffffeL
          case 18 =>
            __role = Some(_input__.readString())
          case tag => _input__.skipField(tag)
        }
      }
      if (__requiredFields0 != 0L) { throw new _root_.com.google.protobuf.InvalidProtocolBufferException("Message missing required fields.") } 
      org.apache.mesos.v1.mesos.WeightInfo(
          weight = __weight,
          role = __role
      )
    }
    def withWeight(__v: Double): WeightInfo = copy(weight = __v)
    def getRole: String = role.getOrElse("")
    def clearRole: WeightInfo = copy(role = None)
    def withRole(__v: String): WeightInfo = copy(role = Some(__v))
    def getFieldByNumber(__fieldNumber: Int): scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => weight
        case 2 => role.orNull
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PDouble(weight)
        case 2 => role.map(_root_.scalapb.descriptors.PString(_)).getOrElse(_root_.scalapb.descriptors.PEmpty)
      }
    }
    override def toString: String = _root_.com.trueaccord.scalapb.TextFormat.printToUnicodeString(this)
    def companion = org.apache.mesos.v1.mesos.WeightInfo
}

object WeightInfo extends com.trueaccord.scalapb.GeneratedMessageCompanion[org.apache.mesos.v1.mesos.WeightInfo] {
  implicit def messageCompanion: com.trueaccord.scalapb.GeneratedMessageCompanion[org.apache.mesos.v1.mesos.WeightInfo] = this
  def fromFieldsMap(__fieldsMap: scala.collection.immutable.Map[_root_.com.google.protobuf.Descriptors.FieldDescriptor, scala.Any]): org.apache.mesos.v1.mesos.WeightInfo = {
    require(__fieldsMap.keys.forall(_.getContainingType() == javaDescriptor), "FieldDescriptor does not match message type.")
    val __fields = javaDescriptor.getFields
    org.apache.mesos.v1.mesos.WeightInfo(
      __fieldsMap(__fields.get(0)).asInstanceOf[Double],
      __fieldsMap.get(__fields.get(1)).asInstanceOf[scala.Option[String]]
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[org.apache.mesos.v1.mesos.WeightInfo] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      require(__fieldsMap.keys.forall(_.containingMessage == scalaDescriptor), "FieldDescriptor does not match message type.")
      org.apache.mesos.v1.mesos.WeightInfo(
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).get.as[Double],
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).flatMap(_.as[scala.Option[String]])
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = MesosProto.javaDescriptor.getMessageTypes.get(68)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = MesosProto.scalaDescriptor.messages(68)
  def messageCompanionForFieldNumber(__fieldNumber: Int): _root_.com.trueaccord.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__fieldNumber)
  def enumCompanionForFieldNumber(__fieldNumber: Int): _root_.com.trueaccord.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = org.apache.mesos.v1.mesos.WeightInfo(
    weight = 0.0
  )
  implicit class WeightInfoLens[UpperPB](_l: _root_.com.trueaccord.lenses.Lens[UpperPB, org.apache.mesos.v1.mesos.WeightInfo]) extends _root_.com.trueaccord.lenses.ObjectLens[UpperPB, org.apache.mesos.v1.mesos.WeightInfo](_l) {
    def weight: _root_.com.trueaccord.lenses.Lens[UpperPB, Double] = field(_.weight)((c_, f_) => c_.copy(weight = f_))
    def role: _root_.com.trueaccord.lenses.Lens[UpperPB, String] = field(_.getRole)((c_, f_) => c_.copy(role = Some(f_)))
    def optionalRole: _root_.com.trueaccord.lenses.Lens[UpperPB, scala.Option[String]] = field(_.role)((c_, f_) => c_.copy(role = f_))
  }
  final val WEIGHT_FIELD_NUMBER = 1
  final val ROLE_FIELD_NUMBER = 2
}