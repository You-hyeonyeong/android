package org.weatherook.weatherook.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_signin.*
import org.weatherook.weatherook.R
import org.weatherook.weatherook.api.model.SigninModel
import org.weatherook.weatherook.api.network.NetworkService
import kotlin.jvm.java

class SigninActivity : AppCompatActivity(), View.OnClickListener {

    val networkService by lazy {
        NetworkService.create()
    }
    var disposable: Disposable? = null

    override fun onClick(v: View?) {
        when(v){

            signin_btn -> {
                /*val intent1 = Intent(applicationContext, PopupActivity::class.java)
                startActivity(intent1)*/
                signin()
            }
            signup_btn -> {
                val intent2 = Intent(applicationContext, SignupActivity::class.java)
                startActivity(intent2)
            }

            skip_btn -> {
                val intent3 = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent3)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        signup_btn.setOnClickListener(this)
        signin_btn.setOnClickListener(this)
        skip_btn.setOnClickListener(this)
    }

    fun signin() {
        val id = signin_id_tv.text.toString()
        val pw = signin_pw_tv.text.toString()
        val signinModel = SigninModel(id,pw)

        val call = networkService.postSignin(signinModel)
        disposable = call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({result->
                    val intent3 = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent3)
                },{error-> val intent1 = Intent(applicationContext, PopupActivity::class.java)
                    startActivity(intent1)})
    }
}