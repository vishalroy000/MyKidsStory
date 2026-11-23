package com.mywish.mykidsstory.Fragment.TheThreeLittlePigs

import CustomMediaPlayer
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.mywish.mykidsstory.InterstitialAdManager
import com.mywish.mykidsstory.R
import com.mywish.mykidsstory.databinding.FragmentLittlePigs18Binding
import com.mywish.mykidsstory.databinding.FragmentLittlePigs19Binding
import com.nitish.typewriterview.TypeWriterView


class LittlePigsFragment19 : Fragment() {

    private lateinit var fragmentLittlePigs19Binding:FragmentLittlePigs19Binding

    private lateinit var mediaPlayer: CustomMediaPlayer


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLittlePigs19Binding= FragmentLittlePigs19Binding.inflate(inflater,container,false)

        val typeWriterView: TypeWriterView = fragmentLittlePigs19Binding.typeWriterView
        typeWriterView.animateText(getString(R.string.the_little_three_pigs19))
        typeWriterView.setCharacterDelay(50);
        mediaPlayer = CustomMediaPlayer(requireContext())
        playAudioWithGlowingAnimation(fragmentLittlePigs19Binding.fingerTap, R.raw.the_three_little_pigs19)


        return fragmentLittlePigs19Binding.root


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
//        val resourceId = R.raw.the_three_little_pigs19
//        // Set the data source
//        mediaPlayer.setDataSource(resourceId)
//        // Start playing
//        mediaPlayer.play()
//    }

   private fun replaceWithFragment(fragment: Fragment) {
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
            view.visibility = View.GONE
            fragmentLittlePigs19Binding.typeWriterView.visibility=View.GONE
            fragmentLittlePigs19Binding.next.visibility=View.GONE
            fragmentLittlePigs19Binding.storyFinish.visibility=View.VISIBLE
            fragmentLittlePigs19Binding.animationView.visibility=View.VISIBLE

        }
    }

}