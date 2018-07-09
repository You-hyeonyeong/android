package org.weatherook.weatherook.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.weatherook.weatherook.R

/**
 * Created by HYEON on 2018-07-05.
 */
class BellRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    var bellProfile: ImageView = itemView.findViewById(R.id.bell_profile_img) as ImageView
    var bellName: TextView = itemView.findViewById(R.id.bell_profile_name) as TextView
    var bellRingTxt: TextView = itemView.findViewById(R.id.bell_ring_txt) as TextView
    var bellReply: TextView = itemView.findViewById(R.id.bell_reply_txt) as TextView
    var bellTime: TextView = itemView.findViewById(R.id.bell_time) as TextView
    var bellBoardImg: ImageView = itemView.findViewById(R.id.bell_board_img) as ImageView

}