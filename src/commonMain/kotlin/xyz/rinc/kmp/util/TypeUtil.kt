package xyz.rinc.kmp.util

val hexArray = arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F")

inline fun byteToHexString(b: Byte): String {
    var i: Int = b.toInt()
    if (i < 0) i += 256
    val i1 = i / 16
    val i2 = i % 16
    return "${hexArray[i1]}${hexArray[i2]}"
}

inline fun byteArrayToHexString(bytes: ByteArray): String {
    val sb = StringBuilder()
    for (x in bytes) {
        sb.append(byteToHexString(x))
    }
    return sb.toString()
}


