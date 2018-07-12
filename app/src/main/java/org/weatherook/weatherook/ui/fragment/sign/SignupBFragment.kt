package org.weatherook.weatherook

import android.app.Activity
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
import org.weatherook.weatherook.ui.fragment.SignupAFragment

class SignupBFragment: Fragment(), View.OnClickListener {

    override fun onClick(v: View?) {
       when(v){
           signup_women -> {
               signup_women.isSelected = true
               signup_man.isSelected = false
               if(signup_women.isSelected){
                   b_gender="여"
               }else{
                   b_gender="남"
               }
           }

           signup_man -> {
               signup_women.isSelected = false
               signup_man.isSelected = true
               if(signup_women.isSelected){
                   b_gender="여"
               }else{
                   b_gender="남"
               }
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
                b_height = Integer.parseInt(it.toString())
                if (canSubmit[0] && canSubmit[1]) {
                    Log.d("tag", "===================합격===================")
                    signupDriver.onNext(true)
                    SM!!.sendData1(b_id!!,b_pw!!,b_gender,b_height!!,b_weight!!)
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
                b_weight = Integer.parseInt(it.toString())
                //Log.d("b_weight", it.toString().toInt().toString())
                if (canSubmit[0] && canSubmit[1]) {
                    Log.d("tag", "===================합격===================")
                    signupDriver.onNext(true)
                    SM!!.sendData1(b_id!!,b_pw!!,b_gender,b_height!!,b_weight!!)
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
    var b_id : String?= null
    var b_pw : String?= null
    var b_gender : String="여"
    var b_height : Int?=null
    var b_weight : Int?=null

    fun displayReceivedData(id : String,pw:String){
        b_id = id
        b_pw = pw
        Log.i("b_id",b_id)
        Log.i("b_pw",b_pw)
    }

    var SM: SendMessage1?=null

    interface SendMessage1 {
        fun sendData1(id : String,pw:String, gender : String, height : Int, weight : Int)
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        try {
            SM = activity as SendMessage1
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}