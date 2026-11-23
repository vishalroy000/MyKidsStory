package com.mywish.mykidsstory.Test

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.mywish.mykidsstory.R
import com.q42.android.scrollingimageview.ScrollingImageView


class TestActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)


        val scrollingBackground:ScrollingImageView = findViewById(R.id.scrolling_background)
        scrollingBackground.stop()
        scrollingBackground.start()

        val animation=findViewById<LottieAnimationView>(R.id.animation_view)

        animation.playAnimation()


//        val kbv = findViewById<View>(com.mywish.mykidsstory.R.id.image2) as KenBurnsView
//        kbv.setTransitionListener(object : KenBurnsView.TransitionListener {
//            override fun onTransitionStart(transition: Transition?) {}
//            override fun onTransitionEnd(transition: Transition?) {}
//        })

//        val generator = RandomTransitionGenerator(duration.toLong(), interpolator.accelerate_cubic)
//        kbv.setTransitionGenerator(generator)
//        throw RuntimeException("I'm a cool exception and I crashed the main thread!")





    }

}