package com.mywish.mykidsstory.Fragment.TheThreeLittlePigs

import CustomMediaPlayer
import android.animation.ObjectAnimator
import android.os.Bundle
import android.service.controls.ControlsProviderService
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.mywish.mykidsstory.InterstitialAdManager
import com.mywish.mykidsstory.R
import com.mywish.mykidsstory.databinding.FragmentLittlePigs6Binding
import com.mywish.mykidsstory.databinding.FragmentLittlePigs7Binding
import com.nitish.typewriterview.TypeWriterView
import kotlin.random.Random


class LittlePigsFragment7 : Fragment() {


    private lateinit var fragmentLittlePigs7Binding:FragmentLittlePigs7Binding
    protected var rewardedAd: RewardedAd? = null

    private lateinit var mediaPlayer: CustomMediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLittlePigs7Binding= FragmentLittlePigs7Binding.inflate(inflater,container,false)
        activity?.window?.apply { addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN) }

        val typeWriterView: TypeWriterView = fragmentLittlePigs7Binding.typeWriterView
        typeWriterView.animateText(getString(R.string.the_little_three_pigs7))
        typeWriterView.setCharacterDelay(50);
        mediaPlayer = CustomMediaPlayer(requireContext())
        playAudioWithGlowingAnimation(fragmentLittlePigs7Binding.fingerTap, R.raw.the_three_little_pigs7)

        typeWriterView.setOnAnimationChangeListener {}


        fragmentLittlePigs7Binding.next.setOnClickListener {

            replaceWithFragment(LittlePigsFragment8())

        }


        return fragmentLittlePigs7Binding.root
    }

    private fun replaceWithFragment() {
        // Replace FragmentA with FragmentB
        InterstitialAdManager.loadInterstitialAd(requireContext(), "ca-app-pub-8634900064580620/9230714495")


        val ft: FragmentTransaction = requireFragmentManager().beginTransaction()
        ft.replace(R.id.fragmentContainer,LittlePigsFragment8() , "NewFragmentTag")
        ft.commit()
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

//    fun onPlayButtonClick() {
//        // Replace R.raw.intheworld with the actual resource ID of your audio file
//        val resourceId = R.raw.the_three_little_pigs7
//        // Set the data source
//        mediaPlayer.setDataSource(resourceId)
//        // Start playing
//        mediaPlayer.play()
//    }




  private  fun replaceWithFragment(fragment: Fragment) {
        // Replace FragmentA with FragmentB
      InterstitialAdManager.loadInterstitialAd(requireContext(), getString(R.string.ads_id_interstitial))
      InterstitialAdManager.showInterstitialAd(requireContext())
        val ft: FragmentTransaction = requireFragmentManager().beginTransaction()
        ft.replace(R.id.fragmentContainer, fragment , "NewFragmentTag")
        ft.commit()
    }

    private fun playAudioWithGlowingAnimation(view: ImageView, audioResId: Int) {
         mediaPlayer = CustomMediaPlayer(requireContext())
        mediaPlayer.setDataSource(audioResId)
        mediaPlayer.play()

        val glowAnim = ObjectAnimator.ofFloat(view, "alpha", 0.3f, 1f).apply {
            duration = 500 // Adjust the duration as needed
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }
        glowAnim.start()

        mediaPlayer.setOnCompletionListener {
            // Show a toast message when the audio finishes playing
            view.visibility = View.VISIBLE
        }
    }

}