package org.weatherook.weatherook.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import com.bumptech.glide.Glide
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_comment.*
import kotlinx.android.synthetic.main.activity_write.*
import org.weatherook.weatherook.R
import org.weatherook.weatherook.api.network.NetworkService

class WriteActivity : AppCompatActivity(),View.OnClickListener {
    var token : String? = null
    var boardIdx : Int = 0

    override fun onClick(v: View?) {
        when (v) {
        /* write_public ->{
                write_public.isSelected = true
            }*/
        }
    }
    val networkService by lazy {
        NetworkService.create()
    }
    var disposable: Disposable? = null

    var style: ArrayList<TextView> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)


        style.add(write_style1)
        style.add(write_style2)
        style.add(write_style3)
        style.add(write_style4)
        style.add(write_style5)
        style.add(write_style6)

        write_style1.setOnClickListener {
            if (!write_style1.isSelected) {
                write_style1.isSelected = true
                write_style1.setTextColor(resources.getColor(android.R.color.white))
            } else {
                write_style1.isSelected = false
                write_style1.setTextColor(resources.getColor(R.color.colorAccent))
            }
        }


        for (st in style) {
            st.setOnClickListener {
                if (!st.isSelected) {
                    st.isSelected = true
                    st.setTextColor(resources.getColor(android.R.color.white))
                } else {
                    st.isSelected = false
                    st.setTextColor(resources.getColor(R.color.gray))
                }
            }
        }

        val call = networkService.getOneBoardComment(intent.getStringExtra("token")!!,boardIdx)
        disposable = call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                        { GetCommentModel ->
                            Log.i("사진이들어오꺼야", GetCommentModel.data.size.toString())
                            Glide.with(this).load(GetCommentModel.userImg).into(reply_write_profile)
                        }, {/* fail -> Log.i("urls_failed", fail.message) */})

    }

    override fun onStart() {
        super.onStart()
        write_public.setOnClickListener {
            if (!write_public.isSelected) {
                write_public.isSelected = true
            } else {
                write_public.isSelected = false
            }
        }
    }
}
