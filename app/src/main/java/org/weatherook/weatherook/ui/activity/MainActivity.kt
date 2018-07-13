package org.weatherook.weatherook.ui.activity

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import org.weatherook.weatherook.R
import org.weatherook.weatherook.singleton.tokenDriver
import org.weatherook.weatherook.ui.fragment.HomeFragment
import org.weatherook.weatherook.ui.fragment.bell.BellFragment
import org.weatherook.weatherook.ui.fragment.camera.CamHomeFragment
import org.weatherook.weatherook.ui.fragment.filter.FilterFragment
import org.weatherook.weatherook.ui.fragment.my.MyFragment
import org.weatherook.weatherook.utils.BottomNavigationViewHelper




class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val view = window.decorView
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (view != null) {
                // 23 버전 이상일 때 상태바 하얀 색상에 회색 아이콘 색상을 설정
                view.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                window.statusBarColor = Color.parseColor("#f2f2f2")
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            // 21 버전 이상일 때
            window.statusBarColor = Color.BLACK
        }

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

   /*override fun sendData(gender: String, tall: Int, size: String, stylelist: ArrayList<String>) {
        //val tag = "android:switcher:" + R.id.signup_viewPager + ":" + 2
        val f = supportFragmentManager.findFragmentByTag("filtercomplete") as FilterCompleteFragment
        f.displayReceivedData(gender, tall, size, stylelist)
    }*/



}
