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

    var MyStoryProfile: ImageView = itemView.findViewById(R.id.following_profile) as ImageView
    var MyStoryName: TextView = itemView.findViewById(R.id.following_id) as TextView
    var MyStoryImg: ImageView = itemView.findViewById(R.id.following_photo) as ImageView
    var MyStoryDate: TextView = itemView.findViewById(R.id.following_date) as TextView
    var MyStoryWeather: TextView = itemView.findViewById(R.id.following_weather) as TextView
    var MyStoryContent: TextView = itemView.findViewById(R.id.following_content) as TextView
    var MyStoryTemp: TextView = itemView.findViewById(R.id.following_temp) as TextView
}