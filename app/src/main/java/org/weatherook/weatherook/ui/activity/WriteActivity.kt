package org.weatherook.weatherook.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_write.*
import org.weatherook.weatherook.R

class WriteActivity : AppCompatActivity(),View.OnClickListener {
    override fun onClick(v: View?) {
        when (v) {
        /* write_public ->{
                write_public.isSelected = true
            }*/
        }
    }

    var style: ArrayList<TextView> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        style.add(write_style1)
        style.add(write_style2)
        style.add(write_style3)
        style.add(write_style4)
        style.add(write_style5)
        style.add(write_style6)

        write_style1.setOnClickListener {
            if (!write_style1.isSelected) {
                write_style1.isSelected = true
                write_style1.setTextColor(resources.getColor(android.R.color.white))
            } else {
                write_style1.isSelected = false
                write_style1.setTextColor(resources.getColor(R.color.colorAccent))
            }
        }


        for (st in style) {
            st.setOnClickListener {
                if (!st.isSelected) {
                    st.isSelected = true
                    st.setTextColor(resources.getColor(android.R.color.white))
                } else {
                    st.isSelected = false
                    st.setTextColor(resources.getColor(R.color.gray))
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        write_public.setOnClickListener {
            if (!write_public.isSelected) {
                write_public.isSelected = true
            } else {
                write_public.isSelected = false
            }
        }
    }
}
