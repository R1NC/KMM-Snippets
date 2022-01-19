package xyz.rinc.kmp.util

import platform.Foundation.NSDate
import platform.Foundation.NSDateFormatter
import platform.Foundation.date
import platform.Foundation.timeIntervalSince1970

actual object DateTimeUtil {
    actual fun currentTime(): Double {
        return current().timeIntervalSince1970
    }

    actual fun currentTimeStrFormat(format: String): String {
        val formatter = NSDateFormatter()
        formatter.setDateFormat(format)
        return formatter.stringFromDate(current())
    }

    private fun current(): NSDate {
        return NSDate.date()
    }
}