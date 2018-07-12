package org.weatherook.weatherook.ui.fragment.my

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_my.*
import org.weatherook.weatherook.R
import org.weatherook.weatherook.api.glide.GlideApp
import org.weatherook.weatherook.api.network.NetworkService
import org.weatherook.weatherook.singleton.tokenDriver
import org.weatherook.weatherook.ui.activity.MySettingActivity
import org.weatherook.weatherook.ui.activity.SettingsActivity
import org.weatherook.weatherook.ui.fragment.MyGridFragment
import org.weatherook.weatherook.ui.fragment.MyListFragment


class MyFragment : Fragment(), View.OnClickListener {

    var token: String? = null

    val networkService by lazy {
        NetworkService.create()
    }
    var disposable: Disposable? = null

    override fun onClick(p0: View?) {

        when (p0) {
            my_grid_img -> {
                my_grid_img.isSelected = true
                my_list_img.isSelected = false
                val fragmentTransaction = fragmentManager!!.beginTransaction()
                fragmentTransaction.replace(R.id.mypage_recycle, MyGridFragment()).commit()
            }

            my_list_img -> {
                my_list_img.isSelected = true
                my_grid_img.isSelected = false
                val fragmentTransaction = fragmentManager!!.beginTransaction()
                fragmentTransaction.replace(R.id.mypage_recycle, MyListFragment()).commit()
            }
            my_setting_btn -> {
                var intent = Intent(activity, SettingsActivity::class.java)
                startActivity(intent)
            }
            my_profile_edit_btn -> {
                my_profile_edit_btn.isSelected = false
                var intent = Intent(activity, MySettingActivity::class.java)
                startActivity(intent)
            }
            my_follow -> {
                val fragmentTransaction = fragmentManager!!.beginTransaction()
                fragmentTransaction.add(R.id.my_frame, FriendFragment()).commit()
            }


        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = View.inflate(activity, R.layout.fragment_my, null)

        tokenDriver.tokenDriver.subscribe {
            token = it
            Log.i("myfrag", token)
        }

        return view
    }

    override fun onStart() {
        super.onStart()

        if (token != null) {
            val call = networkService.getMyBoard(token!!,null)
            disposable = call.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()).subscribe(
                            { success ->
                                Log.i("urls_success1", success.showBoardNumResult.toString())
                                GlideApp.with(this).load(success.showUserPageResult[0].userImg).into(setting_profile_img)
                                setting_id_tv.text = success.showUserPageResult[0].userId
                                setting_self_tv.text = success.showUserPageResult[0].userDesc.toString()
                                my_board_num.text = success.showBoardNumResult[0].boardNum.toString()
                                my_follower_num.text = success.showFollowerNumResult[0].follower.toString().toFloat().toInt().toString()/*.toInt().toString()*/
                                Log.i("FollowerNumResult",success.showFollowerNumResult[0].follower.toString())
                                my_following_num.text = success.showFollowingNumResult[0].following.toString()
                            }, { /*fail -> Log.i("urls_failed", fail.message)*/ })
        }

        val fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction.replace(R.id.mypage_recycle, MyGridFragment()).commit()
        my_grid_img.isSelected = true
        my_grid_img.setOnClickListener(this)
        my_list_img.setOnClickListener(this)
        my_setting_btn.setOnClickListener(this)
        my_profile_edit_btn.setOnClickListener(this)
        my_follow.setOnClickListener(this)


    }
}