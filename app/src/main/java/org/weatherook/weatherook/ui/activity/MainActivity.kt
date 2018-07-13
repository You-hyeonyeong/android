package org.weatherook.weatherook.ui.activity

import android.os.Build
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.weatherook.weatherook.R
import org.weatherook.weatherook.ui.fragment.HomeFragment
import org.weatherook.weatherook.ui.fragment.bell.BellFragment
import org.weatherook.weatherook.ui.fragment.camera.CamHomeFragment
import org.weatherook.weatherook.ui.fragment.filter.FilterFragment
import org.weatherook.weatherook.ui.fragment.my.MyFragment
import org.weatherook.weatherook.singleton.tokenDriver
import org.weatherook.weatherook.ui.fragment.*
import java.text.SimpleDateFormat
import java.util.*



class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var fragmentManager: FragmentManager

    lateinit var homeFragment : Fragment
    val searchFragment = FilterFragment()
    lateinit var cameraFragment: Fragment

   lateinit var likedFragment : Fragment
   lateinit var myFragment :Fragment
   lateinit var fragmentTransaction: FragmentTransaction

    override fun onClick(v: View?) {

        when (v) { // 자바에서 switch와 같음
            main_btn_home -> {
                clearSelected()
                main_btn_home.isSelected = true
                replaceFragment(HomeFragment())
            }
            main_btn_search -> {
                clearSelected()
                main_btn_search.isSelected = true
                replaceFragment(FilterFragment())
            }
            main_btn_add -> {
                clearSelected()
                main_btn_add.isSelected = true
                if (Build.VERSION.SDK_INT >= 21) {
                    replaceFragment(CamHomeFragment())
                } else {
                    replaceFragment(FilterFragment())
                }

            }
            main_btn_news -> {
                clearSelected()
                main_btn_news.isSelected = true
                replaceFragment( BellFragment())
            }
            main_btn_mine -> {
                clearSelected()
                main_btn_mine.isSelected = true
                replaceFragment(MyFragment())
            }

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("date", SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.KOREA).format(Calendar.getInstance().time))

        val fragmentManager : FragmentManager = supportFragmentManager
        addFragment(HomeFragment())
        main_btn_home.isSelected = true
      //  addFragment(HomeFragment())
        /*
        val fragmentManager: FragmentManager = supportFragmentManager

        val homeFragment = HomeFragment()
        val searchFragment = FilterFragment()
        lateinit var cameraFragment: Fragment
        if (Build.VERSION.SDK_INT >= 21) {
            cameraFragment = CamHomeFragment()
        } else {
            cameraFragment = FilterFragment()
        }
        val likedFragment = BellFragment()
        val myFragment = MyFragment()
        fragmentManager.beginTransaction().replace(R.id.main_container, homeFragment).commit()
*/
        if (intent.getStringExtra("token") != null) {
            tokenDriver.tokenDriver.onNext(intent.getStringExtra("token"))
        }

        main_btn_home.setOnClickListener(this)
        main_btn_mine.setOnClickListener(this)
        main_btn_add.setOnClickListener(this)
        main_btn_search.setOnClickListener(this)
        main_btn_news.setOnClickListener(this)
    }

    fun clearSelected() {
        main_btn_home.isSelected = false
        main_btn_add.isSelected = false
        main_btn_mine.isSelected = false
        main_btn_search.isSelected = false
        main_btn_news.isSelected = false

    }

    fun addFragment(fragment : Fragment) : Unit{
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.main_container, fragment)
        transaction.commit()
    } // 변수명부터 넣고 타입 넣음 , unit 은 리턴 타입 없다는 뜻. 따라서 생략해도 됨.

    fun replaceFragment(fragment: Fragment) : Unit{
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.main_container, fragment)
        transaction.commit()
        // transaction.addToBackStack(null)
    }
/*
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
    */
}


