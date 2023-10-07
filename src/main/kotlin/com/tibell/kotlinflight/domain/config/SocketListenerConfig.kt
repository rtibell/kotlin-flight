package com.tibell.kotlinflight.domain.config

import com.tibell.kotlinflight.domain.services.FlightCacheDisplayRunner
import com.tibell.kotlinflight.domain.services.SocketListenerRunner
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SocketListenerConfig {
    private val log = LoggerFactory.getLogger(this.javaClass)

    @Bean
    fun getSocketListenerRunner(): ApplicationRunner {
        log.debug("SocketListenerConfig getRunner!")

        return  SocketListenerRunner()
    }
}