package ozoneService;

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
    comments = "Source: ozoneService.proto")
public final class ozoneServiceGrpc {

  private ozoneServiceGrpc() {}

  public static final String SERVICE_NAME = "ozoneService.ozoneService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ozoneService.requestLocalArea,
      ozoneService.responseByArea> getOzoneTrackMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ozoneTrack",
      requestType = ozoneService.requestLocalArea.class,
      responseType = ozoneService.responseByArea.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ozoneService.requestLocalArea,
      ozoneService.responseByArea> getOzoneTrackMethod() {
    io.grpc.MethodDescriptor<ozoneService.requestLocalArea, ozoneService.responseByArea> getOzoneTrackMethod;
    if ((getOzoneTrackMethod = ozoneServiceGrpc.getOzoneTrackMethod) == null) {
      synchronized (ozoneServiceGrpc.class) {
        if ((getOzoneTrackMethod = ozoneServiceGrpc.getOzoneTrackMethod) == null) {
          ozoneServiceGrpc.getOzoneTrackMethod = getOzoneTrackMethod = 
              io.grpc.MethodDescriptor.<ozoneService.requestLocalArea, ozoneService.responseByArea>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "ozoneService.ozoneService", "ozoneTrack"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ozoneService.requestLocalArea.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ozoneService.responseByArea.getDefaultInstance()))
                  .setSchemaDescriptor(new ozoneServiceMethodDescriptorSupplier("ozoneTrack"))
                  .build();
          }
        }
     }
     return getOzoneTrackMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ozoneServiceStub newStub(io.grpc.Channel channel) {
    return new ozoneServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ozoneServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ozoneServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ozoneServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ozoneServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class ozoneServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * server
     * </pre>
     */
    public void ozoneTrack(ozoneService.requestLocalArea request,
        io.grpc.stub.StreamObserver<ozoneService.responseByArea> responseObserver) {
      asyncUnimplementedUnaryCall(getOzoneTrackMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getOzoneTrackMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ozoneService.requestLocalArea,
                ozoneService.responseByArea>(
                  this, METHODID_OZONE_TRACK)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class ozoneServiceStub extends io.grpc.stub.AbstractStub<ozoneServiceStub> {
    private ozoneServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ozoneServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ozoneServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ozoneServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * server
     * </pre>
     */
    public void ozoneTrack(ozoneService.requestLocalArea request,
        io.grpc.stub.StreamObserver<ozoneService.responseByArea> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getOzoneTrackMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class ozoneServiceBlockingStub extends io.grpc.stub.AbstractStub<ozoneServiceBlockingStub> {
    private ozoneServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ozoneServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ozoneServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ozoneServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * server
     * </pre>
     */
    public java.util.Iterator<ozoneService.responseByArea> ozoneTrack(
        ozoneService.requestLocalArea request) {
      return blockingServerStreamingCall(
          getChannel(), getOzoneTrackMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class ozoneServiceFutureStub extends io.grpc.stub.AbstractStub<ozoneServiceFutureStub> {
    private ozoneServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ozoneServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ozoneServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ozoneServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_OZONE_TRACK = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ozoneServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ozoneServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_OZONE_TRACK:
          serviceImpl.ozoneTrack((ozoneService.requestLocalArea) request,
              (io.grpc.stub.StreamObserver<ozoneService.responseByArea>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ozoneServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ozoneServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ozoneService.ozoneServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ozoneService");
    }
  }

  private static final class ozoneServiceFileDescriptorSupplier
      extends ozoneServiceBaseDescriptorSupplier {
    ozoneServiceFileDescriptorSupplier() {}
  }

  private static final class ozoneServiceMethodDescriptorSupplier
      extends ozoneServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ozoneServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ozoneServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ozoneServiceFileDescriptorSupplier())
              .addMethod(getOzoneTrackMethod())
              .build();
        }
      }
    }
    return result;
  }
}
