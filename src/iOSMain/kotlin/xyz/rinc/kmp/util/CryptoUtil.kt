package xyz.rinc.kmp.util

import kotlinx.cinterop.*
import platform.CoreCrypto.*
import platform.darwin.ByteVar
import platform.posix.strlen

actual object CryptoUtil {
    actual fun HmacSHA256(src: String, key: String): String? {
        memScoped {
            val charP_src = src.cstr.getPointer(this)
            val charP_key = key.cstr.getPointer(this)
            val targetLen = CC_SHA256_DIGEST_LENGTH
            val charP_Result: CArrayPointer<ByteVar> = nativeHeap.allocArray(targetLen)
            CCHmac(kCCHmacAlgSHA256, charP_key, strlen(key), charP_src, strlen(src), charP_Result)
            val hex = byteArrayPointerToHexString(charP_Result, targetLen)
            nativeHeap.free(charP_Result)
            return hex
        }
    }

    actual fun MD5(src: String): String? {
        memScoped {
            val charP_src = src.cstr.getPointer(this)
            val targetLen = CC_MD5_DIGEST_LENGTH
            val charP_Result: CArrayPointer<ByteVar> = nativeHeap.allocArray(targetLen)
            CC_MD5(charP_src, strlen(src).toUInt(), charP_Result)
            val hex = byteArrayPointerToHexString(charP_Result, targetLen)
            nativeHeap.free(charP_Result)
            return hex
        }
    }

    private fun byteArrayPointerToHexString(bap: CArrayPointer<ByteVar>, len: Int): String {
        val ba = ByteArray(len)
        for (i in 0 until len) {
            ba[i] = bap[i].toByte()
        }
        return byteArrayToHexString(ba)
    }

}