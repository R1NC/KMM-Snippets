package xyz.rinc.kmp.audio

expect class AudioPlayer(file: String) {
    fun pause()
    fun resume()
    fun release()
}