package com.example.chatroom

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext

@SpringBootApplication
class ChatRoomApplication(
    private val appContext: ApplicationContext
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val server = ChatRoomServer.build(
            service = appContext.getBean(ChatRoomService::class.java)
        )

        server.start()
        server.blockUntilShutdown()
    }

}

fun main(args: Array<String>) {
    runApplication<ChatRoomApplication>(*args)
}