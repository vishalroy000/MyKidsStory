package com.mywish.mykidsstory.Fragment.TheThreeLittlePigs

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.mywish.mykidsstory.R
import com.mywish.mykidsstory.databinding.FragmentLittlePigs1Binding
import com.nitish.typewriterview.TypeWriterView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException


class LittlePigsFragment1 : Fragment() {


    private lateinit var fragmentLittlePigs1Binding: FragmentLittlePigs1Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLittlePigs1Binding=FragmentLittlePigs1Binding.inflate(inflater,container,false)

        val text = getString(R.string.the_little_three_pigs1)
        fragmentLittlePigs1Binding.typeWriterView.text = HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_LEGACY)

        val typeWriterView: TypeWriterView = fragmentLittlePigs1Binding.typeWriterView
        typeWriterView.animateText(getString(R.string.the_little_three_pigs1))
//        fragmentLittlePigs1Binding.progressBar2.visibility=View.GONE
        playAudioFromUrl(getString(R.string.audio_link_the_little_three_pigs1))


        typeWriterView.setOnAnimationChangeListener {
            replaceWithFragment()
        }

        return fragmentLittlePigs1Binding.root
    }


    private fun replaceWithFragment() {
        // Replace FragmentA with FragmentB

        val ft: FragmentTransaction = requireFragmentManager().beginTransaction()
        ft.replace(R.id.fragmentContainer,LittlePigsFragment2() , "NewFragmentTag")
        ft.commit()
    }


    private fun playAudioFromUrl(url: String) {
        fragmentLittlePigs1Binding.progressBar2.visibility = ProgressBar.VISIBLE

        val mediaPlayer = MediaPlayer().apply {
            setOnPreparedListener { mp ->
                fragmentLittlePigs1Binding.progressBar2.visibility = ProgressBar.GONE
                mp.start()
            }
            setOnCompletionListener {
                fragmentLittlePigs1Binding.progressBar2.visibility = ProgressBar.GONE
            }
            setOnErrorListener { mp, what, extra ->
                fragmentLittlePigs1Binding.progressBar2.visibility = ProgressBar.GONE
                false
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            try {
                mediaPlayer.setDataSource(url)
                mediaPlayer.prepareAsync()
            } catch (e: IOException) {
                fragmentLittlePigs1Binding.progressBar2.visibility = ProgressBar.GONE
            }
        }
    }



}
