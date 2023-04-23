package com.tibell.kotlinflight.domain.services

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class FlightCacheDisplayRunner : ApplicationRunner {
    private val log = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    internal lateinit var flightCacheService: FlightCacheService

    override fun run(args: ApplicationArguments) {
        log.debug("Start displaying cache!")
        while(true) {
            Thread.sleep(10L * 1000L)
            log.info(flightCacheService.renderCacheInfo())
        }
    }
}