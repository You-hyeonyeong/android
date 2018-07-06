package org.weatherook.weatherook.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import org.weatherook.weatherook.ui.fragment.SignupAFragment
import org.weatherook.weatherook.ui.fragment.SignupBFragment
import org.weatherook.weatherook.ui.fragment.SignupCFragment

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