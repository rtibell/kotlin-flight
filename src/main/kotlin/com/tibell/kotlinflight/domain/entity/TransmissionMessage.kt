package com.tibell.kotlinflight.domain.entity

import java.util.*

open class TransmissionMessage(var sid: Int, var aid: Int,
                               var hex: String, var fid: Int,
                               var dmg: String, var tmg: String,
                               var dml: String, var tml: String,
                               var cs: String = "", var alt: Int = -1,
                               var gs: Float = 0.0F, var trk: Float = 0.0F,
                               var lat: String = "", var lng: String = "",
                               var vr: Int = 0, var sq: String = "",
                                var alrt: Int = 0, var emer: Int = 0,
                                var spi: Int = 0, var gnd: Int = 0) {

    override fun toString(): String {
        return "sid=${sid}, aid=${aid}, hex=${hex}, mg=${dmg} ${tmg}, ml=${dml} ${tml}, " +
                "cs=${cs}, alt=${alt}, gs=${gs}, trk=${trk}, pos=${lat} - ${lng}, vr=${vr}, sq=${sq}, flags=${alrt}-${emer}-${spi}-${gnd}"
    }

    fun merge(tm: TransmissionMessage?): TransmissionMessage {
        if (tm != null) {
            if (this.sid == 0) this.sid = tm.sid
            if (this.aid == 0) this.aid = tm.aid
            if (this.cs == "") this.cs = tm.cs
            if (this.alt == 0) this.alt = tm.alt
            if (this.gs == 0.0F) this.gs = tm.gs
            if (this.lat == "") this.lat = tm.lat
            if (this.lng == "") this.lng = tm.lng
            if (this.vr == 0) this.vr = tm.vr
            if (this.sq == "") this.sq = tm.sq
            if (this.alrt == 0) this.alrt = tm.alrt
            if (this.emer == 0) this.emer = tm.emer
            if (this.spi == 0) this.spi = tm.spi
            if (this.gnd == 0) this.gnd = tm.gnd
        }
        return this;
    }
}

