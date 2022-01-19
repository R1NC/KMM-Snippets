package xyz.rinc.kmp.util

expect object CryptoUtil {
    fun HmacSHA256(src: String, key: String): String?
    fun MD5(src: String): String?
}