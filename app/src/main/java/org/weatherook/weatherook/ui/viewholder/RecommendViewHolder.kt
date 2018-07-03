package org.weatherook.weatherook.ui.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.item_recommend.view.*
import org.weatherook.weatherook.R

class RecommendViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    var recommendCody : ImageView = itemView!!.findViewById(R.id.recomment_item_cody) as ImageView
}