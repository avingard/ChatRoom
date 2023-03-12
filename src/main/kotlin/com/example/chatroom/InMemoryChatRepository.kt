package com.example.chatroom

import com.google.protobuf.Timestamp
import org.springframework.stereotype.Repository
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

@Repository
class InMemoryChatRepository {
    private val store: ConcurrentMap<String, ConcurrentMap<String, Message>> = ConcurrentHashMap()

    fun add(message: Message) {
        val roomMessages = getOrCreateRoomDb(message.roomId)
        roomMessages[message.id] = message
    }

    fun remove(message: Message) {
        val roomMessages = getOrCreateRoomDb(message.roomId)
        roomMessages.remove(message.id)
    }

    fun update(message: Message) {
        val roomMessages = getOrCreateRoomDb(message.roomId)
        roomMessages[message.id] = message
    }

    fun all(roomId: String): List<Message> = getOrCreateRoomDb(roomId).values.toList().sortedBy { it.timestamp.seconds }

    fun get(roomId: String, messageId: String): Message? = getOrCreateRoomDb(roomId)[messageId]

    fun getOrCreateRoomDb(roomId: String): ConcurrentMap<String, Message> {
        return store.getOrPut(roomId) { ConcurrentHashMap() }
    }
}


data class Message(
    val userId: String,
    val content: String,
    val id: String,
    val roomId: String,
    val timestamp: Timestamp
)