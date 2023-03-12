import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.53.0)",
    comments = "Source: chatroom.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ChatRoomGrpc {

  private ChatRoomGrpc() {}

  public static final String SERVICE_NAME = "ChatRoom";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<JoinRequest,
      ChatMessage> getJoinChatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "JoinChat",
      requestType = JoinRequest.class,
      responseType = ChatMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<JoinRequest,
      ChatMessage> getJoinChatMethod() {
    io.grpc.MethodDescriptor<JoinRequest, ChatMessage> getJoinChatMethod;
    if ((getJoinChatMethod = ChatRoomGrpc.getJoinChatMethod) == null) {
      synchronized (ChatRoomGrpc.class) {
        if ((getJoinChatMethod = ChatRoomGrpc.getJoinChatMethod) == null) {
          ChatRoomGrpc.getJoinChatMethod = getJoinChatMethod =
              io.grpc.MethodDescriptor.<JoinRequest, ChatMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "JoinChat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  JoinRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ChatMessage.getDefaultInstance()))
              .setSchemaDescriptor(new ChatRoomMethodDescriptorSupplier("JoinChat"))
              .build();
        }
      }
    }
    return getJoinChatMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ChatMessage,
      com.google.protobuf.Empty> getSendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Send",
      requestType = ChatMessage.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ChatMessage,
      com.google.protobuf.Empty> getSendMethod() {
    io.grpc.MethodDescriptor<ChatMessage, com.google.protobuf.Empty> getSendMethod;
    if ((getSendMethod = ChatRoomGrpc.getSendMethod) == null) {
      synchronized (ChatRoomGrpc.class) {
        if ((getSendMethod = ChatRoomGrpc.getSendMethod) == null) {
          ChatRoomGrpc.getSendMethod = getSendMethod =
              io.grpc.MethodDescriptor.<ChatMessage, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Send"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ChatMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ChatRoomMethodDescriptorSupplier("Send"))
              .build();
        }
      }
    }
    return getSendMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChatRoomStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChatRoomStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChatRoomStub>() {
        @java.lang.Override
        public ChatRoomStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChatRoomStub(channel, callOptions);
        }
      };
    return ChatRoomStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChatRoomBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChatRoomBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChatRoomBlockingStub>() {
        @java.lang.Override
        public ChatRoomBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChatRoomBlockingStub(channel, callOptions);
        }
      };
    return ChatRoomBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChatRoomFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChatRoomFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChatRoomFutureStub>() {
        @java.lang.Override
        public ChatRoomFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChatRoomFutureStub(channel, callOptions);
        }
      };
    return ChatRoomFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ChatRoomImplBase implements io.grpc.BindableService {

    /**
     */
    public void joinChat(JoinRequest request,
        io.grpc.stub.StreamObserver<ChatMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getJoinChatMethod(), responseObserver);
    }

    /**
     */
    public void send(ChatMessage request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getJoinChatMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                JoinRequest,
                ChatMessage>(
                  this, METHODID_JOIN_CHAT)))
          .addMethod(
            getSendMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ChatMessage,
                com.google.protobuf.Empty>(
                  this, METHODID_SEND)))
          .build();
    }
  }

  /**
   */
  public static final class ChatRoomStub extends io.grpc.stub.AbstractAsyncStub<ChatRoomStub> {
    private ChatRoomStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatRoomStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChatRoomStub(channel, callOptions);
    }

    /**
     */
    public void joinChat(JoinRequest request,
        io.grpc.stub.StreamObserver<ChatMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getJoinChatMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void send(ChatMessage request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ChatRoomBlockingStub extends io.grpc.stub.AbstractBlockingStub<ChatRoomBlockingStub> {
    private ChatRoomBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatRoomBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChatRoomBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<ChatMessage> joinChat(
        JoinRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getJoinChatMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty send(ChatMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ChatRoomFutureStub extends io.grpc.stub.AbstractFutureStub<ChatRoomFutureStub> {
    private ChatRoomFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatRoomFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChatRoomFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> send(
        ChatMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_JOIN_CHAT = 0;
  private static final int METHODID_SEND = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChatRoomImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChatRoomImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_JOIN_CHAT:
          serviceImpl.joinChat((JoinRequest) request,
              (io.grpc.stub.StreamObserver<ChatMessage>) responseObserver);
          break;
        case METHODID_SEND:
          serviceImpl.send((ChatMessage) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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

  private static abstract class ChatRoomBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChatRoomBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Chatroom.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ChatRoom");
    }
  }

  private static final class ChatRoomFileDescriptorSupplier
      extends ChatRoomBaseDescriptorSupplier {
    ChatRoomFileDescriptorSupplier() {}
  }

  private static final class ChatRoomMethodDescriptorSupplier
      extends ChatRoomBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChatRoomMethodDescriptorSupplier(String methodName) {
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
      synchronized (ChatRoomGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChatRoomFileDescriptorSupplier())
              .addMethod(getJoinChatMethod())
              .addMethod(getSendMethod())
              .build();
        }
      }
    }
    return result;
  }
}
