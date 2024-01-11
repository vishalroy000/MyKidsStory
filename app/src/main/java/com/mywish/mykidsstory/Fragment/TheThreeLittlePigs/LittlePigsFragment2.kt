package com.mywish.mykidsstory.Fragment.TheThreeLittlePigs

import CustomMediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.mywish.mykidsstory.R
import com.mywish.mykidsstory.databinding.FragmentLittlePigs1Binding
import com.mywish.mykidsstory.databinding.FragmentLittlePigs2Binding
import com.nitish.typewriterview.TypeWriterView

class LittlePigsFragment2 : Fragment() {
    private lateinit var fragmentLittlePigs2Binding: FragmentLittlePigs2Binding
    private lateinit var mediaPlayer: CustomMediaPlayer


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLittlePigs2Binding=FragmentLittlePigs2Binding.inflate(inflater,container,false)


        val typeWriterView: TypeWriterView = fragmentLittlePigs2Binding.typeWriterView
        typeWriterView.animateText(getString(R.string.the_little_three_pigs2))

        mediaPlayer = CustomMediaPlayer(requireContext())
        onPlayButtonClick()
        typeWriterView.setOnAnimationChangeListener {
            replaceWithFragment()
//            Toast.makeText(context, "text finished", Toast.LENGTH_SHORT).show()
        }

        return fragmentLittlePigs2Binding.root
    }

    private fun replaceWithFragment() {
        // Replace FragmentA with FragmentB
        val ft: FragmentTransaction = requireFragmentManager().beginTransaction()
        ft.replace(R.id.fragmentContainer,LittlePigsFragment3() , "NewFragmentTag")
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

    fun onPlayButtonClick() {
        // Replace R.raw.intheworld with the actual resource ID of your audio file
        val resourceId = R.raw.the_three_little_pigs2
        // Set the data source
        mediaPlayer.setDataSource(resourceId)
        // Start playing
        mediaPlayer.play()
    }


}