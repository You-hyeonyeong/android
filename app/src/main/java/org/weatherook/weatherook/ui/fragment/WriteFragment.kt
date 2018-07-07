package org.weatherook.weatherook.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_write.*
import kotlinx.android.synthetic.main.fragment_write.view.*
import org.weatherook.weatherook.R

class WriteFragment : Fragment() {

    var style: ArrayList<TextView> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = View.inflate(activity, R.layout.fragment_write, null)

        style.add(view.write_style1)
        style.add(view.write_style2)
        style.add(view.write_style3)
        style.add(view.write_style4)
        style.add(view.write_style5)
        style.add(view.write_style6)

        /*view.write_style1.setOnClickListener { if(!view.write_style1.isSelected){
            view.write_style1.isSelected = true
            view.write_style1.setTextColor(resources.getColor(android.R.color.white))
        }else{
            view.write_style1.isSelected = false
            view.write_style1.setTextColor(resources.getColor(R.color.colorAccent))
        } }*/

        for (st in style) {
            st.setOnClickListener {
                if (!st.isSelected) {
                    st.isSelected = true
                    st.setTextColor(resources.getColor(android.R.color.white))
                } else {
                    st.isSelected = false
                    st.setTextColor(resources.getColor(R.color.colorAccent))
                }
            }
        }

        return view
    }
}