package com.mywish.mykidsstory.Fragment.TheThreeLittlePigs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.mywish.mykidsstory.R
import com.mywish.mykidsstory.databinding.FragmentLittlePigs13Binding
import com.mywish.mykidsstory.databinding.FragmentLittlePigs14Binding
import com.nitish.typewriterview.TypeWriterView


class LittlePigsFragment14 : Fragment() {

    private lateinit var fragmentLittlePigs14Binding:FragmentLittlePigs14Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLittlePigs14Binding= FragmentLittlePigs14Binding.inflate(inflater,container,false)

        val typeWriterView: TypeWriterView = fragmentLittlePigs14Binding.typeWriterView
        typeWriterView.animateText(getString(R.string.the_little_three_pigs14))
        typeWriterView.setOnAnimationChangeListener {
            replaceWithFragment()
            Toast.makeText(context, "text finished", Toast.LENGTH_SHORT).show()
        }
        return fragmentLittlePigs14Binding.root
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

        ft.replace(R.id.fragmentContainer, LittlePigsFragment15(), "NewFragmentTag")
        ft.addToBackStack(null)  // Optional: Allows back navigation to the previous fragment
        ft.commit()
    }



}