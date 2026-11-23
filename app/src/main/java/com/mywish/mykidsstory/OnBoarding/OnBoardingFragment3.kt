package com.mywish.mykidsstory.OnBoarding


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView
import com.mywish.mykidsstory.databinding.FragmentOnBoarding3Binding
import com.mywish.mykidsstory.databinding.FragmentOnBoarding4Binding

//import com.thecode.onboardingviewagerexamples.R
//import com.thecode.onboardingviewagerexamples.databinding.FragmentOnboarding3Binding

class OnboardingFragment3 : Fragment() {
    private lateinit var title: String
    private lateinit var description: String
    private lateinit var backgroundColor: String
    private var imageResource = 0
    private lateinit var tvTitle: TextView
//    private lateinit var tvDescription: AppCompatTextView
    private lateinit var image: ImageView
    private lateinit var layout: RelativeLayout
    private lateinit var mFakeStatusBar: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            title = requireArguments().getString(ARG_PARAM1)!!
            description = requireArguments().getString(ARG_PARAM2)!!
            imageResource = requireArguments().getInt(ARG_PARAM3)
//            backgroundColor = requireArguments().getString(ARG_PARAM4)!!
        }
    }

    private var _binding: FragmentOnBoarding3Binding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOnBoarding3Binding.inflate(inflater, container, false)
        val view = binding.root
        tvTitle = binding.textOnBoardingTitle

        tvTitle.text = title
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"
        private const val ARG_PARAM3 = "param3"
        fun newInstance(
            title: String,
            description: String,
            imageResource: Int
        ): OnboardingFragment3 {
            val fragment =
                OnboardingFragment3()
            val args = Bundle()
            args.putString(
                ARG_PARAM1,
                title
            )
            args.putString(
                ARG_PARAM2,
                description
            )
            args.putInt(
                ARG_PARAM3,
                imageResource
            )



            fragment.arguments = args
            return fragment
        }
    }
}