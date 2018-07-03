package org.weatherook.weatherook.ui.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.weatherook.weatherook.R

class WeatherViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView){
    var weatherTime : TextView = itemView!!.findViewById(R.id.weather_item_time) as TextView
    var weatherWeather : ImageView = itemView!!.findViewById(R.id.weather_item_weather) as ImageView
    var weatherTemp : TextView = itemView!!.findViewById(R.id.weather_item_temp) as TextView
}