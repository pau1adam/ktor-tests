package sample

import io.ktor.application.*
import io.ktor.html.respondHtml
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.html.*

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
                call.respondHtml {
                    head {
                        title { +"this is the page title" }
                    }
                    body {
                        p { +"this is a paragraph" }
                        p { +"this is another paragraph" }
                        p {
                            + "this paragraph has an input field for some reason ==> "
                            input{
                                value = "default value"
                                name = "randomInput"
                                autoFocus = true
                            }
                        }
                    }
                }
            }
        }
    }
    server.start(wait = true)
}
