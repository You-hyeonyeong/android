package org.weatherook.weatherook.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_signin.*
import org.weatherook.weatherook.R
import org.weatherook.weatherook.api.network.NetworkService

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

        val call = networkService.postSignin(id,pw)
        disposable = call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({success->
                    var intent = Intent(applicationContext, MainActivity::class.java)
                    intent.putExtra("token", success.token)
                    startActivity(intent)
                    finish()
                },{fail-> Toast.makeText(applicationContext,"비밀번호와 아이디가 일치하지 않습니다.",Toast.LENGTH_LONG).show()
                        /*val intent1 = Intent(applicationContext, PopupActivity::class.java)
                    startActivity(intent1)*/})
    }
}