package com.tibell.kotlinflight.domain.config

import com.tibell.kotlinflight.domain.services.FlightCacheDisplayRunner
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FlightCacheDisplayConfig {
    private val log = LoggerFactory.getLogger(this.javaClass)

    @Bean
    fun getFlightCacheDisplayRunner(): ApplicationRunner {
         log.debug("FlightCacheDisplayConfig getRunner!")
        return  FlightCacheDisplayRunner()
    }
}