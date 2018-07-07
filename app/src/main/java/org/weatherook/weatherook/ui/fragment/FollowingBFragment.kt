package org.weatherook.weatherook.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_following_a.*
import org.weatherook.weatherook.R
import org.weatherook.weatherook.adapter.FollowingAdapter
import org.weatherook.weatherook.item.FollowingItem

class FollowingBFragment : Fragment() {


    lateinit var followingItems : ArrayList<FollowingItem>
    lateinit var followingAdapter : FollowingAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_following_a, container, false)
        return v
    }

    override fun onStart() {
        super.onStart()

        followingItems = ArrayList()

        followingItems.add(FollowingItem(R.drawable.heartcolor, "kim", R.drawable.main_sun))
        followingItems.add(FollowingItem(R.drawable.heartcolor, "kim", R.drawable.main_cloud_sun_2))
        followingItems.add(FollowingItem(R.drawable.heartcolor, "kim", R.drawable.main_sun))
        followingItems.add(FollowingItem(R.drawable.heartcolor, "kim", R.drawable.main_rain))

        followingAdapter = FollowingAdapter(followingItems)
        //      followingAdapter.setOnItemClickListener(this)
        home_following_recycler.layoutManager = LinearLayoutManager(context)
        home_following_recycler.adapter = followingAdapter



    }

}