package waterService;

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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: waterService.proto")
public final class waterServiceGrpc {

  private waterServiceGrpc() {}

  public static final String SERVICE_NAME = "waterService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<waterService.SampleRequest,
      waterService.SampleResponse> getCreateSampleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSample",
      requestType = waterService.SampleRequest.class,
      responseType = waterService.SampleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<waterService.SampleRequest,
      waterService.SampleResponse> getCreateSampleMethod() {
    io.grpc.MethodDescriptor<waterService.SampleRequest, waterService.SampleResponse> getCreateSampleMethod;
    if ((getCreateSampleMethod = waterServiceGrpc.getCreateSampleMethod) == null) {
      synchronized (waterServiceGrpc.class) {
        if ((getCreateSampleMethod = waterServiceGrpc.getCreateSampleMethod) == null) {
          waterServiceGrpc.getCreateSampleMethod = getCreateSampleMethod = 
              io.grpc.MethodDescriptor.<waterService.SampleRequest, waterService.SampleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "waterService", "CreateSample"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  waterService.SampleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  waterService.SampleResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new waterServiceMethodDescriptorSupplier("CreateSample"))
                  .build();
          }
        }
     }
     return getCreateSampleMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static waterServiceStub newStub(io.grpc.Channel channel) {
    return new waterServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static waterServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new waterServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static waterServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new waterServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class waterServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * bidirectional
     * </pre>
     */
    public io.grpc.stub.StreamObserver<waterService.SampleRequest> createSample(
        io.grpc.stub.StreamObserver<waterService.SampleResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getCreateSampleMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateSampleMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                waterService.SampleRequest,
                waterService.SampleResponse>(
                  this, METHODID_CREATE_SAMPLE)))
          .build();
    }
  }

  /**
   */
  public static final class waterServiceStub extends io.grpc.stub.AbstractStub<waterServiceStub> {
    private waterServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private waterServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected waterServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new waterServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * bidirectional
     * </pre>
     */
    public io.grpc.stub.StreamObserver<waterService.SampleRequest> createSample(
        io.grpc.stub.StreamObserver<waterService.SampleResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getCreateSampleMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class waterServiceBlockingStub extends io.grpc.stub.AbstractStub<waterServiceBlockingStub> {
    private waterServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private waterServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected waterServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new waterServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class waterServiceFutureStub extends io.grpc.stub.AbstractStub<waterServiceFutureStub> {
    private waterServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private waterServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected waterServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new waterServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CREATE_SAMPLE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final waterServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(waterServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_SAMPLE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.createSample(
              (io.grpc.stub.StreamObserver<waterService.SampleResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class waterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    waterServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return waterService.waterServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("waterService");
    }
  }

  private static final class waterServiceFileDescriptorSupplier
      extends waterServiceBaseDescriptorSupplier {
    waterServiceFileDescriptorSupplier() {}
  }

  private static final class waterServiceMethodDescriptorSupplier
      extends waterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    waterServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (waterServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new waterServiceFileDescriptorSupplier())
              .addMethod(getCreateSampleMethod())
              .build();
        }
      }
    }
    return result;
  }
}
