package com.github.sergio5990.remember.domain

import com.github.sergio5990.remember.domain.controller.NoteController

@SpringBootConfiguration
@EnableAutoConfiguration
class DomainApplication

fun main(args: Array<String>) {
//    runApplication<DomainApplication>(*args)

    SpringApplicationBuilder().initializers(beans {
        bean<NoteController>()
    }).sources(DomainApplication::class.java).run(*args)

}
