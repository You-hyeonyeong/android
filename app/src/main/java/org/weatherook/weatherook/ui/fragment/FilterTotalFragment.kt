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
import kotlinx.android.synthetic.main.filter_total.*
import org.weatherook.weatherook.R

/**
 * Created by HYEON on 2018-07-06.
 */
class FilterTotalFragment : Fragment(), View.OnClickListener {

    var total_style: ArrayList<TextView> = ArrayList()
    lateinit var totalSpinner: ArrayAdapter<CharSequence>
    var total_weather: ArrayList<TextView> = ArrayList()

    override fun onClick(p0: View?) {
        when (p0) {
            total_women -> {
                total_women.setTextColor(resources.getColor(R.color.weatherookTheme))
                total_women.setTypeface(null, Typeface.BOLD)
                total_men.setTextColor(Color.GRAY)
                total_men.setTypeface(null, Typeface.NORMAL)

            }
            total_men -> {
                total_men.setTextColor(resources.getColor(R.color.weatherookTheme))
                total_men.setTypeface(null, Typeface.BOLD)
                total_women.setTextColor(Color.GRAY)
                total_women.setTypeface(null, Typeface.NORMAL)
            }

        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.filter_total, container, false)
        return v
    }

    override fun onStart() {
        super.onStart()
        totalSpinner = ArrayAdapter.createFromResource(context, R.array.today_tall_spinner, android.R.layout.simple_spinner_dropdown_item)
        total_spinner_tall.adapter = totalSpinner
        total_women.setOnClickListener(this)
        total_men.setOnClickListener(this)

        total_style.add(total_style_btn1)
        total_style.add(total_style_btn2)
        total_style.add(total_style_btn3)
        total_style.add(total_style_btn4)
        total_style.add(total_style_btn5)
        total_style.add(total_style_btn6)
        total_style.add(total_style_btn7)
        total_style.add(total_style_btn8)
        total_style.add(total_style_btn9)
        total_style.add(total_style_btn10)

        for (ts in total_style) {
            ts.setOnClickListener {
                if (!ts.isSelected) {
                    ts.isSelected = true
                    ts.setTextColor(resources.getColor(R.color.weatherookTheme))
                    ts.setTypeface(null, Typeface.BOLD)
                } else {
                    ts.isSelected = false
                    ts.setTextColor(Color.GRAY)
                    ts.setTypeface(null,Typeface.NORMAL)
                }
            }
        }

        total_weather.add(total_weather_btn1)
        total_weather.add(total_weather_btn2)
        total_weather.add(total_weather_btn3)
        total_weather.add(total_weather_btn4)

        //var oldselected = old
        for (tw in total_weather) {
            tw.setOnClickListener {
                if (!tw.isSelected) {
                    tw.isSelected = true
                    tw.setTextColor(resources.getColor(R.color.weatherookTheme))
                    tw.setTypeface(null, Typeface.BOLD)
                } else {
                    tw.isSelected = false
                    tw.setTextColor(Color.GRAY)
                    tw.setTypeface(null,Typeface.NORMAL)
                }

                //Driver.galleryDriver.onNext(oldselected)
                //oldselected = tw
            }
        }

         /* galleryDriver.subscribe(){
               if(it.isSelected){
                   it.isSelected = false
               }
           }*/
    }

}