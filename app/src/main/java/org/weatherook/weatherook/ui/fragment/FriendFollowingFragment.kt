package org.weatherook.weatherook.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_friend_follower.*
import org.weatherook.weatherook.R
import org.weatherook.weatherook.adapter.FriendAdapter
import org.weatherook.weatherook.api.network.NetworkService
import org.weatherook.weatherook.item.FriendItem

/**
 * Created by HYEON on 2018-07-08.
 */
class FriendFollowingFragment : Fragment() {

    lateinit var friendItems : ArrayList<FriendItem>
    lateinit var friendAdapter : FriendAdapter

    var token: String? = null

    val networkService by lazy {
        NetworkService.create()
    }
    var disposable: Disposable? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val v = inflater.inflate(R.layout.fragment_friend_following, container,false)
        return  v
    }

    override fun onStart() {
        super.onStart()

        friendItems = ArrayList()
        if (token != null) {
            val call = networkService.getMyFollowerProfile(token!!)
            disposable = call.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()).subscribe(
                            { success ->
                                for(i in 0..success.data.showFollowerIDResult.size-1)
                                friendItems.add(FriendItem(success.data.showFollowerIDResult[i].userImg.toString(),success.data.showFollowerIDResult[i].userId))
                            }, { fail -> Log.i("urls_failed", fail.message) })
        }


        friendAdapter = FriendAdapter(friendItems, context!!)
        friend_follower_recycle.layoutManager = GridLayoutManager(context,4)
        friend_follower_recycle.adapter = friendAdapter
    }

}