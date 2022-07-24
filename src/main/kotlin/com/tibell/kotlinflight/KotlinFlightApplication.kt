package com.tibell.kotlinflight

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
open class KotlinFlightApplication {

}

fun main(args: Array<String>) {
		runApplication<KotlinFlightApplication>(*args)
}
