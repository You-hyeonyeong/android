package org.weatherook.weatherook.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.weatherook.weatherook.R

/**
 * Created by HYEON on 2018-07-05.
 */
class LikeRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    var MyProfile: ImageView = itemView.findViewById(R.id.like_profile_img) as ImageView
    var MyName: TextView = itemView.findViewById(R.id.like_profile_name) as TextView
    var RingTxt: TextView = itemView.findViewById(R.id.like_ring_txt) as TextView
    var BoardImg: ImageView = itemView.findViewById(R.id.like_board_img) as ImageView

}