package com.example.chatroom

import io.grpc.Server
import io.grpc.ServerBuilder

class ChatRoomServer(
    val server: Server
) {

    fun start() {
        server.start()
        println("Server started, listening on ${server.port}")
        Runtime.getRuntime().addShutdownHook(
            Thread {
                println("Shutting down gRPC server since JVM is shutting down")
                this@ChatRoomServer.stop()
                println("Server shut down")
            }
        )
    }

    fun stop() {
        server.shutdown()
    }

    fun blockUntilShutdown() {
        server.awaitTermination()
    }


    companion object {
        fun build(port: Int = 8080, service: ChatRoomService): ChatRoomServer {
            val server = ServerBuilder.forPort(port)
                .addService(service)
                .build()

            return ChatRoomServer(server)
        }
    }
}