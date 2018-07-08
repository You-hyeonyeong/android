package org.weatherook.weatherook.ui.activity

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_popup.*
import org.weatherook.weatherook.R

class PopupActivity : Activity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v){
            popup_signup_btn ->{
                val intent = Intent(this, SignupActivity::class.java)
                startActivity(intent)
                finish()
            }
            else -> {
                finish()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup)

        popup_signup_btn.setOnClickListener(this)
        popup_all.setOnClickListener(this)
    }
}
