// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO2

package org.apache.mesos.v1.mesos

/** *
  * Describes a device whitelist entry that expose from host to container.
  */
@SerialVersionUID(0L)
final case class DeviceAccess(
    device: org.apache.mesos.v1.mesos.Device,
    access: org.apache.mesos.v1.mesos.DeviceAccess.Access
    ) extends com.trueaccord.scalapb.GeneratedMessage with com.trueaccord.scalapb.Message[DeviceAccess] with com.trueaccord.lenses.Updatable[DeviceAccess] {
    @transient
    private[this] var __serializedSizeCachedValue: Int = 0
    private[this] def __computeSerializedValue(): Int = {
      var __size = 0
      __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(device.serializedSize) + device.serializedSize
      __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(access.serializedSize) + access.serializedSize
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
      _output__.writeTag(1, 2)
      _output__.writeUInt32NoTag(device.serializedSize)
      device.writeTo(_output__)
      _output__.writeTag(2, 2)
      _output__.writeUInt32NoTag(access.serializedSize)
      access.writeTo(_output__)
    }
    def mergeFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): org.apache.mesos.v1.mesos.DeviceAccess = {
      var __device = this.device
      var __access = this.access
      var __requiredFields0: Long = 0x3L
      var _done__ = false
      while (!_done__) {
        val _tag__ = _input__.readTag()
        _tag__ match {
          case 0 => _done__ = true
          case 10 =>
            __device = _root_.com.trueaccord.scalapb.LiteParser.readMessage(_input__, __device)
            __requiredFields0 &= 0xfffffffffffffffeL
          case 18 =>
            __access = _root_.com.trueaccord.scalapb.LiteParser.readMessage(_input__, __access)
            __requiredFields0 &= 0xfffffffffffffffdL
          case tag => _input__.skipField(tag)
        }
      }
      if (__requiredFields0 != 0L) { throw new _root_.com.google.protobuf.InvalidProtocolBufferException("Message missing required fields.") } 
      org.apache.mesos.v1.mesos.DeviceAccess(
          device = __device,
          access = __access
      )
    }
    def withDevice(__v: org.apache.mesos.v1.mesos.Device): DeviceAccess = copy(device = __v)
    def withAccess(__v: org.apache.mesos.v1.mesos.DeviceAccess.Access): DeviceAccess = copy(access = __v)
    def getFieldByNumber(__fieldNumber: Int): scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => device
        case 2 => access
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => device.toPMessage
        case 2 => access.toPMessage
      }
    }
    override def toString: String = _root_.com.trueaccord.scalapb.TextFormat.printToUnicodeString(this)
    def companion = org.apache.mesos.v1.mesos.DeviceAccess
}

