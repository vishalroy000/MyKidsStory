package com.mywish.mykidsstory

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.mywish.mykidsstory.Fragment.StoryGoodNight.GoodNIghtFragment2
import com.mywish.mykidsstory.Fragment.StoryGoodNight.GoodNightFragment1
import com.mywish.mykidsstory.Fragment.StoryGoodNight.GoodNightFragment10
import com.mywish.mykidsstory.Fragment.StoryGoodNight.GoodNightFragment11
import com.mywish.mykidsstory.Fragment.StoryGoodNight.GoodNightFragment12
import com.mywish.mykidsstory.Fragment.StoryGoodNight.GoodNightFragment3
import com.mywish.mykidsstory.Fragment.StoryGoodNight.GoodNightFragment4
import com.mywish.mykidsstory.Fragment.StoryGoodNight.GoodNightFragment5
import com.mywish.mykidsstory.Fragment.StoryGoodNight.GoodNightFragment6
import com.mywish.mykidsstory.Fragment.StoryGoodNight.GoodNightFragment7
import com.mywish.mykidsstory.Fragment.StoryGoodNight.GoodNightFragment8
import com.mywish.mykidsstory.Fragment.StoryGoodNight.GoodNightFragment9
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var playButton: Button
    private lateinit var progressBar: ProgressBar
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       progressBar = findViewById<ProgressBar>(R.id.progressBar)
        playButton = findViewById<Button>(R.id.playSound)

        progressBar.visibility=View.GONE

        playButton.setOnClickListener {
            playAudioFromUrl("https://s5-6.ttsmaker-file.com/file/2024-01-11-014352_193305.mp3")

        }



    }


    private fun playAudioFromUrl(url: String) {
        progressBar.visibility = ProgressBar.VISIBLE

        mediaPlayer = MediaPlayer().apply {
            setOnPreparedListener { mp ->
                progressBar.visibility = ProgressBar.GONE
                mp.start()
            }
            setOnCompletionListener {
                progressBar.visibility = ProgressBar.GONE
            }
            setOnErrorListener { mp, what, extra ->
                progressBar.visibility = ProgressBar.GONE
                false
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            try {
                mediaPlayer.setDataSource(url)
                mediaPlayer.prepareAsync()
            } catch (e: IOException) {
                showError()
            }
        }
    }


    private fun showError() {
        // Handle error logic here, like showing an error message.
        // For simplicity, I'm just hiding the progress bar.
        progressBar.visibility = ProgressBar.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}






