package com.mywish.mykidsstory.Fragment.TheThreeLittlePigs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.mywish.mykidsstory.R
import com.mywish.mykidsstory.databinding.FragmentLittlePigs2Binding
import com.mywish.mykidsstory.databinding.FragmentLittlePigs3Binding
import com.nitish.typewriterview.TypeWriterView


class LittlePigsFragment3 : Fragment() {

    private lateinit var fragmentLittlePigs3Binding:FragmentLittlePigs3Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLittlePigs3Binding= FragmentLittlePigs3Binding.inflate(inflater,container,false)

        val typeWriterView: TypeWriterView = fragmentLittlePigs3Binding.typeWriterView
        typeWriterView.animateText(getString(R.string.the_little_three_pigs3))

        typeWriterView.setOnAnimationChangeListener {
            replaceWithFragment()
//            Toast.makeText(context, "text finished", Toast.LENGTH_SHORT).show()
        }

        return fragmentLittlePigs3Binding.root
    }

    private fun replaceWithFragment() {
        // Replace FragmentA with FragmentB
        val ft: FragmentTransaction = requireFragmentManager().beginTransaction()
        ft.replace(R.id.fragmentContainer,LittlePigsFragment4() , "NewFragmentTag")
        ft.commit()
    }
}