package com.tibell.kotlinflight.domain.logic

import com.tibell.kotlinflight.domain.entity.TransmissionMessage
import com.tibell.kotlinflight.exceptions.IllegalBSTMessageType

open public class BSTParser {
}


fun parseBSTPackage(pkgData: String): TransmissionMessage? {
    //println("parsing BST string ${pkgData}")
    val arrayBSTs = pkgData.split(",")
    if (arrayBSTs.size < 10) return null;
    val retPkg = when (arrayBSTs[0]) {
        "MSG" -> parseMSG(arrayBSTs)
        "SEL" -> parseBase(arrayBSTs)
        "ID" -> parseBase(arrayBSTs)
        "AIR" -> parseBase(arrayBSTs)
        "STA" -> parseBase(arrayBSTs)
        "CLK" -> parseBase(arrayBSTs)
        else -> null //throw IllegalBSTMessageType(arrayBSTs[0], pkgData)
    }
    //println("returning ${retPkg.toString()}")
    //println("json ${serialize(retPkg)}")

    return retPkg
}

private fun parseMSG(arrayBSTs: List<String>): TransmissionMessage {
    return  TransmissionMessage(arrayBSTs[2].toInt(), arrayBSTs[3].toInt(),
                                arrayBSTs[4], arrayBSTs[5].toInt(),
                                arrayBSTs[6], arrayBSTs[7],
                                arrayBSTs[8], arrayBSTs[9],
                                cs = arrayBSTs[10],
                                alt = if(arrayBSTs[11] == "") 0 else arrayBSTs[11].toInt(),
                                gs = if(arrayBSTs[12] == "") 0.0F else arrayBSTs[12].toFloat(),
                                trk =if(arrayBSTs[13] == "") 0.0F else arrayBSTs[13].toFloat(),
                                lat =arrayBSTs[14],
                                lng = arrayBSTs[15],
                                vr = if(arrayBSTs[16] == "") 0 else arrayBSTs[16].toInt() ,
                                sq = arrayBSTs[17],
                                alrt = if(arrayBSTs[18] == "") 0 else arrayBSTs[18].toInt(),
                                emer = if(arrayBSTs[19] == "") 0 else arrayBSTs[19].toInt(),
                                spi = if(arrayBSTs[20] == "") 0 else arrayBSTs[20].toInt(),
                                gnd = if(arrayBSTs[21] == "") 0 else arrayBSTs[21].toInt());
}

private fun parseOPE(arrayBSTs: List<String>): TransmissionMessage {
    return  TransmissionMessage(arrayBSTs[2].toInt(), arrayBSTs[3].toInt(),
        arrayBSTs[4], arrayBSTs[5].toInt(),
        arrayBSTs[6], arrayBSTs[7],
        arrayBSTs[8], arrayBSTs[9], cs = arrayBSTs[10]);
}

    private fun parseBase(arrayBSTs: List<String>): TransmissionMessage {
        return  TransmissionMessage(arrayBSTs[2].toInt(), arrayBSTs[3].toInt(),
            arrayBSTs[4], arrayBSTs[5].toInt(),
            arrayBSTs[6], arrayBSTs[7],
            arrayBSTs[8], arrayBSTs[9]);
}