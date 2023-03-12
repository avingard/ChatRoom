package com.example.chatroom

import ChatMessage
import ChatRoomGrpcKt
import JoinRequest
import chatMessage
import com.google.protobuf.Empty
import com.google.protobuf.empty
import kotlinx.coroutines.flow.*
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap


@Service
class ChatRoomService(private val repository: InMemoryChatRepository) : ChatRoomGrpcKt.ChatRoomCoroutineImplBase() {
    private val rooms: ConcurrentMap<String, MutableSharedFlow<ChatMessage>> = ConcurrentHashMap()

    override fun joinChat(request: JoinRequest): Flow<ChatMessage> =
        repository.all(request.roomId).asFlow()
            .map { buildChatMessage(it) }
            .onCompletion { emitAll(getOrCreateRoom(request.roomId)) }


    override suspend fun send(request: ChatMessage): Empty {
        val room = getOrCreateRoom(request.roomId)
        val message = parseMessage(request)
        repository.add(message)
        room.emit(request)

        return empty { }
    }


    private fun getOrCreateRoom(roomId: String) : MutableSharedFlow<ChatMessage> {
        return rooms.getOrPut(roomId) { MutableSharedFlow() }
    }

    private fun buildChatMessage(message: Message) = chatMessage {
        messageId = message.id
        content = message.content
        roomId = message.roomId
        userId = message.content
        timestamp = message.timestamp
    }

    private fun parseMessage(message: ChatMessage): Message {
        return Message(
            userId = message.userId,
            roomId = message.roomId,
            content = message.content,
            id = message.messageId,
            timestamp = message.timestamp
        )
    }
}