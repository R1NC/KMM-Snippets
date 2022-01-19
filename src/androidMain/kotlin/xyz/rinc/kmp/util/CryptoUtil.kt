package xyz.rinc.kmp.util

import java.security.MessageDigest
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

actual object CryptoUtil {

    actual fun HmacSHA256(src: String, key: String): String? {
        return try {
            val algorithm = "HmacSHA256"
            val mac = Mac.getInstance(algorithm)
            mac.init(SecretKeySpec(key.toByteArray(), algorithm))
            byteArrayToHexString(mac.doFinal(src.toByteArray()))
        } catch (ex: Exception) {
            ex.printStackTrace()
            null
        }
    }

    actual fun MD5(src: String): String? {
        return try {
            val md5 = MessageDigest.getInstance("MD5")
            byteArrayToHexString(md5.digest(src.toByteArray()))
        } catch (ex: Exception) {
            ex.printStackTrace()
            null
        }
    }
}