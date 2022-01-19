package xyz.rinc.kmp.util

expect object KVStore {
    fun getString(key: String, default: String): String?
    fun setString(key: String, value: String)
    fun getBool(key: String, default: Boolean): Boolean
    fun setBool(key: String, value: Boolean)
    fun getInt(key: String, default: Int): Int
    fun setInt(key: String, value: Int)
    fun getFloat(key: String, default: Float): Float
    fun setFloat(key: String, value: Float)
    fun remove(key: String)
}