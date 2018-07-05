package org.weatherook.weatherook.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.weatherook.weatherook.R
import org.weatherook.weatherook.ui.item.FollowingItem
import org.weatherook.weatherook.ui.viewholder.FollowingViewHolder

class FollowingAdapter(var followingItems : ArrayList<FollowingItem>) : RecyclerView.Adapter<FollowingViewHolder>() {

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
        holder.followingProfile.setImageResource(followingItems[position].profile)
        holder.followingId.text = followingItems[position].id
        holder.followingPhoto.setImageResource(followingItems[position].photo)

    }
}