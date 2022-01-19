package xyz.rinc.kmp.util

import kotlinx.coroutines.CoroutineDispatcher

expect object CoroutineDispatchers {
    val main : CoroutineDispatcher
    val default: CoroutineDispatcher
}