object DeviceAccess extends com.trueaccord.scalapb.GeneratedMessageCompanion[org.apache.mesos.v1.mesos.DeviceAccess] {
  implicit def messageCompanion: com.trueaccord.scalapb.GeneratedMessageCompanion[org.apache.mesos.v1.mesos.DeviceAccess] = this
  def fromFieldsMap(__fieldsMap: scala.collection.immutable.Map[_root_.com.google.protobuf.Descriptors.FieldDescriptor, scala.Any]): org.apache.mesos.v1.mesos.DeviceAccess = {
    require(__fieldsMap.keys.forall(_.getContainingType() == javaDescriptor), "FieldDescriptor does not match message type.")
    val __fields = javaDescriptor.getFields
    org.apache.mesos.v1.mesos.DeviceAccess(
      __fieldsMap(__fields.get(0)).asInstanceOf[org.apache.mesos.v1.mesos.Device],
      __fieldsMap(__fields.get(1)).asInstanceOf[org.apache.mesos.v1.mesos.DeviceAccess.Access]
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[org.apache.mesos.v1.mesos.DeviceAccess] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      require(__fieldsMap.keys.forall(_.containingMessage == scalaDescriptor), "FieldDescriptor does not match message type.")
      org.apache.mesos.v1.mesos.DeviceAccess(
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).get.as[org.apache.mesos.v1.mesos.Device],
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).get.as[org.apache.mesos.v1.mesos.DeviceAccess.Access]
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = MesosProto.javaDescriptor.getMessageTypes.get(75)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = MesosProto.scalaDescriptor.messages(75)
  def messageCompanionForFieldNumber(__fieldNumber: Int): _root_.com.trueaccord.scalapb.GeneratedMessageCompanion[_] = {
    var __out: _root_.com.trueaccord.scalapb.GeneratedMessageCompanion[_] = null
    (__fieldNumber: @_root_.scala.unchecked) match {
      case 1 => __out = org.apache.mesos.v1.mesos.Device
      case 2 => __out = org.apache.mesos.v1.mesos.DeviceAccess.Access
    }
    __out
  }
  def enumCompanionForFieldNumber(__fieldNumber: Int): _root_.com.trueaccord.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = org.apache.mesos.v1.mesos.DeviceAccess(
    device = org.apache.mesos.v1.mesos.Device.defaultInstance,
    access = org.apache.mesos.v1.mesos.DeviceAccess.Access.defaultInstance
  )
  @SerialVersionUID(0L)
  final case class Access(
      read: scala.Option[Boolean] = None,
      write: scala.Option[Boolean] = None,
      mknod: scala.Option[Boolean] = None
      ) extends com.trueaccord.scalapb.GeneratedMessage with com.trueaccord.scalapb.Message[Access] with com.trueaccord.lenses.Updatable[Access] {
      @transient
      private[this] var __serializedSizeCachedValue: Int = 0
      private[this] def __computeSerializedValue(): Int = {
        var __size = 0
        if (read.isDefined) { __size += _root_.com.google.protobuf.CodedOutputStream.computeBoolSize(1, read.get) }
        if (write.isDefined) { __size += _root_.com.google.protobuf.CodedOutputStream.computeBoolSize(2, write.get) }
        if (mknod.isDefined) { __size += _root_.com.google.protobuf.CodedOutputStream.computeBoolSize(3, mknod.get) }
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
        read.foreach { __v =>
          _output__.writeBool(1, __v)
        };
        write.foreach { __v =>
          _output__.writeBool(2, __v)
        };
        mknod.foreach { __v =>
          _output__.writeBool(3, __v)
        };
      }
      def mergeFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): org.apache.mesos.v1.mesos.DeviceAccess.Access = {
        var __read = this.read
        var __write = this.write
        var __mknod = this.mknod
        var _done__ = false
        while (!_done__) {
          val _tag__ = _input__.readTag()
          _tag__ match {
            case 0 => _done__ = true
            case 8 =>
              __read = Some(_input__.readBool())
            case 16 =>
              __write = Some(_input__.readBool())
            case 24 =>
              __mknod = Some(_input__.readBool())
            case tag => _input__.skipField(tag)
          }
        }
        org.apache.mesos.v1.mesos.DeviceAccess.Access(
            read = __read,
            write = __write,
            mknod = __mknod
        )
      }
      def getRead: Boolean = read.getOrElse(false)
      def clearRead: Access = copy(read = None)
      def withRead(__v: Boolean): Access = copy(read = Some(__v))
      def getWrite: Boolean = write.getOrElse(false)
      def clearWrite: Access = copy(write = None)
      def withWrite(__v: Boolean): Access = copy(write = Some(__v))
      def getMknod: Boolean = mknod.getOrElse(false)
      def clearMknod: Access = copy(mknod = None)
      def withMknod(__v: Boolean): Access = copy(mknod = Some(__v))
      def getFieldByNumber(__fieldNumber: Int): scala.Any = {
        (__fieldNumber: @_root_.scala.unchecked) match {
          case 1 => read.orNull
          case 2 => write.orNull
          case 3 => mknod.orNull
        }
      }
      def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
        require(__field.containingMessage eq companion.scalaDescriptor)
        (__field.number: @_root_.scala.unchecked) match {
          case 1 => read.map(_root_.scalapb.descriptors.PBoolean(_)).getOrElse(_root_.scalapb.descriptors.PEmpty)
          case 2 => write.map(_root_.scalapb.descriptors.PBoolean(_)).getOrElse(_root_.scalapb.descriptors.PEmpty)
          case 3 => mknod.map(_root_.scalapb.descriptors.PBoolean(_)).getOrElse(_root_.scalapb.descriptors.PEmpty)
        }
      }
      override def toString: String = _root_.com.trueaccord.scalapb.TextFormat.printToUnicodeString(this)
      def companion = org.apache.mesos.v1.mesos.DeviceAccess.Access
  }
  
  object Access extends com.trueaccord.scalapb.GeneratedMessageCompanion[org.apache.mesos.v1.mesos.DeviceAccess.Access] {
    implicit def messageCompanion: com.trueaccord.scalapb.GeneratedMessageCompanion[org.apache.mesos.v1.mesos.DeviceAccess.Access] = this
    def fromFieldsMap(__fieldsMap: scala.collection.immutable.Map[_root_.com.google.protobuf.Descriptors.FieldDescriptor, scala.Any]): org.apache.mesos.v1.mesos.DeviceAccess.Access = {
      require(__fieldsMap.keys.forall(_.getContainingType() == javaDescriptor), "FieldDescriptor does not match message type.")
      val __fields = javaDescriptor.getFields
      org.apache.mesos.v1.mesos.DeviceAccess.Access(
        __fieldsMap.get(__fields.get(0)).asInstanceOf[scala.Option[Boolean]],
        __fieldsMap.get(__fields.get(1)).asInstanceOf[scala.Option[Boolean]],
        __fieldsMap.get(__fields.get(2)).asInstanceOf[scala.Option[Boolean]]
      )
    }
    implicit def messageReads: _root_.scalapb.descriptors.Reads[org.apache.mesos.v1.mesos.DeviceAccess.Access] = _root_.scalapb.descriptors.Reads{
      case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
        require(__fieldsMap.keys.forall(_.containingMessage == scalaDescriptor), "FieldDescriptor does not match message type.")
        org.apache.mesos.v1.mesos.DeviceAccess.Access(
          __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).flatMap(_.as[scala.Option[Boolean]]),
          __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).flatMap(_.as[scala.Option[Boolean]]),
          __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).flatMap(_.as[scala.Option[Boolean]])
        )
      case _ => throw new RuntimeException("Expected PMessage")
    }
    def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = org.apache.mesos.v1.mesos.DeviceAccess.javaDescriptor.getNestedTypes.get(0)
    def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = org.apache.mesos.v1.mesos.DeviceAccess.scalaDescriptor.nestedMessages(0)
    def messageCompanionForFieldNumber(__fieldNumber: Int): _root_.com.trueaccord.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__fieldNumber)
    def enumCompanionForFieldNumber(__fieldNumber: Int): _root_.com.trueaccord.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
    lazy val defaultInstance = org.apache.mesos.v1.mesos.DeviceAccess.Access(
    )
    implicit class AccessLens[UpperPB](_l: _root_.com.trueaccord.lenses.Lens[UpperPB, org.apache.mesos.v1.mesos.DeviceAccess.Access]) extends _root_.com.trueaccord.lenses.ObjectLens[UpperPB, org.apache.mesos.v1.mesos.DeviceAccess.Access](_l) {
      def read: _root_.com.trueaccord.lenses.Lens[UpperPB, Boolean] = field(_.getRead)((c_, f_) => c_.copy(read = Some(f_)))
      def optionalRead: _root_.com.trueaccord.lenses.Lens[UpperPB, scala.Option[Boolean]] = field(_.read)((c_, f_) => c_.copy(read = f_))
      def write: _root_.com.trueaccord.lenses.Lens[UpperPB, Boolean] = field(_.getWrite)((c_, f_) => c_.copy(write = Some(f_)))
      def optionalWrite: _root_.com.trueaccord.lenses.Lens[UpperPB, scala.Option[Boolean]] = field(_.write)((c_, f_) => c_.copy(write = f_))
      def mknod: _root_.com.trueaccord.lenses.Lens[UpperPB, Boolean] = field(_.getMknod)((c_, f_) => c_.copy(mknod = Some(f_)))
      def optionalMknod: _root_.com.trueaccord.lenses.Lens[UpperPB, scala.Option[Boolean]] = field(_.mknod)((c_, f_) => c_.copy(mknod = f_))
    }
    final val READ_FIELD_NUMBER = 1
    final val WRITE_FIELD_NUMBER = 2
    final val MKNOD_FIELD_NUMBER = 3
  }
  
  implicit class DeviceAccessLens[UpperPB](_l: _root_.com.trueaccord.lenses.Lens[UpperPB, org.apache.mesos.v1.mesos.DeviceAccess]) extends _root_.com.trueaccord.lenses.ObjectLens[UpperPB, org.apache.mesos.v1.mesos.DeviceAccess](_l) {
    def device: _root_.com.trueaccord.lenses.Lens[UpperPB, org.apache.mesos.v1.mesos.Device] = field(_.device)((c_, f_) => c_.copy(device = f_))
    def access: _root_.com.trueaccord.lenses.Lens[UpperPB, org.apache.mesos.v1.mesos.DeviceAccess.Access] = field(_.access)((c_, f_) => c_.copy(access = f_))
  }
  final val DEVICE_FIELD_NUMBER = 1
  final val ACCESS_FIELD_NUMBER = 2
}