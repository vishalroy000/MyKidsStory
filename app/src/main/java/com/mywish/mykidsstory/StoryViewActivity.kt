package com.mywish.mykidsstory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.rewarded.RewardedAd
import com.mywish.mykidsstory.Fragment.TheThreeLittlePigs.LittlePigsFragment

class StoryViewActivity : AppCompatActivity() {


    private lateinit var currentFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_view)
        
        currentFragment = LittlePigsFragment()

        supportFragmentManager.commit {
            replace(R.id.fragmentContainer, currentFragment)
            addToBackStack(null) // Optional, if you want to add to back stack
        }

    }

}