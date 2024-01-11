package com.mywish.mykidsstory.Fragment.TheThreeLittlePigs

import CustomMediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
        mediaPlayer = CustomMediaPlayer(requireContext())
        onPlayButtonClick()

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

    fun onPlayButtonClick() {
        // Replace R.raw.intheworld with the actual resource ID of your audio file
        val resourceId = R.raw.the_three_little_pigs19
        // Set the data source
        mediaPlayer.setDataSource(resourceId)
        // Start playing
        mediaPlayer.play()
    }


}