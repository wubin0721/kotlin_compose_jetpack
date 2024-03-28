package com.demo.kotlin_compose.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.demo.kotlin_compose.Fragment.GuideFragment

class GuideAdapter(fm: FragmentManager, lifecycle: Lifecycle, private val mImageArray: IntArray) :
    FragmentStateAdapter(fm, lifecycle) {
    override fun createFragment(position: Int): Fragment {
        return GuideFragment.newInstance(mImageArray.size,
            position, mImageArray[position])
    }

    override fun getItemCount(): Int {
        return mImageArray.size
    }
}
