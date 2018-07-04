package org.weatherook.weatherook

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class SignupPagerAdapter (fm : FragmentManager) : FragmentPagerAdapter(fm)  {


    val imageCount = 3
    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return SignupAFragment()
            1 -> return SignupBFragment()
            else -> return SignupCFragment()
        }
    }

    override fun getCount(): Int {
        return imageCount
    }



}