package com.note.resource

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter
import javax.servlet.Filter


@SpringBootApplication
class ResourceApplication

fun main(args: Array<String>) {

	runApplication<ResourceApplication>(*args)
}

@Bean
fun openFilter(): Filter {
	return OpenEntityManagerInViewFilter()
}