package com.mywish.mykidsstory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.commit
import androidx.viewpager2.widget.ViewPager2
import com.mywish.mykidsstory.Fragment.TheThreeLittlePigs.LittlePigsFragment
import com.mywish.mykidsstory.Fragment.TheThreeLittlePigs.LittlePigsFragment1
import com.mywish.mykidsstory.Fragment.TheThreeLittlePigs.LittlePigsFragment10
import com.mywish.mykidsstory.Fragment.TheThreeLittlePigs.LittlePigsFragment11
import com.mywish.mykidsstory.Fragment.TheThreeLittlePigs.LittlePigsFragment12
import com.mywish.mykidsstory.Fragment.TheThreeLittlePigs.LittlePigsFragment13
import com.mywish.mykidsstory.Fragment.TheThreeLittlePigs.LittlePigsFragment14
import com.mywish.mykidsstory.Fragment.TheThreeLittlePigs.LittlePigsFragment15
import com.mywish.mykidsstory.Fragment.TheThreeLittlePigs.LittlePigsFragment16
import com.mywish.mykidsstory.Fragment.TheThreeLittlePigs.LittlePigsFragment17
import com.mywish.mykidsstory.Fragment.TheThreeLittlePigs.LittlePigsFragment18
import com.mywish.mykidsstory.Fragment.TheThreeLittlePigs.LittlePigsFragment19
import com.mywish.mykidsstory.Fragment.TheThreeLittlePigs.LittlePigsFragment2
import com.mywish.mykidsstory.Fragment.TheThreeLittlePigs.LittlePigsFragment3
import com.mywish.mykidsstory.Fragment.TheThreeLittlePigs.LittlePigsFragment4
import com.mywish.mykidsstory.Fragment.TheThreeLittlePigs.LittlePigsFragment5
import com.mywish.mykidsstory.Fragment.TheThreeLittlePigs.LittlePigsFragment6
import com.mywish.mykidsstory.Fragment.TheThreeLittlePigs.LittlePigsFragment7
import com.mywish.mykidsstory.Fragment.TheThreeLittlePigs.LittlePigsFragment8
import com.mywish.mykidsstory.Fragment.TheThreeLittlePigs.LittlePigsFragment9
import com.mywish.mykidsstory.databinding.ActivityStoryViewerBinding

class StoryViewerActivity : AppCompatActivity() {
     var currentFragmentIndex = 0
    lateinit var viewPager:ViewPager2

    private lateinit var viewPagerHelper: ViewPagerHelper
    val fragmentList = listOf(
        LittlePigsFragment(),
        LittlePigsFragment1(),
        LittlePigsFragment2(),
        LittlePigsFragment3(),
        LittlePigsFragment4(),
        LittlePigsFragment5(),
        LittlePigsFragment6(),
        LittlePigsFragment7(),
        LittlePigsFragment8(),
        LittlePigsFragment9(),
        LittlePigsFragment10(),
        LittlePigsFragment11(),
        LittlePigsFragment12(),
        LittlePigsFragment13(),
        LittlePigsFragment14(),
        LittlePigsFragment15(),
        LittlePigsFragment16(),
        LittlePigsFragment17(),
        LittlePigsFragment18(),
        LittlePigsFragment19(),
        // Add more fragments as needed
    )

    private lateinit var storyViewerActivityBinding: ActivityStoryViewerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        storyViewerActivityBinding=ActivityStoryViewerBinding.inflate(layoutInflater)
        setContentView(storyViewerActivityBinding.root)
         viewPager = findViewById<ViewPager2>(R.id.Story_viewPager)



        storyViewerActivityBinding.btnPrevious.setOnClickListener {
            if (currentFragmentIndex > 0) {
                currentFragmentIndex--
                viewPager.setCurrentItem(currentFragmentIndex, true)
            }
        }

        storyViewerActivityBinding.btnNext.setOnClickListener {
            if (currentFragmentIndex < fragmentList.size - 1) {
                currentFragmentIndex++
                viewPager.setCurrentItem(currentFragmentIndex, true)
            }
        }


        viewPagerHelper = ViewPagerHelper(this, viewPager)
        viewPager.setPageTransformer(StoryPageTransformer())
        viewPagerHelper.setupViewPager(fragmentList)



    }






}