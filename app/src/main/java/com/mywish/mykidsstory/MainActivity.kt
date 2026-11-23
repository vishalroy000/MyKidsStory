package com.mywish.mykidsstory

import CustomMediaPlayer
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mywish.mykidsstory.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var mediaPlayer: CustomMediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        window?.apply { addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN) }
        setContentView(activityMainBinding.root)

        mediaPlayer = CustomMediaPlayer(this)

        init()
    }

    fun toast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    fun init() {
        activityMainBinding.btnTheMiserAndGold.setOnClickListener(this)
        activityMainBinding.btnStoryCinderalla.setOnClickListener(this)
        activityMainBinding.btnStoryTheShepherdBoyAndTheWolf.setOnClickListener(this)
        activityMainBinding.btnStoryTheGoldeEgg.setOnClickListener(this)
        activityMainBinding.btnStoryTheCountryMaind.setOnClickListener(this)
        activityMainBinding.btnStoryGoodNight.setOnClickListener(this)
        activityMainBinding.btnStoryGoldilocksAndThreeBears.setOnClickListener(this)
        activityMainBinding.btnTheThreeLittilePigs.setOnClickListener(this)
    }

    fun onPlayClick() {
        // Replace R.raw.intheworld with the actual resource ID of your audio file
        val resourceId = R.raw.up_comming_story
        // Set the data source
        mediaPlayer.setDataSource(resourceId)
        // Start playing
        mediaPlayer.play()
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
                } else {
                    toast("text finished")
                }
            }
        }

        handler.postDelayed(runnable, delay)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            activityMainBinding.btnStoryCinderalla.id-> {
                onPlayClick()
            }
            activityMainBinding.btnStoryGoodNight.id-> {
                onPlayClick()
            }
            activityMainBinding.btnStoryTheGoldeEgg.id-> {
                onPlayClick()
            }
            activityMainBinding.btnStoryTheCountryMaind.id-> {
                onPlayClick()
            }
            activityMainBinding.btnTheMiserAndGold.id-> {
                onPlayClick()
            }
            activityMainBinding.btnStoryTheShepherdBoyAndTheWolf.id-> {
                onPlayClick()
            }
            activityMainBinding.btnStoryGoldilocksAndThreeBears.id -> {
                onPlayClick()
            }
            activityMainBinding.btnTheThreeLittilePigs.id -> {
                val intent = Intent(this@MainActivity, StoryViewActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
