package xyz.rinc.kmp.util

import platform.Foundation.NSUserDefaults

actual object KVStore {
    actual fun getString(key: String, default: String): String? {
        checkDefault(key, default)
        return UD().stringForKey(key)
    }

    actual fun setString(key: String, value: String) {
        setObject(key, value)
    }

    actual fun getBool(key: String, default: Boolean): Boolean {
        checkDefault(key, default)
        return UD().boolForKey(key)
    }

    actual fun setBool(key: String, value: Boolean) {
        setObject(key, value)
    }

    actual fun getInt(key: String, default: Int): Int {
        checkDefault(key, default)
        return UD().integerForKey(key).toInt()
    }

    actual fun setInt(key: String, value: Int) {
        setObject(key, value)
    }

    actual fun getFloat(key: String, default: Float): Float {
        checkDefault(key, default)
        return UD().floatForKey(key)
    }

    actual fun setFloat(key: String, value: Float) {
        setObject(key, value)
    }

    actual fun remove(key: String) {
        UD().removeObjectForKey(key)
        UD().synchronize()
    }

    private fun UD():NSUserDefaults {
        return NSUserDefaults.standardUserDefaults()
    }

    private fun checkDefault(key: String, default: Any?) {
        UD().objectForKey(key) ?: setObject(key, default)
    }

    private fun setObject(key: String, value: Any?) {
        UD().setObject(value, key)
        UD().synchronize()
    }
}