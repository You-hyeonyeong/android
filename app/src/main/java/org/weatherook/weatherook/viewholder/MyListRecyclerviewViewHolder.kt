package org.weatherook.weatherook.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.weatherook.weatherook.R

/**
 * Created by HYEON on 2018-07-03.
 */
class MyListRecyclerviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var MyStoryProfile: ImageView = itemView.findViewById(R.id.story_profile_img) as ImageView
    var MyStoryName: TextView = itemView.findViewById(R.id.story_id) as TextView
    var MyStoryImg: ImageView = itemView.findViewById(R.id.story_pic) as ImageView
    var MyStoryData: TextView = itemView.findViewById(R.id.story_date) as TextView
    var MyStoryWeather: TextView = itemView.findViewById(R.id.story_weather) as TextView
    var MyStoryTxt: TextView = itemView.findViewById(R.id.story_txt) as TextView
    var MyStoryTemp: TextView = itemView.findViewById(R.id.story_temp) as TextView
    var MyStoryHash: TextView = itemView.findViewById(R.id.story_hash) as TextView
}