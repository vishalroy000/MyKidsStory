package com.mywish.mykidsstory.Fragment.TheThreeLittlePigs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.mywish.mykidsstory.R
import com.mywish.mykidsstory.databinding.FragmentLittlePigs10Binding
import com.mywish.mykidsstory.databinding.FragmentLittlePigs9Binding
import com.nitish.typewriterview.TypeWriterView


class LittlePigsFragment10 : Fragment() {


    private lateinit var fragmentLittlePigs10Binding: FragmentLittlePigs10Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLittlePigs10Binding= FragmentLittlePigs10Binding.inflate(inflater,container,false)

        val typeWriterView: TypeWriterView = fragmentLittlePigs10Binding.typeWriterView
        typeWriterView.animateText(getString(R.string.the_little_three_pigs10))
        typeWriterView.setOnAnimationChangeListener {
            replaceWithFragment()
            Toast.makeText(context, "text finished", Toast.LENGTH_SHORT).show()
        }
        return fragmentLittlePigs10Binding.root
    }


    private fun replaceWithFragment() {
        // Replace FragmentA with FragmentB
        val ft: FragmentTransaction = requireFragmentManager().beginTransaction()
        ft.replace(R.id.fragmentContainer,LittlePigsFragment11() , "NewFragmentTag")
        ft.commit()
    }

}