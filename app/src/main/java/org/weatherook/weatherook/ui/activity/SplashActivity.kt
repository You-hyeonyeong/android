package org.weatherook.weatherook.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.bumptech.glide.Glide
import org.weatherook.weatherook.R
import org.weatherook.weatherook.SigninActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val source = findViewById<ImageView>(R.id.splash_gif)
        Glide.with(this)
                .load(R.drawable.splash_img)
                .into(source)

        val handler = Handler()
        handler.postDelayed({
            startActivity(Intent(applicationContext, SigninActivity::class.java))
            finish()
        }, 2000)
    }
}