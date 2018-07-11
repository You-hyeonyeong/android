package org.weatherook.weatherook.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import org.weatherook.weatherook.R

/**
 * Created by HYEON on 2018-07-03.
 */
class MyRecyclerviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var MyImage : ImageView =  itemView.findViewById(R.id.my_image) as ImageView
}