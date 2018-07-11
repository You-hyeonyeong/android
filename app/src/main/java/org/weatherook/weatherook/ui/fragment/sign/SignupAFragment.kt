package org.weatherook.weatherook.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import org.weatherook.weatherook.R

class SignupAFragment : Fragment() {

    //lateinit var list: ArrayList<EditText>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_signup_a, container, false)
        return v
    }

    override fun onStart() {
        super.onStart()
        val signinId : EditText =view!!.findViewById(R.id.signin_id_tv)
        val signinPw : EditText =view!!.findViewById(R.id.signin_pw_tv)
       // val signinIdCheck : EditText =view!!.findViewById(R.id.signin_check_tv)

    }
}