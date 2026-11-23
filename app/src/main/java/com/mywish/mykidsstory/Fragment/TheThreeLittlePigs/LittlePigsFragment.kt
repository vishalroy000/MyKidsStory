package com.mywish.mykidsstory.Fragment.TheThreeLittlePigs

import CustomMediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.mywish.mykidsstory.R
import com.mywish.mykidsstory.databinding.FragmentLittlePigsBinding


class LittlePigsFragment : Fragment() {


    private val pauseTime = 3000L // 3 seconds delay
    private lateinit var mediaPlayer: CustomMediaPlayer


    private lateinit var fragmentLittlePigsBinding:FragmentLittlePigsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLittlePigsBinding=FragmentLittlePigsBinding.inflate(inflater,container,false)


        activity?.window?.apply { addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN) }


        Handler().postDelayed({ replaceWithFragment() }, pauseTime)

//        playAudioFromUrl("https://s5-6.ttsmaker-file.com/file/2024-01-11-014352_193305.mp3")
        // Inflate the layout for this fragment
//        val animationDrawable = fragmentLittlePigsBinding.layout.background as AnimationDrawable
//        animationDrawable.setEnterFadeDuration(1500)
//        animationDrawable.setExitFadeDuration(3000)
//        animationDrawable.start()

        mediaPlayer = CustomMediaPlayer(requireContext())
        onPlayButtonClick()


        return fragmentLittlePigsBinding.root
    }

    private fun replaceWithFragment() {
        // Replace FragmentA with FragmentB

        val ft: FragmentTransaction = requireFragmentManager().beginTransaction()
        ft.replace(R.id.fragmentContainer,LittlePigsFragment1() , "NewFragmentTag")
        ft.commit()
    }

    fun onPlayButtonClick() {
        // Replace R.raw.intheworld with the actual resource ID of your audio file
        val resourceId = R.raw.title_the_three_little_pigs
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

   private fun toast(message:String){
        Toast.makeText(requireContext(), "$message", Toast.LENGTH_SHORT).show()
    }

}