package xyz.rinc.kmp.util

expect object DateTimeUtil {
    fun currentTime(): Double
    fun currentTimeStrFormat(format: String): String
}