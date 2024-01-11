package com.mywish.mykidsstory

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.mywish.mykidsstory.Fragment.TheThreeLittlePigs.LittlePigsFragment
import com.mywish.mykidsstory.Fragment.TheThreeLittlePigs.LittlePigsFragment1
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

class StoryViewActivity : AppCompatActivity() {




    private lateinit var currentFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_view)


        // Initialize with the default fragment (LittlePigsFragment)
        currentFragment = LittlePigsFragment()

        supportFragmentManager.commit {
            replace(R.id.fragmentContainer, currentFragment)
            addToBackStack(null) // Optional, if you want to add to back stack
        }

        val replaceButton = findViewById<Button>(R.id.replaceButton)


        replaceButton.setOnClickListener {
            replaceFragment()
        }




    }



    private fun replaceFragment() {
        // Example: Replace with LittlePigsFragment1
        val newFragment = LittlePigsFragment1()

        supportFragmentManager.commit {
            replace(R.id.fragmentContainer, newFragment)
            addToBackStack(null) // Optional, if you want to add to back stack
        }

        // Update the current fragment reference
        currentFragment = newFragment
    }



}