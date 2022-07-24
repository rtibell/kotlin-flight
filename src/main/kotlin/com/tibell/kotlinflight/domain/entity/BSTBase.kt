package com.tibell.kotlinflight.domain.entity

import java.util.*

open class BSTBase(val mt: String, val tt: Int,
                   val sid: Int, val aid: Int,
                   val hex: String, val fid: Int,
                   val dmg: String, val tmg: String,
                   val dml: String, val tml: String) {
    override fun toString(): String {
        return "mt=${mt}, tt=${tt}, sid=${mt}, aid=${mt}, hex=${hex}, mg=${dmg} ${tmg}, ml=${dml} ${tml}"
    }
}

