// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ozoneService.proto

package ozoneService;

public final class ozoneServiceImpl {
  private ozoneServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ozoneService_requestLocalArea_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ozoneService_requestLocalArea_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ozoneService_responseByArea_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ozoneService_responseByArea_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022ozoneService.proto\022\014ozoneService\"1\n\020re" +
      "questLocalArea\022\017\n\007country\030\001 \001(\t\022\014\n\004city\030" +
      "\002 \001(\t\"K\n\016responseByArea\022\014\n\004city\030\001 \001(\t\022\r\n" +
      "\005index\030\002 \001(\005\022\014\n\004band\030\003 \001(\t\022\016\n\006advice\030\004 \001" +
      "(\t2^\n\014ozoneService\022N\n\nozoneTrack\022\036.ozone" +
      "Service.requestLocalArea\032\034.ozoneService." +
      "responseByArea\"\0000\001B\"\n\014ozoneServiceB\020ozon" +
      "eServiceImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_ozoneService_requestLocalArea_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ozoneService_requestLocalArea_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ozoneService_requestLocalArea_descriptor,
        new java.lang.String[] { "Country", "City", });
    internal_static_ozoneService_responseByArea_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ozoneService_responseByArea_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ozoneService_responseByArea_descriptor,
        new java.lang.String[] { "City", "Index", "Band", "Advice", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}