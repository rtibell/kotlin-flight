package com.tibell.kotlinflight.domain.services

import com.tibell.kotlinflight.domain.entity.TransmissionMessage
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import kotlin.collections.Map as Map
import kotlin.collections.MutableMap as KotlinCollectionsMutableMap

@Service
open class FlightCacheService {
     val flightCache = mutableMapOf<String, TransmissionMessage>()

    fun store(flightData: TransmissionMessage): TransmissionMessage {
        val updFD = flightData.merge(flightCache[flightData.hex])
        flightCache[flightData.hex] = updFD
        return updFD
    }

    fun read(hex: String): TransmissionMessage? {
        return flightCache[hex]
    }

    fun renderCacheInfo(): String? {
        val sb = StringBuffer()
        flightCache.forEach {(k,v) -> sb.append(v)}
        return sb.toString()
    }
}