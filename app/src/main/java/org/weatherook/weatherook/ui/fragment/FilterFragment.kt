package org.weatherook.weatherook.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_filter.*
import org.weatherook.weatherook.R

class FilterFragment :  Fragment(), View.OnClickListener{
    override fun onClick(p0: View?) {

        when(p0) {
            filter_today -> {
                val fragmentTransaction = fragmentManager!!.beginTransaction()
                fragmentTransaction.replace(R.id.filter_frame, FilterTodayFragment()).commit()
            }
            filter_total -> {
                val fragmentTransaction = fragmentManager!!.beginTransaction()
                fragmentTransaction.replace(R.id.filter_frame, FilterTotalFragment()).commit()

            }
        }

    }


    override fun onCreateView(inflater: LayoutInflater, conatiner: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = View.inflate(activity, R.layout.fragment_filter, null)

        //val mygrid_recycle : RecyclerView = view.findViewById(R.id.setting_grid_recycle)
        //val mylist_recycle : RecyclerView = view.findViewById(R.id.setting_list_recycle)

        //val fragmentManager : FragmentManager = activity!!.supportFragmentManager

        return view
}


    override fun onStart() {
        super.onStart()
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction.replace(R.id.filter_frame, FilterTodayFragment()).commit()
        //my_grid_img.isSelected = true
        filter_today.setOnClickListener(this)
        filter_total.setOnClickListener(this)

    }



}