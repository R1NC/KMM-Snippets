package xyz.rinc.kmp.audio

import platform.AVFoundation.*
import platform.Foundation.NSURL

actual class AudioPlayer {

    private var player: AVPlayer? = null

    actual constructor(file: String) {
        player = AVPlayer.playerWithURL(NSURL.fileURLWithPath(file))
    }

    actual fun pause() {
        player?.setRate(0.0f)
    }

    actual fun resume() {
        if (player != null) {
            val session = AVAudioSession.sharedInstance()
            session.setCategory(AVAudioSessionCategoryPlayback, AVAudioSessionCategoryOptionDefaultToSpeaker, null)
            session.setActive(true, null)
            player?.playImmediatelyAtRate(1.0f)
        }
    }

    actual fun release() {
        player?.replaceCurrentItemWithPlayerItem(null)
    }
}