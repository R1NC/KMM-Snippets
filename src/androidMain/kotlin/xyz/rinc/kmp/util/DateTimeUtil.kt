package xyz.rinc.kmp.util

import java.text.SimpleDateFormat
import java.util.*

actual object DateTimeUtil {
    actual fun currentTime(): Double {
        return System.currentTimeMillis().toDouble()
    }

    actual fun currentTimeStrFormat(format: String): String {
        return SimpleDateFormat(format, Locale.ENGLISH).format(Date())
    }
}