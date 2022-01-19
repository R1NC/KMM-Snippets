package xyz.rinc.kmp.util

import kotlinx.cinterop.*
import kotlinx.io.core.*
import utils.*
import kotlin.native.concurrent.*

actual class Lock : Closeable {
    private val mutex = nativeHeap.alloc<ktor_mutex_t>()

    init {
        freeze()
        ktor_mutex_create(mutex.ptr).checkResult { "Failed to create mutex." }
    }

    actual fun lock() {
        ktor_mutex_lock(mutex.ptr).checkResult { "Failed to lock mutex." }
    }

    actual fun unlock() {
        ktor_mutex_unlock(mutex.ptr).checkResult { "Failed to unlock mutex." }
    }

    override fun close() {
        ktor_mutex_destroy(mutex.ptr)
        nativeHeap.free(mutex)
    }
}

private inline fun Int.checkResult(block: () -> String) {
    check(this == 0, block)
}