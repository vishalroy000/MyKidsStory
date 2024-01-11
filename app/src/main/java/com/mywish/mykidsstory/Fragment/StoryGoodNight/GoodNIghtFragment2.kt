package com.mywish.mykidsstory.Fragment.StoryGoodNight


import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import com.mywish.mykidsstory.R
import com.mywish.mykidsstory.databinding.FragmentGoodNIght2Binding
import com.nitish.typewriterview.TypeWriterView
import java.util.Locale

class GoodNIghtFragment2 : Fragment()  {

    private var _binding: FragmentGoodNIght2Binding? = null
    private val binding get() = _binding!!
//    private lateinit var textToSpeechHelper: TextToSpeechHelper


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGoodNIght2Binding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val typeWriterView: TypeWriterView = binding.typeWriterView
        typeWriterView.animateText(getString(R.string.good_night_page1))
        // Initialize TextToSpeechHelper


    }

    override fun onDestroyView() {
        _binding = null
//        textToSpeechHelper.shutdown()
        super.onDestroyView()


    }






}
