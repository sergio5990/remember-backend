package com.github.sergio5990.remember.domain

import com.github.sergio5990.remember.domain.controller.NoteController
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.support.beans

@SpringBootConfiguration
@EnableAutoConfiguration
class DomainApplication

fun main(args: Array<String>) {
//    runApplication<DomainApplication>(*args)

  SpringApplicationBuilder().initializers(beans {
    bean<NoteController>()
  }).sources(DomainApplication::class.java).run(*args)
}
