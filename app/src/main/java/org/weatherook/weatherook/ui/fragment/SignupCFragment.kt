package org.weatherook.weatherook

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_signup_b.*
import kotlinx.android.synthetic.main.fragment_signup_c.*
import org.weatherook.weatherook.ui.activity.SigninActivity

class SignupCFragment : Fragment(), View.OnClickListener {

   // var state_a : Boolean = false

    var style : ArrayList<TextView> = ArrayList()
    override fun onClick(v: View?) {

        when(v){
            signup_join -> {
                startActivity(Intent(context, SigninActivity::class.java))
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_signup_c, container, false)

        return v
    }

    override fun onStart() {
        super.onStart()

        signup_join.setOnClickListener(this)
        style.add(signup_a)
        style.add(signup_b)
        style.add(signup_c)
        style.add(signup_d)
        style.add(signup_e)
        style.add(signup_f)
        style.add(signup_g)
        style.add(signup_h)
        style.add(signup_i)
        style.add(signup_j)

        for(st in style){
            st.setOnClickListener {
                if(!st.isSelected){
                    st.isSelected = true
                    st.setTextColor(resources.getColor(android.R.color.white))
                }else{
                    st.isSelected = false
                    st.setTextColor(resources.getColor(R.color.colorAccent))
                }
            }
        }

/*

        signup_a.setOnClickListener {
            if(!signup_a.isSelected){
                signup_a.isSelected = true
                signup_a.setTextColor(resources.getColor(android.R.color.white))
           }else{
                signup_a.isSelected = false
                signup_a.setTextColor(resources.getColor(R.color.colorAccent))
            }
        }

        signup_b.setOnClickListener {
            if(!signup_b.isSelected){
                signup_b.isSelected = true
                signup_b.setTextColor(resources.getColor(android.R.color.white))
            }else{
                signup_b.isSelected = false
                signup_b.setTextColor(resources.getColor(R.color.colorAccent))
            }
        }

        signup_c.setOnClickListener {
            if(!signup_c.isSelected){
                signup_c.isSelected = true
                signup_c.setTextColor(resources.getColor(android.R.color.white))
            }else{
                signup_c.isSelected = false
                signup_c.setTextColor(resources.getColor(R.color.colorAccent))
            }
        }

        signup_d.setOnClickListener {
            if(!signup_d.isSelected){
                signup_d.isSelected = true
                signup_d.setTextColor(resources.getColor(android.R.color.white))
            }else{
                signup_d.isSelected = false
                signup_d.setTextColor(resources.getColor(R.color.colorAccent))
            }
        }

        signup_e.setOnClickListener {
            if(!signup_e.isSelected){
                signup_e.isSelected = true
                signup_e.setTextColor(resources.getColor(android.R.color.white))
            }else{
                signup_e.isSelected = false
                signup_e.setTextColor(resources.getColor(R.color.colorAccent))
            }
        }

        signup_f.setOnClickListener {
            if(!signup_f.isSelected){
                signup_f.isSelected = true
                signup_f.setTextColor(resources.getColor(android.R.color.white))
            }else{
                signup_f.isSelected = false
                signup_f.setTextColor(resources.getColor(R.color.colorAccent))
            }
        }

        signup_g.setOnClickListener {
            if(!signup_g.isSelected){
                signup_g.isSelected = true
                signup_g.setTextColor(resources.getColor(android.R.color.white))
            }else{
                signup_g.isSelected = false
                signup_g.setTextColor(resources.getColor(R.color.colorAccent))
            }
        }

        signup_h.setOnClickListener {
            if(!signup_h.isSelected){
                signup_h.isSelected = true
                signup_h.setTextColor(resources.getColor(android.R.color.white))
            }else{
                signup_h.isSelected = false
                signup_h.setTextColor(resources.getColor(R.color.colorAccent))
            }
        }

        signup_i.setOnClickListener {
            if(!signup_i.isSelected){
                signup_i.isSelected = true
                signup_i.setTextColor(resources.getColor(android.R.color.white))
            }else{
                signup_i.isSelected = false
                signup_i.setTextColor(resources.getColor(R.color.colorAccent))
            }
        }

        signup_j.setOnClickListener {
            if(!signup_j.isSelected){
                signup_j.isSelected = true
                signup_j.setTextColor(resources.getColor(android.R.color.white))
            }else{
                signup_j.isSelected = false
                signup_j.setTextColor(resources.getColor(R.color.colorAccent))
            }
        }
*/
    }

}