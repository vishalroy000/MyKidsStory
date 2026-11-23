package com.mywish.mykidsstory.Fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.mywish.mykidsstory.Fragment.TheThreeLittlePigs.LittlePigsFragment2
import com.mywish.mykidsstory.InterstitialAdManager
import com.mywish.mykidsstory.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

open class BaseFragment : Fragment() {

    protected lateinit var mediaPlayer: MediaPlayer
    protected lateinit var progressBar: ProgressBar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Assuming you have a ProgressBar in the layout with the ID progressBar
    }

    protected fun playAudioFromUrl(url: String) {
        progressBar.visibility = ProgressBar.VISIBLE

        mediaPlayer = MediaPlayer().apply {
            setOnPreparedListener { mp ->
                progressBar.visibility = ProgressBar.GONE
                mp.start()
            }
            setOnCompletionListener {
                progressBar.visibility = ProgressBar.GONE
            }
            setOnErrorListener { mp, what, extra ->
                progressBar.visibility = ProgressBar.GONE
                false
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            try {
                mediaPlayer.setDataSource(url)
                mediaPlayer.prepareAsync()
            } catch (e: IOException) {
                showError()
            }
        }
    }


     fun replaceWithFragment(layout_id:Int,fragment: Fragment) {
        // Replace FragmentA with FragmentB
        InterstitialAdManager.loadInterstitialAd(requireContext(), "ca-app-pub-8634900064580620/9230714495")

        val ft: FragmentTransaction = requireFragmentManager().beginTransaction()
        ft.replace(layout_id, fragment , "NewFragmentTag")
        ft.commit()
    }

    protected fun showError() {
        progressBar.visibility = ProgressBar.GONE
        // Handle error logic here, like showing an error message.
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}
