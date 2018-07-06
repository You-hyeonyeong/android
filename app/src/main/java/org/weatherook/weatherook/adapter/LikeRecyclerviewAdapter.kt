package org.weatherook.weatherook.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.weatherook.weatherook.R
import org.weatherook.weatherook.api.glide.GlideApp
import org.weatherook.weatherook.item.LikeRecyclerViewData
import org.weatherook.weatherook.viewholder.LikeRecyclerViewHolder

/**
 * Created by HYEON on 2018-07-05.
 */
class LikeRecyclerviewAdapter(private var likerecyclerviewItems : ArrayList<LikeRecyclerViewData>, val context : Context) : RecyclerView.Adapter<LikeRecyclerViewHolder>() {
    lateinit var onItemClick : View.OnClickListener

    fun setOnItemClickListener(I:View.OnClickListener) {
        onItemClick = I
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LikeRecyclerViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.like_item, parent, false)
        mainView.setOnClickListener(onItemClick)
        return LikeRecyclerViewHolder(mainView)
    }

    override fun getItemCount(): Int = likerecyclerviewItems.size

    override fun onBindViewHolder(holder: LikeRecyclerViewHolder, position: Int) {
        GlideApp.with(context).load(likerecyclerviewItems[position].myprofile).into(holder!!.MyProfile)
        holder!!.MyName.text = likerecyclerviewItems[position].myname
        holder!!.RingTxt.text = likerecyclerviewItems[position].ringtxt
        GlideApp.with(context).load(likerecyclerviewItems[position].boardimg).into(holder!!.BoardImg)
    }
}