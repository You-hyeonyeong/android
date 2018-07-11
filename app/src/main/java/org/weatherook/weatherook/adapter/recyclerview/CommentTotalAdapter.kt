package org.weatherook.weatherook.adapter.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.weatherook.weatherook.R
import org.weatherook.weatherook.api.glide.GlideApp
import org.weatherook.weatherook.item.CommentTotalItem
import org.weatherook.weatherook.viewholder.CommentTotalViewHolder

class CommentTotalAdapter(var commenttotalItems : ArrayList<CommentTotalItem>, val context: Context) : RecyclerView.Adapter<CommentTotalViewHolder>() {

    private lateinit var onItemClick: View.OnClickListener

    fun setOnItemClickListener(l: View.OnClickListener) {
        onItemClick = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentTotalViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_comment_total,parent,false)

        return CommentTotalViewHolder(mainView)
    }

    override fun getItemCount(): Int = commenttotalItems.size

    override fun onBindViewHolder(holder: CommentTotalViewHolder, position: Int) {
        commenttotalItems[position].let {
            GlideApp.with(context).load(it.profile).into(holder.commenttotalProfile)
            holder.commenttotalId.text = it.id
            holder.commenttotalComment.text = it.comment
            holder.commenttotalTime.text = it.date
        }
        /*holder.commenttotalProfile
        holder.commenttotalId.text = commenttotalItems[position].id
        holder.commenttotalTime.text = commenttotalItems[position].time
        holder.commenttotalComment.text = commenttotalItems[position].comment*/

    }
}