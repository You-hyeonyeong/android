package org.weatherook.weatherook.ui.activity

import android.os.Build
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import android.view.View
import org.weatherook.weatherook.R
import org.weatherook.weatherook.ui.fragment.HomeFragment
import org.weatherook.weatherook.ui.fragment.bell.BellFragment
import org.weatherook.weatherook.ui.fragment.camera.CamHomeFragment
import org.weatherook.weatherook.ui.fragment.filter.FilterFragment
import org.weatherook.weatherook.ui.fragment.my.MyFragment
import org.weatherook.weatherook.singleton.tokenDriver
import org.weatherook.weatherook.ui.fragment.*
import org.weatherook.weatherook.utils.BottomNavigationViewHelper
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("date", SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.KOREA).format(Calendar.getInstance().time))

        val fragmentManager : FragmentManager = supportFragmentManager

        val homeFragment = HomeFragment()
        val searchFragment = FilterFragment()
        lateinit var cameraFragment : Fragment
        if(Build.VERSION.SDK_INT>=21){
            cameraFragment = CamHomeFragment()
        }else{
            cameraFragment = FilterFragment()
        }
        val likedFragment = BellFragment()
        val myFragment = MyFragment()
        fragmentManager.beginTransaction().replace(R.id.main_container, homeFragment).commit()

        if(intent.getStringExtra("token")!=null){
            tokenDriver.tokenDriver.onNext(intent.getStringExtra("token"))
        }

        val bottomNavigationView = findViewById<View>(R.id.bottom_navigation) as BottomNavigationView
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                var fragmentTransaction = fragmentManager.beginTransaction()

                when (item.getItemId()) {
                    R.id.action_home -> {
                        fragmentTransaction.replace(R.id.main_container, homeFragment).commit()
                    }
                        //741dff
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
