package org.weatherook.weatherook

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_signup_c.*
import org.weatherook.weatherook.api.model.SignupModel
import org.weatherook.weatherook.api.network.NetworkService
import org.weatherook.weatherook.ui.activity.SigninActivity

class SignupCFragment : Fragment(), View.OnClickListener {

    val networkService by lazy {
        NetworkService.create()
    }
    var disposable: Disposable? = null

    var style: ArrayList<TextView> = ArrayList()
    override fun onClick(v: View?) {
        when (v) {
            signup_join -> {
                //startActivity(Intent(context, SigninActivity::class.java))
                Log.d("temp","시작")
                signup()
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_signup_c, container, false)

        return v
    }

    override fun onStart() {
        super.onStart()

        signup_join.setOnClickListener(this)

        style.add(signup_a)
        style.add(signup_b)
        style.add(signup_c)
        style.add(signup_d)
        style.add(signup_e)
        style.add(signup_f)
        style.add(signup_g)
        style.add(signup_h)
        style.add(signup_i)
        style.add(signup_j)

        for (st in style) {
            st.setOnClickListener {
                if (!st.isSelected) {
                    st.isSelected = true
                    st.setTextColor(resources.getColor(android.R.color.white))
                } else {
                    st.isSelected = false
                    st.setTextColor(Color.parseColor("#aaaaaa"))
                }
            }
        }
    }

    fun signup() {
        //val id = signin_id_tv.text.toString()
        //val pw = signin_pw_tv.text.toString()
//        val styleList = ArrayList<String>()
//        styleList.add("댄디")
//        styleList.add("빈티지")

        val styleList = ArrayList<String>()
        styleList.add(signup_a.text.toString())
        styleList.add("댄디")

        val signupModel = SignupModel("appjamida","we0001", "여",22,162,50, styleList)
        Log.d("temp", Gson().toJson(signupModel))
        val call = networkService.postSignup(signupModel)
        disposable = call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({ success->
                    Log.d("temp",success.toString())
                    startActivity(Intent(context, SigninActivity::class.java))
                },{fail-> Log.d("temp",fail.toString())
                    Toast.makeText(context,"로그인에 실패했습니다.", Toast.LENGTH_SHORT).show()})
    }

}