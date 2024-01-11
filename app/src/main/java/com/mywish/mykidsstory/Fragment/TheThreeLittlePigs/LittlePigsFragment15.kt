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
import com.mywish.mykidsstory.databinding.FragmentLittlePigs14Binding
import com.mywish.mykidsstory.databinding.FragmentLittlePigs15Binding
import com.nitish.typewriterview.TypeWriterView

class LittlePigsFragment15 : Fragment() {

private lateinit var fragmentLittlePigs15BindingL:FragmentLittlePigs15Binding

    private lateinit var mediaPlayer: CustomMediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLittlePigs15BindingL= FragmentLittlePigs15Binding.inflate(inflater,container,false)

        val typeWriterView: TypeWriterView = fragmentLittlePigs15BindingL.typeWriterView
        typeWriterView.animateText(getString(R.string.the_little_three_pigs15))
        mediaPlayer = CustomMediaPlayer(requireContext())
        onPlayButtonClick()
        typeWriterView.setOnAnimationChangeListener {
            replaceWithFragment()
            Toast.makeText(context, "text finished", Toast.LENGTH_SHORT).show()
        }
        return fragmentLittlePigs15BindingL.root
    }

    private fun replaceWithFragment() {
        // Replace FragmentA with FragmentB with transition animations
        val ft: FragmentTransaction = requireFragmentManager().beginTransaction()

        // Set custom animations
        ft.setCustomAnimations(
            R.anim.slide_in_right, // Enter animation for FragmentB
            R.anim.slide_out_left, // Exit animation for FragmentA
            R.anim.slide_in_left,  // Enter animation for FragmentA
            R.anim.slide_out_right // Exit animation for FragmentB
        )

        ft.replace(R.id.fragmentContainer, LittlePigsFragment16(), "NewFragmentTag")
        ft.addToBackStack(null)  // Optional: Allows back navigation to the previous fragment
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
        val resourceId = R.raw.the_three_little_pigs15
        // Set the data source
        mediaPlayer.setDataSource(resourceId)
        // Start playing
        mediaPlayer.play()
    }

}