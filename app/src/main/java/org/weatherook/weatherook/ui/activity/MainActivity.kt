package org.weatherook.weatherook.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.weatherook.weatherook.R
import android.support.annotation.NonNull
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentManager
import android.view.MenuItem
import android.view.View
import org.weatherook.weatherook.api.camera.Camera2BasicFragment
import org.weatherook.weatherook.ui.fragment.*
import org.weatherook.weatherook.utils.BottomNavigationViewHelper


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager : FragmentManager = supportFragmentManager

        val homeFragment = HomeFragment()
        val searchFragment = SearchFragment()
        val cameraFragment = CamHomeFragment()
        val likedFragment = LikedFragment()
        val myFragment = MyFragment()

        val bottomNavigationView = findViewById<View>(R.id.bottom_navigation) as BottomNavigationView
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                var fragmentTransaction = fragmentManager.beginTransaction()

                when (item.getItemId()) {
                    R.id.action_home ->
                        //741dff
                        fragmentTransaction.replace(R.id.main_container, homeFragment).commit()
                        // do something here
                    R.id.action_search ->
                        fragmentTransaction.replace(R.id.main_container, searchFragment).commit()
                        // do something here
                    R.id.action_camera ->
                        fragmentTransaction.replace(R.id.main_container, cameraFragment).commit()
                        // do something here
                    R.id.action_liked ->
                        fragmentTransaction.replace(R.id.main_container, likedFragment).commit()
                // do something here
                    R.id.action_my ->
                        fragmentTransaction.replace(R.id.main_container, myFragment).commit()
                // do something here
                }
                return true
            }
        })
    }
}
