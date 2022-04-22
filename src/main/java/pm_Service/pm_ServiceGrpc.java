package pm_Service;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: pm_Service.proto")
public final class pm_ServiceGrpc {

  private pm_ServiceGrpc() {}

  public static final String SERVICE_NAME = "pm_Service.pm_Service";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<pm_Service.Empty,
      pm_Service.PMatter> getPmQualityTrackMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "pmQualityTrack",
      requestType = pm_Service.Empty.class,
      responseType = pm_Service.PMatter.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pm_Service.Empty,
      pm_Service.PMatter> getPmQualityTrackMethod() {
    io.grpc.MethodDescriptor<pm_Service.Empty, pm_Service.PMatter> getPmQualityTrackMethod;
    if ((getPmQualityTrackMethod = pm_ServiceGrpc.getPmQualityTrackMethod) == null) {
      synchronized (pm_ServiceGrpc.class) {
        if ((getPmQualityTrackMethod = pm_ServiceGrpc.getPmQualityTrackMethod) == null) {
          pm_ServiceGrpc.getPmQualityTrackMethod = getPmQualityTrackMethod = 
              io.grpc.MethodDescriptor.<pm_Service.Empty, pm_Service.PMatter>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "pm_Service.pm_Service", "pmQualityTrack"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pm_Service.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pm_Service.PMatter.getDefaultInstance()))
                  .setSchemaDescriptor(new pm_ServiceMethodDescriptorSupplier("pmQualityTrack"))
                  .build();
          }
        }
     }
     return getPmQualityTrackMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pm_Service.Requestpms,
      pm_Service.Responsepms> getPmOnOffMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "pmOnOff",
      requestType = pm_Service.Requestpms.class,
      responseType = pm_Service.Responsepms.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pm_Service.Requestpms,
      pm_Service.Responsepms> getPmOnOffMethod() {
    io.grpc.MethodDescriptor<pm_Service.Requestpms, pm_Service.Responsepms> getPmOnOffMethod;
    if ((getPmOnOffMethod = pm_ServiceGrpc.getPmOnOffMethod) == null) {
      synchronized (pm_ServiceGrpc.class) {
        if ((getPmOnOffMethod = pm_ServiceGrpc.getPmOnOffMethod) == null) {
          pm_ServiceGrpc.getPmOnOffMethod = getPmOnOffMethod = 
              io.grpc.MethodDescriptor.<pm_Service.Requestpms, pm_Service.Responsepms>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "pm_Service.pm_Service", "pmOnOff"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pm_Service.Requestpms.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pm_Service.Responsepms.getDefaultInstance()))
                  .setSchemaDescriptor(new pm_ServiceMethodDescriptorSupplier("pmOnOff"))
                  .build();
          }
        }
     }
     return getPmOnOffMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pm_Service.DensityRequest,
      pm_Service.DensityResponse> getPmDensityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "pmDensity",
      requestType = pm_Service.DensityRequest.class,
      responseType = pm_Service.DensityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<pm_Service.DensityRequest,
      pm_Service.DensityResponse> getPmDensityMethod() {
    io.grpc.MethodDescriptor<pm_Service.DensityRequest, pm_Service.DensityResponse> getPmDensityMethod;
    if ((getPmDensityMethod = pm_ServiceGrpc.getPmDensityMethod) == null) {
      synchronized (pm_ServiceGrpc.class) {
        if ((getPmDensityMethod = pm_ServiceGrpc.getPmDensityMethod) == null) {
          pm_ServiceGrpc.getPmDensityMethod = getPmDensityMethod = 
              io.grpc.MethodDescriptor.<pm_Service.DensityRequest, pm_Service.DensityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "pm_Service.pm_Service", "pmDensity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pm_Service.DensityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pm_Service.DensityResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new pm_ServiceMethodDescriptorSupplier("pmDensity"))
                  .build();
          }
        }
     }
     return getPmDensityMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static pm_ServiceStub newStub(io.grpc.Channel channel) {
    return new pm_ServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static pm_ServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new pm_ServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static pm_ServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new pm_ServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class pm_ServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * unary
     * </pre>
     */
    public void pmQualityTrack(pm_Service.Empty request,
        io.grpc.stub.StreamObserver<pm_Service.PMatter> responseObserver) {
      asyncUnimplementedUnaryCall(getPmQualityTrackMethod(), responseObserver);
    }

    /**
     * <pre>
     * unary
     * </pre>
     */
    public void pmOnOff(pm_Service.Requestpms request,
        io.grpc.stub.StreamObserver<pm_Service.Responsepms> responseObserver) {
      asyncUnimplementedUnaryCall(getPmOnOffMethod(), responseObserver);
    }

    /**
     * <pre>
     * client
     * </pre>
     */
    public io.grpc.stub.StreamObserver<pm_Service.DensityRequest> pmDensity(
        io.grpc.stub.StreamObserver<pm_Service.DensityResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getPmDensityMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPmQualityTrackMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                pm_Service.Empty,
                pm_Service.PMatter>(
                  this, METHODID_PM_QUALITY_TRACK)))
          .addMethod(
            getPmOnOffMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                pm_Service.Requestpms,
                pm_Service.Responsepms>(
                  this, METHODID_PM_ON_OFF)))
          .addMethod(
            getPmDensityMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                pm_Service.DensityRequest,
                pm_Service.DensityResponse>(
                  this, METHODID_PM_DENSITY)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class pm_ServiceStub extends io.grpc.stub.AbstractStub<pm_ServiceStub> {
    private pm_ServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private pm_ServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected pm_ServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new pm_ServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary
     * </pre>
     */
    public void pmQualityTrack(pm_Service.Empty request,
        io.grpc.stub.StreamObserver<pm_Service.PMatter> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPmQualityTrackMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * unary
     * </pre>
     */
    public void pmOnOff(pm_Service.Requestpms request,
        io.grpc.stub.StreamObserver<pm_Service.Responsepms> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPmOnOffMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * client
     * </pre>
     */
    public io.grpc.stub.StreamObserver<pm_Service.DensityRequest> pmDensity(
        io.grpc.stub.StreamObserver<pm_Service.DensityResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getPmDensityMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class pm_ServiceBlockingStub extends io.grpc.stub.AbstractStub<pm_ServiceBlockingStub> {
    private pm_ServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private pm_ServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected pm_ServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new pm_ServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary
     * </pre>
     */
    public pm_Service.PMatter pmQualityTrack(pm_Service.Empty request) {
      return blockingUnaryCall(
          getChannel(), getPmQualityTrackMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * unary
     * </pre>
     */
    public pm_Service.Responsepms pmOnOff(pm_Service.Requestpms request) {
      return blockingUnaryCall(
          getChannel(), getPmOnOffMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class pm_ServiceFutureStub extends io.grpc.stub.AbstractStub<pm_ServiceFutureStub> {
    private pm_ServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private pm_ServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected pm_ServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new pm_ServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<pm_Service.PMatter> pmQualityTrack(
        pm_Service.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getPmQualityTrackMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<pm_Service.Responsepms> pmOnOff(
        pm_Service.Requestpms request) {
      return futureUnaryCall(
          getChannel().newCall(getPmOnOffMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PM_QUALITY_TRACK = 0;
  private static final int METHODID_PM_ON_OFF = 1;
  private static final int METHODID_PM_DENSITY = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final pm_ServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(pm_ServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PM_QUALITY_TRACK:
          serviceImpl.pmQualityTrack((pm_Service.Empty) request,
              (io.grpc.stub.StreamObserver<pm_Service.PMatter>) responseObserver);
          break;
        case METHODID_PM_ON_OFF:
          serviceImpl.pmOnOff((pm_Service.Requestpms) request,
              (io.grpc.stub.StreamObserver<pm_Service.Responsepms>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PM_DENSITY:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.pmDensity(
              (io.grpc.stub.StreamObserver<pm_Service.DensityResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class pm_ServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    pm_ServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return pm_Service.pm_ServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("pm_Service");
    }
  }

  private static final class pm_ServiceFileDescriptorSupplier
      extends pm_ServiceBaseDescriptorSupplier {
    pm_ServiceFileDescriptorSupplier() {}
  }

  private static final class pm_ServiceMethodDescriptorSupplier
      extends pm_ServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    pm_ServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (pm_ServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new pm_ServiceFileDescriptorSupplier())
              .addMethod(getPmQualityTrackMethod())
              .addMethod(getPmOnOffMethod())
              .addMethod(getPmDensityMethod())
              .build();
        }
      }
    }
    return result;
  }
}
