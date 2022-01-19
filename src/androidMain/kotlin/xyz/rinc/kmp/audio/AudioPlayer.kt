package xyz.rinc.kmp.audio

import android.media.AudioManager
import android.media.MediaPlayer
import java.io.IOException

actual class AudioPlayer {

    private var player: MediaPlayer? = null

    actual constructor(file: String) {
        if (ContextHolder.context != null) {
            player = MediaPlayer()
            player?.setAudioStreamType(AudioManager.STREAM_MUSIC)
            try {
                val afd = ContextHolder.context!!.assets.openFd(file)
                player?.setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
                player?.prepare()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    actual fun pause() {
        if (player != null) {
            try {
                if (player!!.isPlaying) {
                    player?.pause()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    actual fun resume() {
        if (player != null) {
            try {
                if (!player!!.isPlaying && player!!.duration > 0 && player!!.currentPosition < player!!.duration) {
                    player?.start()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    actual fun release() {
        player?.release()
    }
}