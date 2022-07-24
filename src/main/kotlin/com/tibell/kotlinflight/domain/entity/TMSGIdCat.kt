package com.tibell.kotlinflight.domain.entity

class TMSGIdCat(mt: String, tt: Int,
                sid: Int, aid: Int,
                hex: String, fid: Int,
                dmg: String, tmg: String,
                dml: String, tml: String,
                val cs: String): TransmissionMessage(mt, tt,
    sid, aid,
    hex, fid,
    dmg, tmg,
    dml, tml
) {
    override fun toString(): String {
        return super.toString() + " cs=${cs}"
    }
}