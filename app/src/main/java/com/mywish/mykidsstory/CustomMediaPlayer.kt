import android.content.Context
import android.media.MediaPlayer
import android.media.PlaybackParams
import android.os.Build
import com.mywish.mykidsstory.R

class CustomMediaPlayer(private val context: Context) {

    private var mediaPlayer: MediaPlayer = MediaPlayer()
    private var isPaused: Boolean = true

    fun setDataSource(resourceId: Int) {
        try {
            mediaPlayer.reset()
            val rawPath = "android.resource://${context.packageName}/$resourceId"
            mediaPlayer.setDataSource(context, android.net.Uri.parse(rawPath))
            mediaPlayer.prepare()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun play() {
        if (!mediaPlayer.isPlaying) {
            if (isPaused) {
                mediaPlayer.start()
                isPaused = false
            } else {
                mediaPlayer.setOnCompletionListener {
                    isPaused = false
                }
                mediaPlayer.start()
            }
        }
    }

    fun pause() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
            isPaused = true
        }
    }

    fun resume() {
        if (isPaused) {
            mediaPlayer.start()
            isPaused = false
        }
    }



    fun stop() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
            isPaused = true
        }
    }

    fun release() {
        mediaPlayer.release()
    }

    fun setVolume(volume: Float) {
        mediaPlayer.setVolume(volume, volume)
    }



    fun setPlaybackSpeed(speed: Float) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val params = PlaybackParams()
            params.speed = speed
            mediaPlayer.playbackParams = params
        } else {
            // If the API level is lower than 23, adjusting speed may not be supported
            // You can handle this case accordingly, e.g., display a message to the user
        }
    }

    fun onActivityResume() {
        if (!isPaused) {
            mediaPlayer.start()
        }
    }

    fun onActivityPause() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
            isPaused = true
        }
    }

    fun onActivityStop() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
            isPaused = true
        }
    }

    fun onActivityDestroy() {
        mediaPlayer.stop()
        mediaPlayer.release()
    }


}