package org.weatherook.weatherook.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.weatherook.weatherook.R
import org.weatherook.weatherook.api.glide.GlideApp


class GalleryRecyclerviewAdapter(private var galleryItem: ArrayList<String>, var context : Context) : RecyclerView.Adapter<GalleryRecyclerViewHolder>() {


    private lateinit var v : View.OnClickListener

    val imageWidthPixels = 320
    val imageHeightPixels = 240

    fun setOnItemClickListener(l:View.OnClickListener){
        v = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryRecyclerViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.gallery_item,parent,false)
        mainView.setOnClickListener(v)
        return GalleryRecyclerViewHolder(mainView)
    }

    override fun getItemCount(): Int =galleryItem.size

    override fun onBindViewHolder(holder: GalleryRecyclerViewHolder, position: Int) {
        //holder.GalleryItem =
        val imgview = holder.GalleryImgview
        val currentUrl = galleryItem.get(position)

        GlideApp.with(context).load(currentUrl).override(imageWidthPixels, imageHeightPixels)
                .into(imgview)
    }
}