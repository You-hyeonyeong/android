package org.weatherook.weatherook.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.weatherook.weatherook.R

class FollowingViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView){
    var followingProfile : ImageView = itemView!!.findViewById(R.id.following_profile) as ImageView
    var followingId : TextView = itemView!!.findViewById(R.id.following_id) as TextView
    var followingHeart: ImageView = itemView!!.findViewById(R.id.following_heart) as ImageView
    var followingCount: TextView = itemView!!.findViewById(R.id.following_count) as TextView
    var followingPhoto : ImageView = itemView!!.findViewById(R.id.following_photo) as ImageView
    var followingDate: TextView = itemView!!.findViewById(R.id.following_date) as TextView
    var followingWeather: TextView = itemView!!.findViewById(R.id.following_weather) as TextView
    var followingTemp: TextView = itemView!!.findViewById(R.id.following_temp) as TextView
    var followingContent: TextView = itemView!!.findViewById(R.id.following_content) as TextView
    var followingComment : RecyclerView = itemView!!.findViewById(R.id.following_comment_recycler) as RecyclerView
    var followingCommentBtn : TextView = itemView!!.findViewById(R.id.following_commentshow_btn) as TextView
}
