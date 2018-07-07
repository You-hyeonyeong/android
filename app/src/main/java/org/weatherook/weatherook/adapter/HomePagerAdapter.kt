package org.weatherook.weatherook.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import org.weatherook.weatherook.ui.fragment.TodayFragment
import org.weatherook.weatherook.ui.fragment.TomorrowFragment
import org.weatherook.weatherook.ui.fragment.YesterdayFragment

class HomePagerAdapter  (fm : FragmentManager) : FragmentPagerAdapter(fm)  {

    val imageCount = 3
    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return YesterdayFragment()
            1 -> return TodayFragment()
            else -> return TomorrowFragment()
        }
    }

    override fun getCount(): Int {
        return imageCount
    }


}