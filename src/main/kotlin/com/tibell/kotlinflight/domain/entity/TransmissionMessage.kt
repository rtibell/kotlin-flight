package com.tibell.kotlinflight.domain.entity

open class TransmissionMessage(mt: String, tt: Int,
    sid: Int, aid: Int,
    hex: String, fid: Int,
    dmg: String, tmg: String,
    dml: String, tml: String): BSTBase(mt, tt,
    sid, aid,
    hex, fid,
    dmg, tmg,
    dml, tml
) {
//    constructor(
//         mt: String, tt: Int,
//         sid: Int, aid: Int,
//         hex: String, fid: Int,
//         dmg: String, tmg: String,
//         dml: String, tml: String,
//         cs: String
//    ) : super(
//        mt, tt,
//        sid, aid,
//        hex, fid,
//        dmg, tmg,
//        dml, tml
//    ) {}

    override fun toString(): String {
        return super.toString() //+ " cs=${cs}"
    }
}
