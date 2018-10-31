package sample

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    val server = embeddedServer(Netty, port = 8080) {
        routing {
            get(path = "/") {
                call.respondText("Hello There.", ContentType.Text.Plain)
            }
            get(path = "/demo") {
                call.respondText("General Kenobi!")
            }
            get(path = "/potato") {
                call.respondText("potato")
            }
        }
    }
    server.start(wait = true)
}
