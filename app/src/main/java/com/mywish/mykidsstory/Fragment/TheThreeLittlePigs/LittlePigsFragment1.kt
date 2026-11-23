package com.mywish.mykidsstory.Fragment.TheThreeLittlePigs

import CustomMediaPlayer
import android.animation.ObjectAnimator
import android.media.MediaPlayer
import android.os.Bundle
import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.mywish.mykidsstory.InterstitialAdManager
import com.mywish.mykidsstory.R
import com.mywish.mykidsstory.databinding.FragmentLittlePigs1Binding
import com.nitish.typewriterview.TypeWriterView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import kotlin.random.Random


class LittlePigsFragment1 : Fragment() {


    private lateinit var fragmentLittlePigs1Binding: FragmentLittlePigs1Binding
    protected var rewardedAd: RewardedAd? = null
    private lateinit var mediaPlayer: CustomMediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentLittlePigs1Binding=FragmentLittlePigs1Binding.inflate(inflater,container,false)
        activity?.window?.apply { addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN) }

        val text = getString(R.string.the_little_three_pigs1)
        fragmentLittlePigs1Binding.typeWriterView.text = HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_LEGACY)

        fragmentLittlePigs1Binding.typeWriterView.setCharacterDelay(50);
        val typeWriterView: TypeWriterView = fragmentLittlePigs1Binding.typeWriterView
        typeWriterView.animateText(getString(R.string.the_little_three_pigs1))

        mediaPlayer = CustomMediaPlayer(requireContext())
        playAudioWithGlowingAnimation(fragmentLittlePigs1Binding.fingerTap, R.raw.the_three_little_pigs1)

        InterstitialAdManager.loadInterstitialAd(requireContext(), getString(R.string.ads_id_interstitial))

        typeWriterView.setOnAnimationChangeListener {}
        fragmentLittlePigs1Binding.next.setOnClickListener {

            replaceWithFragment(LittlePigsFragment2())
        }




        return fragmentLittlePigs1Binding.root
    }

//    private fun replaceWithFragment() {
//        // Replace FragmentA with FragmentB
//        InterstitialAdManager.loadInterstitialAd(requireContext(), "ca-app-pub-8634900064580620/9230714495")
//
//        val ft: FragmentTransaction = requireFragmentManager().beginTransaction()
//        ft.replace(R.id.fragmentContainer,LittlePigsFragment2() , "NewFragmentTag")
//        ft.commit()
//    }

//    fun onPlayButtonClick() {
//        // Replace R.raw.intheworld with the actual resource ID of your audio file
//        val resourceId = R.raw.the_three_little_pigs1
//        // Set the data source
//        mediaPlayer.setDataSource(resourceId)
//        // Start playing
//        mediaPlayer.play()
//    }

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





  private  fun replaceWithFragment(fragment: Fragment) {
        // Replace FragmentA with FragmentB
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
