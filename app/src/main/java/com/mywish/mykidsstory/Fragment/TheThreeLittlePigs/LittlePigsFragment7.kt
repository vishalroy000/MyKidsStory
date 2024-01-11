package com.mywish.mykidsstory.Fragment.TheThreeLittlePigs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.mywish.mykidsstory.R
import com.mywish.mykidsstory.databinding.FragmentLittlePigs6Binding
import com.mywish.mykidsstory.databinding.FragmentLittlePigs7Binding
import com.nitish.typewriterview.TypeWriterView


class LittlePigsFragment7 : Fragment() {


    private lateinit var fragmentLittlePigs7Binding:FragmentLittlePigs7Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLittlePigs7Binding= FragmentLittlePigs7Binding.inflate(inflater,container,false)

        val typeWriterView: TypeWriterView = fragmentLittlePigs7Binding.typeWriterView
        typeWriterView.animateText(getString(R.string.the_little_three_pigs7))

        typeWriterView.setOnAnimationChangeListener {
            replaceWithFragment()
            Toast.makeText(context, "text finished", Toast.LENGTH_SHORT).show()
        }
        return fragmentLittlePigs7Binding.root
    }

    private fun replaceWithFragment() {
        // Replace FragmentA with FragmentB
        val ft: FragmentTransaction = requireFragmentManager().beginTransaction()
        ft.replace(R.id.fragmentContainer,LittlePigsFragment8() , "NewFragmentTag")
        ft.commit()
    }

}