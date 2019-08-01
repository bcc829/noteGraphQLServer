package com.note.resource

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
class ResourceApplication

fun main(args: Array<String>) {
	runApplication<ResourceApplication>(*args)
}
