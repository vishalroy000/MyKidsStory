package com.mywish.mykidsstory.Fragment.TheThreeLittlePigs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.mywish.mykidsstory.R
import com.mywish.mykidsstory.databinding.FragmentLittlePigs16Binding
import com.mywish.mykidsstory.databinding.FragmentLittlePigs17Binding
import com.nitish.typewriterview.TypeWriterView

class LittlePigsFragment17 : Fragment() {

    private lateinit var fragmentLittlePigs17Binding:FragmentLittlePigs17Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLittlePigs17Binding= FragmentLittlePigs17Binding.inflate(inflater,container,false)

        val typeWriterView: TypeWriterView = fragmentLittlePigs17Binding.typeWriterView
        typeWriterView.animateText(getString(R.string.the_little_three_pigs17))

        typeWriterView.setOnAnimationChangeListener {
            replaceWithFragment()
            Toast.makeText(context, "text finished", Toast.LENGTH_SHORT).show()
        }
        return fragmentLittlePigs17Binding.root
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

        ft.replace(R.id.fragmentContainer, LittlePigsFragment18(), "NewFragmentTag")
        ft.addToBackStack(null)  // Optional: Allows back navigation to the previous fragment
        ft.commit()
    }


}