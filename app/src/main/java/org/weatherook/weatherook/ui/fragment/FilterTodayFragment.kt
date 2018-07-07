package org.weatherook.weatherook.ui.fragment

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.filter_today.*
import org.weatherook.weatherook.R

/**
 * Created by HYEON on 2018-07-06.
 */
class FilterTodayFragment : Fragment(),View.OnClickListener {

    var today_style: ArrayList<TextView> = ArrayList()
    lateinit var todaySpinner: ArrayAdapter<CharSequence>

    override fun onClick(p0: View?) {

        when (p0) {
            today_women -> {
                today_women.setTextColor(resources.getColor(R.color.weatherookTheme))
                today_women.setTypeface(null, Typeface.BOLD)
                today_men.setTextColor(Color.GRAY)
                today_men.setTypeface(null, Typeface.NORMAL)

            }
            today_men -> {
                today_men.setTextColor(resources.getColor(R.color.weatherookTheme))
                today_men.setTypeface(null, Typeface.BOLD)
                today_women.setTextColor(Color.GRAY)
                today_women.setTypeface(null, Typeface.NORMAL)
            }

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.filter_today, container, false)
        return v
    }


    override fun onStart() {
        super.onStart()
        todaySpinner = ArrayAdapter.createFromResource(context, R.array.today_tall_spinner, android.R.layout.simple_spinner_dropdown_item)
        today_spinner_tall.adapter = todaySpinner
        today_women.setOnClickListener(this)
        today_men.setOnClickListener(this)

        today_style.add(today_style_btn1)
        today_style.add(today_style_btn2)
        today_style.add(today_style_btn3)
        today_style.add(today_style_btn4)
        today_style.add(today_style_btn5)
        today_style.add(today_style_btn6)
        today_style.add(today_style_btn7)
        today_style.add(today_style_btn8)
        today_style.add(today_style_btn9)
        today_style.add(today_style_btn10)

        for (ts in today_style) {
            ts.setOnClickListener {
                if (!ts.isSelected) {
                    ts.isSelected = true
                    ts.setTextColor(resources.getColor(R.color.weatherookTheme))
                    ts.setTypeface(null,Typeface.BOLD)
                } else {
                    ts.isSelected = false
                    ts.setTextColor(Color.GRAY)
                    ts.setTypeface(null,Typeface.NORMAL)
                }
            }
        }
    }
}