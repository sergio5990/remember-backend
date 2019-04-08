package com.github.sergio5990.ellipse.client

import reactor.core.publisher.Mono

class Connector(val client: Client) {

    fun getName(i: Int): Mono<String> = client.<String>get("jjfjf") {
        baseurl ="uii"
        header = "kkfkf"
        body = i
    }

}