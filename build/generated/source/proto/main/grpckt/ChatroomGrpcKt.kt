import com.google.protobuf.Empty
import io.grpc.CallOptions
import io.grpc.CallOptions.DEFAULT
import io.grpc.Channel
import io.grpc.Metadata
import io.grpc.MethodDescriptor
import io.grpc.ServerServiceDefinition
import io.grpc.ServerServiceDefinition.builder
import io.grpc.ServiceDescriptor
import io.grpc.Status
import io.grpc.Status.UNIMPLEMENTED
import io.grpc.StatusException
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls.serverStreamingRpc
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls.serverStreamingServerMethodDefinition
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import io.grpc.kotlin.StubFor
import kotlin.String
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic
import kotlinx.coroutines.flow.Flow

/**
 * Holder for Kotlin coroutine-based client and server APIs for ChatRoom.
 */
public object ChatRoomGrpcKt {
  public const val SERVICE_NAME: String = ChatRoomGrpc.SERVICE_NAME

  @JvmStatic
  public val serviceDescriptor: ServiceDescriptor
    get() = ChatRoomGrpc.getServiceDescriptor()

  public val joinChatMethod: MethodDescriptor<JoinRequest, ChatMessage>
    @JvmStatic
    get() = ChatRoomGrpc.getJoinChatMethod()

  public val sendMethod: MethodDescriptor<ChatMessage, Empty>
    @JvmStatic
    get() = ChatRoomGrpc.getSendMethod()

  /**
   * A stub for issuing RPCs to a(n) ChatRoom service as suspending coroutines.
   */
  @StubFor(ChatRoomGrpc::class)
  public class ChatRoomCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT,
  ) : AbstractCoroutineStub<ChatRoomCoroutineStub>(channel, callOptions) {
    public override fun build(channel: Channel, callOptions: CallOptions): ChatRoomCoroutineStub =
        ChatRoomCoroutineStub(channel, callOptions)

    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun joinChat(request: JoinRequest, headers: Metadata = Metadata()): Flow<ChatMessage> =
        serverStreamingRpc(
      channel,
      ChatRoomGrpc.getJoinChatMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun send(request: ChatMessage, headers: Metadata = Metadata()): Empty = unaryRpc(
      channel,
      ChatRoomGrpc.getSendMethod(),
      request,
      callOptions,
      headers
    )
  }

  /**
   * Skeletal implementation of the ChatRoom service based on Kotlin coroutines.
   */
  public abstract class ChatRoomCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns a [Flow] of responses to an RPC for ChatRoom.JoinChat.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open fun joinChat(request: JoinRequest): Flow<ChatMessage> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method ChatRoom.JoinChat is unimplemented"))

    /**
     * Returns the response to an RPC for ChatRoom.Send.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun send(request: ChatMessage): Empty = throw
        StatusException(UNIMPLEMENTED.withDescription("Method ChatRoom.Send is unimplemented"))

    public final override fun bindService(): ServerServiceDefinition =
        builder(ChatRoomGrpc.getServiceDescriptor())
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = ChatRoomGrpc.getJoinChatMethod(),
      implementation = ::joinChat
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = ChatRoomGrpc.getSendMethod(),
      implementation = ::send
    )).build()
  }
}
