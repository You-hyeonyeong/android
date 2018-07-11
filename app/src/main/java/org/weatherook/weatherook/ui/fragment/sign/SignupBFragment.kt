package org.weatherook.weatherook

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import kotlinx.android.synthetic.main.fragment_signup_b.*
import org.weatherook.weatherook.singleton.SignupDriver.signupDriver

class SignupBFragment: Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
       when(v){
           signup_women -> {
               signup_women.isSelected = true
               signup_man.isSelected = false
           }

           signup_man -> {
               signup_women.isSelected = false
               signup_man.isSelected = true
           }
       }

    }


    val canSubmit = arrayOf(false, false)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_signup_b, container, false)

        return v
    }

    override fun onStart() {
        super.onStart()

        signup_women.isSelected = true

        signup_women.setOnClickListener(this)
        signup_man.setOnClickListener(this)

        val signupHeightObservable = RxTextView.textChanges(signup_height_tv)
        val signupWeightObservable = RxTextView.textChanges(signup_weight_tv)

        signupHeightObservable.subscribe {
            val temp = it.toString()
            Log.d("rxtest", temp)
            if (temp.length == 0  || !checkInputOk(temp)) {
                canSubmit[0] = false
                signupDriver.onNext(false)
            } else {
                canSubmit[0] = true
                if (canSubmit[0] && canSubmit[1]) {
                    Log.d("tag", "===================합격===================")
                    signupDriver.onNext(true)
                }
            }
        }

        signupWeightObservable.subscribe {
            val temp = it.toString()
            Log.d("rxtest", temp)
            if (temp.length == 0 || !checkInputOk(temp)) {
                canSubmit[1] = false
                signupDriver.onNext(false)
            } else {
                canSubmit[1] = true
                if (canSubmit[0] && canSubmit[1]) {
                    Log.d("tag", "===================합격===================")
                    signupDriver.onNext(true)
                }
            }
        }

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

}