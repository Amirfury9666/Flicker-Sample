package com.fury.flickerapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPageAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {


    private var mFragments = arrayListOf<Fragment>()
    private var mTitles  = arrayListOf<String>()


    fun addFragment(fragment : Fragment,title : String){
        this.mFragments.add(fragment)
        this.mTitles.add(title)
    }

    override fun getItem(position: Int): Fragment = mFragments[position]

    override fun getCount(): Int  = mFragments.size

    override fun getPageTitle(position: Int): CharSequence? = mTitles[position]
}