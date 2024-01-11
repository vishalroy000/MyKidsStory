package com.mywish.mykidsstory

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
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


class ViewPagerHelper(private val activity: AppCompatActivity, private val viewPager: ViewPager2) {


    fun setupViewPager(fragmentList: List<Fragment>) {
        viewPager.adapter = MyPagerAdapter(activity, fragmentList)
        viewPager.setPageTransformer(StoryPageTransformer())
    }
}

private class MyPagerAdapter(activity: AppCompatActivity, private val fragmentList: List<Fragment>) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment = fragmentList[position]

}

class StoryPageTransformer : ViewPager2.PageTransformer {

    override fun transformPage(page: View, position: Float) {
        page.apply {
            when {
                position < -1 -> { // [-Infinity,-1)
                    alpha = 0f
                }
                position <= 0 -> { // [-1,0]
                    alpha = 1 + position
                    translationX = width * -position
                }
                position <= 1 -> { // (0,1]
                    alpha = 1 - position
                    translationX = width * -position
                }
                else -> { // (1,+Infinity]
                    alpha = 0f
                }
            }
        }
    }
}
