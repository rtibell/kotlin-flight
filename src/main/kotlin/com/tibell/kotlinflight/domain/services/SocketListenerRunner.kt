package com.tibell.kotlinflight.domain.services

import com.tibell.kotlinflight.domain.logic.BSTParser
import com.tibell.kotlinflight.domain.logic.parseBSTPackage
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.Socket

@Component
class SocketListenerRunner : ApplicationRunner {
    private val log = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    internal lateinit var flightCacheService: FlightCacheService

    override fun run(args: ApplicationArguments) {
        log.debug("Start listening on socket")
        val socket = Socket("192.168.8.20", 30003)
        while (true) {
            val text = BufferedReader(InputStreamReader(socket.inputStream)).readLine()
            val flightDate = parseBSTPackage(text)
            if (flightDate != null) {
                val fd = flightCacheService.store(flightDate)
                log.debug("data from cache {}", fd)
            }
            //log.debug("read text {}", text)
        }
    }
}