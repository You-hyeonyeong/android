package org.weatherook.weatherook.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import org.weatherook.weatherook.R
import org.weatherook.weatherook.adapter.SignupPagerAdapter

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val dotsIndicator = findViewById<WormDotsIndicator>(R.id.worm_dots_indicator)
        val viewPager = findViewById<ViewPager>(R.id.signup_viewPager)
        val adapter = SignupPagerAdapter(supportFragmentManager)

        viewPager.adapter = adapter
        dotsIndicator.setViewPager(viewPager)
    }
}
