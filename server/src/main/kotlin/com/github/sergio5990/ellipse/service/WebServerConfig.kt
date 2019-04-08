package com.github.sergio5990.ellipse.server

import io.netty.handler.codec.http.HttpMethod
import io.netty.handler.codec.http.HttpMethod.GET
import org.reactivestreams.Publisher
import reactor.core.publisher.Mono
import reactor.netty.http.server.HttpServer
import reactor.netty.http.server.HttpServerRequest
import reactor.netty.http.server.HttpServerResponse
import reactor.netty.http.server.HttpServerRoutes

class RouteConfiguration(val method: HttpMethod,
                         val path: String,
                         val handler: (HttpServerRequest, HttpServerResponse) -> Publisher<Void>)

fun get(path: String, handler: (HttpServerRequest, HttpServerResponse) -> Publisher<Void>): RouteConfiguration {
    return RouteConfiguration(GET, path, handler)
}

fun HttpServerRoutes.addRoutes(routes: List<RouteConfiguration>): HttpServerRoutes {
    routes.forEach {
        when (it.method) {
            GET -> this.get(it.path, it.handler)
        }
    }
    return this
}

interface Contract {
    fun getUserName(userId: Long): Mono<String>
}

val contract: Contract = object: Contract {
    override fun getUserName(userId: Long): Mono<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

val element = get("/hello") { rq, rs -> rs.sendString(contract.getUserName(rq.param("userId")!!.toLong())) }
val testRoutes = listOf(element)

fun main(args: Array<String>) {

    val kodein = Kodein {
        bind() from singleton { element }
    }

    val routes1 by kodein.allInstances<RouteConfiguration>()
    val server = HttpServer.create()
            .port(8888)
            .route { routes ->
                routes.addRoutes(routes1)
//            .get("/hello") { req, res -> res.sendString(Mono.just("1")) }
            }
            .wiretap(true)
            .bindNow()

    println(server.port())

    server.onDispose().block()
}

