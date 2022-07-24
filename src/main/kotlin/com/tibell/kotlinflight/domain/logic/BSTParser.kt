package com.tibell.kotlinflight.domain.logic

import com.tibell.kotlinflight.domain.entity.BSTBase
import com.tibell.kotlinflight.domain.entity.TransmissionMessage
import com.tibell.kotlinflight.exceptions.IllegalBSTMessageType
import org.springframework.util.SerializationUtils.serialize

public class BSTParser {
}


fun parseBSTPackage(pkgData: String): BSTBase {
    println("parsing BST string ${pkgData}")
    val arrayBSTs = pkgData.split(",")
    val retPkg = when (arrayBSTs[0]) {
        "MSG" -> parseMSG(arrayBSTs)
        "SEL" -> parseBase(arrayBSTs)
        "ID" -> parseBase(arrayBSTs)
        "AIR" -> parseBase(arrayBSTs)
        "STA" -> parseBase(arrayBSTs)
        "CLK" -> parseBase(arrayBSTs)
        else -> throw IllegalBSTMessageType(arrayBSTs[0], pkgData)
    }
    println("returning ${retPkg.toString()}")
    //println("json ${serialize(retPkg)}")

    return retPkg
}

private fun parseMSG(arrayBSTs: List<String>): TransmissionMessage {
    when
    return  TransmissionMessage(arrayBSTs[0], arrayBSTs[1].toInt(),
                                arrayBSTs[2].toInt(), arrayBSTs[3].toInt(),
                                arrayBSTs[4], arrayBSTs[5].toInt(),
                                arrayBSTs[6], arrayBSTs[7],
                                arrayBSTs[8], arrayBSTs[9]);
}

    private fun parseBase(arrayBSTs: List<String>): BSTBase {
        return  BSTBase(arrayBSTs[0], 0,
            arrayBSTs[2].toInt(), arrayBSTs[3].toInt(),
            arrayBSTs[4], arrayBSTs[5].toInt(),
            arrayBSTs[6], arrayBSTs[7],
            arrayBSTs[8], arrayBSTs[9]);
}