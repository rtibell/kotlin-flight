package com.tibell.kotlinflight

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinFlightApplication

fun main(args: Array<String>) {
	runApplication<KotlinFlightApplication>(*args)
}
