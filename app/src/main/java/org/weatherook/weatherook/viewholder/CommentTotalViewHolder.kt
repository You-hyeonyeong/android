package org.weatherook.weatherook.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.weatherook.weatherook.R

class CommentTotalViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView){
    var commenttotalProfile: ImageView = itemView!!.findViewById(R.id.comment_total_profile) as ImageView
    var commenttotalId : TextView = itemView!!.findViewById(R.id.comment_total_id) as TextView
    var commenttotalTime : TextView = itemView!!.findViewById(R.id.comment_total_time) as TextView
    var commenttotalComment : TextView = itemView!!.findViewById(R.id.comment_total_comment) as TextView
}