// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pm_Service.proto

package pm_Service;

public final class pm_ServiceImpl {
  private pm_ServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pm_Service_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pm_Service_Empty_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pm_Service_PMatter_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pm_Service_PMatter_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pm_Service_Requestpms_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pm_Service_Requestpms_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pm_Service_Responsepms_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pm_Service_Responsepms_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pm_Service_DensityRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pm_Service_DensityRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pm_Service_DensityResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pm_Service_DensityResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020pm_Service.proto\022\npm_Service\"\007\n\005Empty\"" +
      "8\n\007PMatter\022\014\n\004pmID\030\001 \001(\t\022\016\n\006status\030\002 \001(\t" +
      "\022\017\n\007density\030\003 \001(\005\"\034\n\nRequestpms\022\016\n\006switc" +
      "h\030\001 \001(\010\"\035\n\013Responsepms\022\016\n\006switch\030\001 \001(\010\"!" +
      "\n\016DensityRequest\022\017\n\007density\030\001 \001(\005\"\"\n\017Den" +
      "sityResponse\022\017\n\007density\030\001 \001(\0052\320\001\n\npm_Ser" +
      "vice\022:\n\016pmQualityTrack\022\021.pm_Service.Empt" +
      "y\032\023.pm_Service.PMatter\"\000\022<\n\007pmOnOff\022\026.pm" +
      "_Service.Requestpms\032\027.pm_Service.Respons" +
      "epms\"\000\022H\n\tpmDensity\022\032.pm_Service.Density" +
      "Request\032\033.pm_Service.DensityResponse\"\000(\001" +
      "B\036\n\npm_ServiceB\016pm_ServiceImplP\001b\006proto3"
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
    internal_static_pm_Service_Empty_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_pm_Service_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pm_Service_Empty_descriptor,
        new java.lang.String[] { });
    internal_static_pm_Service_PMatter_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_pm_Service_PMatter_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pm_Service_PMatter_descriptor,
        new java.lang.String[] { "PmID", "Status", "Density", });
    internal_static_pm_Service_Requestpms_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_pm_Service_Requestpms_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pm_Service_Requestpms_descriptor,
        new java.lang.String[] { "Switch", });
    internal_static_pm_Service_Responsepms_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_pm_Service_Responsepms_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pm_Service_Responsepms_descriptor,
        new java.lang.String[] { "Switch", });
    internal_static_pm_Service_DensityRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_pm_Service_DensityRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pm_Service_DensityRequest_descriptor,
        new java.lang.String[] { "Density", });
    internal_static_pm_Service_DensityResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_pm_Service_DensityResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pm_Service_DensityResponse_descriptor,
        new java.lang.String[] { "Density", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
