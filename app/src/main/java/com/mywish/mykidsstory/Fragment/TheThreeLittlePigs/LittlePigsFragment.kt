package com.mywish.mykidsstory.Fragment.TheThreeLittlePigs

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.mywish.mykidsstory.Fragment.BaseFragment
import com.mywish.mykidsstory.R
import com.mywish.mykidsstory.databinding.FragmentLittlePigsBinding


class LittlePigsFragment : Fragment() {


    private val pauseTime = 3000L // 3 seconds delay


    private lateinit var fragmentLittlePigsBinding:FragmentLittlePigsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLittlePigsBinding=FragmentLittlePigsBinding.inflate(inflater,container,false)


        Handler().postDelayed({ replaceWithFragment() }, pauseTime)

//        playAudioFromUrl("https://s5-6.ttsmaker-file.com/file/2024-01-11-014352_193305.mp3")
        // Inflate the layout for this fragment
//        val animationDrawable = fragmentLittlePigsBinding.layout.background as AnimationDrawable
//        animationDrawable.setEnterFadeDuration(1500)
//        animationDrawable.setExitFadeDuration(3000)
//        animationDrawable.start()
        return fragmentLittlePigsBinding.root
    }

    private fun replaceWithFragment() {
        // Replace FragmentA with FragmentB

        val ft: FragmentTransaction = requireFragmentManager().beginTransaction()
        ft.replace(R.id.fragmentContainer,LittlePigsFragment1() , "NewFragmentTag")
        ft.commit()
    }

}