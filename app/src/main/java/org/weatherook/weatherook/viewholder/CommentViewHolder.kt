package org.weatherook.weatherook.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import org.weatherook.weatherook.R

class CommentViewHolder (itemView: View?): RecyclerView.ViewHolder(itemView){
    var commentId : TextView = itemView!!.findViewById(R.id.comment_id) as TextView
    var commentComment : TextView = itemView!!.findViewById(R.id.comment_comment) as TextView
}