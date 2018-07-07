package org.weatherook.weatherook.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.weatherook.weatherook.R
import org.weatherook.weatherook.api.glide.GlideApp
import org.weatherook.weatherook.item.FollowingItem
import org.weatherook.weatherook.viewholder.FollowingViewHolder

class FollowingAdapter(var followingItems : ArrayList<FollowingItem>, val context: Context) : RecyclerView.Adapter<FollowingViewHolder>() {

    private lateinit var onItemClick: View.OnClickListener

    fun setOnItemClickListener(l: View.OnClickListener) {
        onItemClick = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_following,parent,false)
//        mainView.setOnClickListener(onItemClick)
        return FollowingViewHolder(mainView)
    }

    override fun getItemCount(): Int = followingItems.size

    override fun onBindViewHolder(holder: FollowingViewHolder, position: Int) {

        GlideApp.with(context).load(followingItems[position].profile).into(holder!!.followingProfile)
        holder!!.followingId.text = followingItems[position].id
        GlideApp.with(context).load(followingItems[position].heart).into(holder!!.followingHeart)
        holder!!.followingCount.text = followingItems[position].count
        GlideApp.with(context).load(followingItems[position].photo).into(holder!!.followingPhoto)
        holder!!.followingDate.text = followingItems[position].date
        holder!!.followingWeather.text = followingItems[position].weather
        holder!!.followingTemp.text = followingItems[position].temperature
        holder!!.followingContent.text = followingItems[position].content

    }
}