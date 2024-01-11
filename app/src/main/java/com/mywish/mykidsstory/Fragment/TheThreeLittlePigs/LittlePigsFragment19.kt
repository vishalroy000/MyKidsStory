package com.mywish.mykidsstory.Fragment.TheThreeLittlePigs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.mywish.mykidsstory.R
import com.mywish.mykidsstory.databinding.FragmentLittlePigs18Binding
import com.mywish.mykidsstory.databinding.FragmentLittlePigs19Binding
import com.nitish.typewriterview.TypeWriterView


class LittlePigsFragment19 : Fragment() {

    private lateinit var fragmentLittlePigs19Binding:FragmentLittlePigs19Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLittlePigs19Binding= FragmentLittlePigs19Binding.inflate(inflater,container,false)

        val typeWriterView: TypeWriterView = fragmentLittlePigs19Binding.typeWriterView
        typeWriterView.animateText(getString(R.string.the_little_three_pigs19))
        return fragmentLittlePigs19Binding.root


    }

}