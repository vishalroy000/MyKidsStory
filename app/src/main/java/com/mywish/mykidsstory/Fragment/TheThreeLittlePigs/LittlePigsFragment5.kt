package com.mywish.mykidsstory.Fragment.TheThreeLittlePigs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.mywish.mykidsstory.R
import com.mywish.mykidsstory.databinding.FragmentLittlePigs2Binding
import com.mywish.mykidsstory.databinding.FragmentLittlePigs5Binding
import com.nitish.typewriterview.TypeWriterView

class LittlePigsFragment5 : Fragment() {

    private lateinit var fragmentLittlePigs5Binding:FragmentLittlePigs5Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLittlePigs5Binding= FragmentLittlePigs5Binding.inflate(inflater,container,false)

        val typeWriterView: TypeWriterView = fragmentLittlePigs5Binding.typeWriterView
        typeWriterView.animateText(getString(R.string.the_little_three_pigs5))

        typeWriterView.setOnAnimationChangeListener {
            replaceWithFragment()
            Toast.makeText(context, "text finished", Toast.LENGTH_SHORT).show()
        }
        return fragmentLittlePigs5Binding.root
    }

    private fun replaceWithFragment() {
        // Replace FragmentA with FragmentB
        val ft: FragmentTransaction = requireFragmentManager().beginTransaction()
        ft.replace(R.id.fragmentContainer,LittlePigsFragment6() , "NewFragmentTag")
        ft.commit()
    }

}