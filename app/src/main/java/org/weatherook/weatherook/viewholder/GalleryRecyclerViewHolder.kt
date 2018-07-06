package org.weatherook.weatherook.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import org.weatherook.weatherook.R

class GalleryRecyclerViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var GalleryImgview : ImageView = itemView!!.findViewById(R.id.gallery_item_img)
}