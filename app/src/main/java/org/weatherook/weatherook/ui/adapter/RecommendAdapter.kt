package org.weatherook.weatherook.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.weatherook.weatherook.R
import org.weatherook.weatherook.ui.item.RecommendItem
import org.weatherook.weatherook.ui.viewholder.RecommendViewHolder

class RecommendAdapter(var recommendItems : ArrayList<RecommendItem>) : RecyclerView.Adapter<RecommendViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_recommend,parent,false)

        return RecommendViewHolder(mainView)
    }

    override fun getItemCount(): Int = recommendItems.size

    override fun onBindViewHolder(holder: RecommendViewHolder, position: Int) {
        holder.recommendCody.setImageResource(recommendItems[position].cody)
    }
}