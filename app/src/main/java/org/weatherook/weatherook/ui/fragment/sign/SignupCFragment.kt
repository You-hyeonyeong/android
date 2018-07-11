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
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_signup_c.*
import org.w3c.dom.Text
import org.weatherook.weatherook.api.model.SignupModel
import org.weatherook.weatherook.api.network.NetworkService
import org.weatherook.weatherook.singleton.SignupDriver.signupDriver
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

    val canSubmit = arrayOf(false, false)
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

        val signupAgeObservable = RxTextView.textChanges(signup_age)
        val signupAObservable = RxTextView.textChanges(signup_a)
        val signupBObservable = RxTextView.textChanges(signup_b)
        val signupCObservable = RxTextView.textChanges(signup_c)
        val signupDObservable = RxTextView.textChanges(signup_d)
        val signupEObservable = RxTextView.textChanges(signup_e)
        val signupFObservable = RxTextView.textChanges(signup_f)
        val signupGObservable = RxTextView.textChanges(signup_g)
        val signupHObservable = RxTextView.textChanges(signup_h)
        val signupIObservable = RxTextView.textChanges(signup_i)
        val signupJObservable = RxTextView.textChanges(signup_j)

        signupAgeObservable.subscribe {
            val temp = it.toString()
            Log.d("rxtest", temp)
            if (temp.length == 0  || !checkInputOk(temp)) {
                canSubmit[0] = false
                signupDriver.onNext(false)
            } else {
                canSubmit[0] = true
                if (canSubmit[0]) {// && canSubmit[1]
                    Log.d("tag", "===================합격===================")
                    signupDriver.onNext(true)
                }
            }
        }
        /*
        val style: Observable<Boolean> = Observable.combineLatest(
                signupAObservable,
                signupBObservable,
                signupCObservable,
                signupDObservable,
                signupEObservable,
                signupFObservable,
                signupGObservable,
                signupHObservable,
                signupIObservable,
                signupJObservable,

                Func10 { t1, t2, t3, t4, t5, t6, t7, t8, t9, t10 ->
                    if (t1.toString().length < 6) {
                        false
                    } else {
                        t1.toString().equals(t2.toString())
                    }
                }
        )
        */
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

    fun signup() {
        //val id = signin_id_tv.text.toString()
        //val pw = signin_pw_tv.text.toString()
//        val styleList = ArrayList<String>()
//        styleList.add("댄디")
//        styleList.add("빈티지")

        val styleList = ArrayList<String>()
        styleList.add(signup_a.text.toString())
        styleList.add("댄디")

        val signupModel = SignupModel("cp_park4","we0001", "여",22,162,50, styleList)
        Log.d("temp", Gson().toJson(signupModel))
        val call = networkService.postSignup(signupModel)
        disposable = call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({ success->
                    Log.d("temp",success.toString())
                    startActivity(Intent(context, SigninActivity::class.java))
                },{fail-> Log.d("temp",fail.toString())
                    Toast.makeText(context,"로그인에 실패했습니다.", Toast.LENGTH_SHORT).show()})
    }

    interface Func10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> : io.reactivex.functions.Function<TextView,R> {
        fun call(t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10): R
    }

}