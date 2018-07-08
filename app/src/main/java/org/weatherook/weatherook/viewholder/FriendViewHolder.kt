package org.weatherook.weatherook.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.weatherook.weatherook.R

/**
 * Created by HYEON on 2018-07-08.
 */
class FriendViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var friendProfile : ImageView = itemView!!.findViewById(R.id.friend_profile) as ImageView
    var friendId : TextView = itemView!!.findViewById(R.id.friend_id) as TextView
}