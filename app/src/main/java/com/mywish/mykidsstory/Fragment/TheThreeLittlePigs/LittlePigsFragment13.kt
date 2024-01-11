package com.mywish.mykidsstory.Fragment.TheThreeLittlePigs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.mywish.mykidsstory.R
import com.mywish.mykidsstory.databinding.FragmentLittlePigs12Binding
import com.mywish.mykidsstory.databinding.FragmentLittlePigs13Binding
import com.nitish.typewriterview.TypeWriterView


class LittlePigsFragment13 : Fragment() {

private lateinit var fragmentLittlePigs13Binding:FragmentLittlePigs13Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentLittlePigs13Binding= FragmentLittlePigs13Binding.inflate(inflater,container,false)

        val typeWriterView: TypeWriterView = fragmentLittlePigs13Binding.typeWriterView
        typeWriterView.animateText(getString(R.string.the_little_three_pigs13))
        typeWriterView.setOnAnimationChangeListener {
            replaceWithFragment()
            Toast.makeText(context, "text finished", Toast.LENGTH_SHORT).show()
        }
        return fragmentLittlePigs13Binding.root
    }

    private fun replaceWithFragment() {
        // Replace FragmentA with FragmentB
        val ft: FragmentTransaction = requireFragmentManager().beginTransaction()
        ft.replace(R.id.fragmentContainer,LittlePigsFragment14() , "NewFragmentTag")
        ft.commit()
    }

}