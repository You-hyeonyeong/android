package org.weatherook.weatherook.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.fragment_signup_b.*
import org.weatherook.weatherook.R
import org.weatherook.weatherook.SignupBFragment
import org.weatherook.weatherook.SignupCFragment
import org.weatherook.weatherook.adapter.viewpager.SignupPagerAdapter
import org.weatherook.weatherook.singleton.SignupDriver.signupDriver
import org.weatherook.weatherook.ui.fragment.SignupAFragment
import org.weatherook.weatherook.utils.KeyboardVisibility

class SignupActivity : AppCompatActivity(), View.OnClickListener, SignupAFragment.SendMessage, SignupBFragment.SendMessage1 {


    var next :Boolean = false

    override fun onClick(v: View?) {
        when (v) {
            signup_close -> {
                finish()
            }

            signup_next_btn -> {
                if(next){
                        if (signup_viewPager.currentItem == 0) {

                            signup_viewPager.currentItem = signup_viewPager.currentItem + 1
                            activeBack()
                            if(checkBOk()) activeNext()
                            else inactiveNext()

                        } else if (signup_viewPager.currentItem == 1) {
                            signup_viewPager.currentItem = signup_viewPager.currentItem + 1
                            signup_next_btn.setText("가입 완료")
                            activeBack()
                            inactiveNext()

                        } else {
                            val tag = "android:switcher:" + R.id.signup_viewPager + ":" + 2
                            val f = supportFragmentManager.findFragmentByTag(tag) as SignupCFragment
                            f.signup()
                            finish()
                        }

                    }
                }


            signup_back -> {

                if(signup_viewPager.currentItem == 1) {

                    inactiveBack()
                }
                signup_viewPager.currentItem = signup_viewPager.currentItem - 1
                signup_next_btn.setText("다음")
                activeNext()



            }
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        signup_close.setOnClickListener(this)
        signup_next_btn.setOnClickListener(this)
        signup_back.setOnClickListener(this)

        val viewPager = findViewById<ViewPager>(R.id.signup_viewPager)
        val adapter = SignupPagerAdapter(supportFragmentManager)

        viewPager.adapter = adapter

        signupDriver
                .filter { it }
                .subscribe{ Log.d("rxtest","===============it's true==============");

                   activeNext()
                }
        signupDriver
                .filter { !it }
                .subscribe { Log.d("text", "로그인안돼는상태임");
                    inactiveNext()
                }


    }

    fun activeNext(){
        next = true
        signup_next_btn.setBackgroundColor(resources.getColor(R.color.colorAccent))
    }

    fun inactiveNext(){
        next = false
        signup_next_btn.setBackgroundColor(Color.parseColor("#aaaaaa"))
    }

    fun activeBack(){
        signup_back.visibility = View.VISIBLE
    }

    fun inactiveBack(){
        signup_back.visibility = View.INVISIBLE
    }

    fun checkInputOk(nameInput: String): Boolean {
        var chrInput: Char

        for (i in 0 until nameInput.length) {
            chrInput = nameInput[i]
            if (chrInput.toInt() >= 0x21 && chrInput.toInt() <= 0x7E) {

            } else {
                return false
            }
        }
        return true
    }

    fun checkBOk() : Boolean{
        val height = signup_height_tv.text.toString()
        val weight = signup_weight_tv.text.toString()
        if(height.length > 0 && weight.length > 0){
            if(checkInputOk(height) && checkInputOk(weight)) return true
            else return false
        }
        else return false
    }

    override fun sendData(id: String, pw: String) {
        val tag = "android:switcher:" + R.id.signup_viewPager + ":" + 1
        val f = supportFragmentManager.findFragmentByTag(tag) as SignupBFragment
        f.displayReceivedData(id, pw)
    }

    override fun sendData1(id: String, pw: String, gender: String, height: Int, weight: Int) {
        val tag = "android:switcher:" + R.id.signup_viewPager + ":" + 2
        val f = supportFragmentManager.findFragmentByTag(tag) as SignupCFragment
        f.displayReceivedData1(id, pw, gender, height, weight)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        KeyboardVisibility.hideKeyboard(this)
    }
}
