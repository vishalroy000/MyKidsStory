package com.mywish.mykidsstory

import CustomMediaPlayer
import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {

    private lateinit var playButton: Button
    private lateinit var progressBar: ProgressBar


    private lateinit var mediaPlayer: CustomMediaPlayer



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       progressBar = findViewById<ProgressBar>(R.id.progressBar)
        playButton = findViewById<Button>(R.id.playSound)

        progressBar.visibility=View.GONE


        val textView: TextView = findViewById(R.id.textView)
        val inputString = getString(R.string.good_night_page1)
        val animationSpeed = 95

//        createTypeWriterAnimation(textView, inputString, speed = animationSpeed.toLong())


        mediaPlayer = CustomMediaPlayer(this)
        onPlayButtonClick()
        mediaPlayer.setPlaybackSpeed(0.49f) // Adjust the speed as needed


    }

    fun onPlayButtonClick() {
        // Replace R.raw.intheworld with the actual resource ID of your audio file
        val resourceId = R.raw.in_the_great_green
        // Set the data source
        mediaPlayer.setDataSource(resourceId)
        // Start playing
        mediaPlayer.play()
    }








    override fun onStart() {
        super.onStart()

    }

    override fun onResume() {
        super.onResume()
        // Resume playback when the activity is resumed
        mediaPlayer.resume()

    }

    override fun onPause() {
        super.onPause()
        // Pause playback when the activity is paused
        mediaPlayer.pause()

    }

    override fun onStop() {
        super.onStop()
        // Stop playback when the activity is stopped
        mediaPlayer.stop()

    }

    override fun onDestroy() {
        // Release the resources when the activity is destroyed
        mediaPlayer.release()

        super.onDestroy()
    }

    override fun onRestart() {
        super.onRestart()
    }

    fun toast(message:String){
        Toast.makeText(applicationContext, "$message", Toast.LENGTH_SHORT).show()
    }












    fun createTypeWriterAnimation(
        textView: TextView,
        inputString: String,
        speed: Long = 100,
        delay: Long = 0

    ) {
        textView.text = ""
        val handler = Handler()

        val runnable = object : Runnable {
            var index = 0
            override fun run() {

                if (index < inputString.length) {
                    textView.text = "${textView.text}${inputString[index]}"
                    index++
                    handler.postDelayed(this, speed)
                }
                else{
                    toast("text finished")
                }

            }
        }

        handler.postDelayed(runnable, delay)
    }

}





