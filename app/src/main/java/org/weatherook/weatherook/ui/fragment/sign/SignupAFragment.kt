package org.weatherook.weatherook.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import kotlinx.android.synthetic.main.fragment_signup_a.*
import org.weatherook.weatherook.R
import org.weatherook.weatherook.singleton.SignupDriver.signupDriver

class SignupAFragment : Fragment() {

    //lateinit var list: ArrayList<EditText>
    val canSubmit = arrayOf(false, false)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_signup_a, container, false)
        return v
    }

    override fun onStart() {
        super.onStart()

        val signupId: EditText = view!!.findViewById(R.id.signup_id_tv)
        val signupPw: EditText = view!!.findViewById(R.id.signup_pw_tv)
        val signupIdCheck: EditText = view!!.findViewById(R.id.signup_check_tv)


        val signupIdObservable = RxTextView.textChanges(signup_id_tv)
        val signupPwObservable = RxTextView.textChanges(signup_pw_tv)
        val signupChkObservable = RxTextView.textChanges(signup_check_tv)


        signupIdObservable.subscribe {
            val temp = it.toString()
            Log.d("rxtest", temp)
            if (temp.length == 0) {
                canSubmit[0] = false
                signupDriver.onNext(false)
            } else {
                canSubmit[0] = true
                if (canSubmit[0] && canSubmit[1]) {
                    Log.d("tag", "===================합격===================")
                    signupDriver.onNext(true)
                }
            }

            val temp2: Observable<Boolean> = Observable.combineLatest(
                    signupPwObservable,
                    signupChkObservable,
                    BiFunction { t1, t2 ->
                        if (t1.toString().length < 6) {
                            false
                        } else {
                            t1.toString().equals(t2.toString())
                        }
                    }
            )

            temp2.subscribe {
                Log.d("rxtest", "비밀번호 : $it")
                canSubmit[1] = it
                if (!canSubmit[1]){
                    if((signup_pw_tv.text.length != 0 && signup_check_tv.text.length != 0) &&
                            (signup_pw_tv.text.length  >= 6 || signup_check_tv.text.length >=6 ))
                        signup_check_msg.text = "비밀번호가 일치하지 않습니다."
                    else
                        signup_check_msg.text = ""
                }
                else signup_check_msg.text = " "
                if (canSubmit[0] && canSubmit[1]) {
                    signupDriver.onNext(true)
                } else {
                    signupDriver.onNext(false)
                }
            }

        }
    }
}