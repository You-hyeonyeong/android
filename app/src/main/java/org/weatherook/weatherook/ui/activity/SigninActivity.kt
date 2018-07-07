package org.weatherook.weatherook.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_signin.*
import org.weatherook.weatherook.R
import org.weatherook.weatherook.SignupActivity

class SigninActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v){

            signin_btn -> {
                val intent1 = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent1)
            }
            signup_btn -> {
                val intent2 = Intent(applicationContext, SignupActivity::class.java)
                startActivity(intent2)
            }

            skip_btn -> {
                val intent3 = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent3)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        signup_btn.setOnClickListener(this)
        signin_btn.setOnClickListener(this)
        skip_btn.setOnClickListener(this)
    }
}