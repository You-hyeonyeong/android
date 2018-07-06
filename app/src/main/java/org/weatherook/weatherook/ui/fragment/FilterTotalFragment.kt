package org.weatherook.weatherook.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.weatherook.weatherook.R

/**
 * Created by HYEON on 2018-07-06.
 */
class FilterTotalFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.filter_total, container, false)
        return v
    }
}