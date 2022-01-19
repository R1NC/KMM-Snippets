package xyz.rinc.kmp.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import platform.darwin.*
import platform.posix.QOS_CLASS_DEFAULT
import kotlin.coroutines.CoroutineContext

actual object CoroutineDispatchers {

    actual val main: CoroutineDispatcher = AsyncCoroutineDispatcher(dispatch_get_main_queue())

    actual val default: CoroutineDispatcher = AsyncCoroutineDispatcher(
        dispatch_queue_create(
            "KotlinDefaultSerialDispatcher",
            dispatch_queue_attr_make_with_qos_class(null, QOS_CLASS_DEFAULT, 0)
        )
    )

    private class AsyncCoroutineDispatcher(queue: dispatch_queue_t) : CoroutineDispatcher() {
        private val queue: dispatch_queue_t = queue
        override fun dispatch(context: CoroutineContext, block: Runnable) {
            dispatch_async(queue) {
                block.run()
            }
        }
    }
}