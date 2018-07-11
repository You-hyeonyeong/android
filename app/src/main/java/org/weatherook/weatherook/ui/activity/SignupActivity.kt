package org.weatherook.weatherook.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_signup.*
import org.weatherook.weatherook.R
import org.weatherook.weatherook.adapter.viewpager.SignupPagerAdapter
import org.weatherook.weatherook.singleton.SignupDriver.signupDriver

class SignupActivity : AppCompatActivity(), View.OnClickListener {


    var next :Boolean = false
    override fun onClick(v: View?) {
        when (v) {
            signup_close -> {
                finish()
            }

            signup_next_btn -> {
                if(next){ signup_viewPager.currentItem = signup_viewPager.currentItem + 1
                    inactiveBotton()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        signup_close.setOnClickListener(this)
        signup_next_btn.setOnClickListener(this)

        val viewPager = findViewById<ViewPager>(R.id.signup_viewPager)
        val adapter = SignupPagerAdapter(supportFragmentManager)

        viewPager.adapter = adapter

        signupDriver
                .filter { it }
                .subscribe{ Log.d("rxtest","===============it's true==============");
                   activeBotton()
                }
        signupDriver
                .filter { !it }
                .subscribe { Log.d("text", "로그인안돼는상태임");
                    inactiveBotton()
                }


    }

    fun activeBotton(){
        next = true
        signup_next_btn.setBackgroundColor(resources.getColor(R.color.colorAccent))
    }

    fun inactiveBotton(){
        next = false
        signup_next_btn.setBackgroundColor(Color.parseColor("#aaaaaa"))
    }

}
