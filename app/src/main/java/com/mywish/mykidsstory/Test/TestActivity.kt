package com.mywish.mykidsstory.Test

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mywish.mykidsstory.R
import com.nitish.typewriterview.TypeWriterView
import java.util.Locale


class TestActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer

    private lateinit var t1: TextToSpeech
    private lateinit var ed1: EditText
    private lateinit var b1: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val typeWriterView: TypeWriterView = findViewById(R.id.typeWriterView)
        typeWriterView.animateText(getString(R.string.good_night_page1))

        ed1 = findViewById<EditText>(R.id.editTextTextEmailAddress);
        b1 = findViewById<Button>(R.id.button);

        t1 = TextToSpeech(
            applicationContext
        ) { status ->
            if (status != TextToSpeech.ERROR) {
                t1.language = Locale.UK
            }
        }




        b1.setOnClickListener(View.OnClickListener {
            val toSpeak = getString(R.string.good_night_page1)
            Toast.makeText(applicationContext, toSpeak, Toast.LENGTH_SHORT).show()
            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null)
        })



        mediaPlayer = MediaPlayer.create(this, R.raw.in_the_great_green)

        val playButton: Button = findViewById(R.id.playButton)
//            playSound()

    }

        override fun onPause() {
            if (t1 != null) {
                t1!!.stop()
                t1!!.shutdown()
            }
            super.onPause()
        }
    private fun playSound() {
        mediaPlayer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }

}