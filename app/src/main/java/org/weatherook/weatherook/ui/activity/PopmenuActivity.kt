package org.weatherook.weatherook.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_popmenu.*
import org.weatherook.weatherook.R

class PopmenuActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v) {
            popmenu_copy -> {
                Toast.makeText(applicationContext,"링크가 복사되었습니다 ", Toast.LENGTH_SHORT).show()


            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popmenu)
    }
}
