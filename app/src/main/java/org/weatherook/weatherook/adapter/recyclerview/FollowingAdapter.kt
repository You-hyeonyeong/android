package org.weatherook.weatherook.adapter.recyclerview

import android.content.Context
import android.content.Intent
import android.support.design.widget.BottomSheetDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import kotlinx.android.synthetic.main.item_following.view.*
import org.weatherook.weatherook.R
import org.weatherook.weatherook.api.glide.GlideApp
import org.weatherook.weatherook.item.BoardCommentItem
import org.weatherook.weatherook.item.CommentItem
import org.weatherook.weatherook.item.CommentTotalItem
import org.weatherook.weatherook.item.FollowingItem
import org.weatherook.weatherook.viewholder.FollowingViewHolder
import org.weatherook.weatherook.ui.activity.CommentActivity
import org.weatherook.weatherook.utils.KeyboardVisibility


class FollowingAdapter(var followingItems : ArrayList<FollowingItem>, var commentLayoutManager: LinearLayoutManager, val context : Context) : RecyclerView.Adapter<FollowingViewHolder>() {

    private lateinit var onItemClick: View.OnClickListener

    lateinit var commentItems: ArrayList<CommentItem>
    lateinit var commentAdapter: CommentAdapter
    fun setOnItemClickListener(l: View.OnClickListener) {
        onItemClick = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_following,parent,false)
//        mainView.setOnClickListener(onItemClick)

        mainView.following_popup.setOnClickListener {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.bottom_sheet, null)
            val dialog = BottomSheetDialog(context!!)
            dialog.setContentView(view)
            dialog.show()
        }
        mainView.following_commentwrite_btn.setOnClickListener{
            mainView.following_comment_visible.visibility = View.VISIBLE
            mainView.following_comment_write.requestFocus()
            KeyboardVisibility.showKeyboard(context)

        }

        mainView.following_commentshow_btn.setOnClickListener {
            val intent1 = Intent(context, CommentActivity::class.java)
            mainView.context.startActivity(intent1)
        }
        return FollowingViewHolder(mainView)
    }

    override fun getItemCount(): Int = followingItems.size

    override fun onBindViewHolder(holder: FollowingViewHolder, position: Int) {
        GlideApp.with(context).load(followingItems[position].profile).into(holder!!.followingProfile)
        holder.followingId.text = followingItems[position].id
        //GlideApp.with(context).load(followingItems[position].heart).into(holder!!.followingHeart)
        holder.followingCount.text = followingItems[position].count.toString()
        GlideApp.with(context).load(followingItems[position].photo).into(holder!!.followingPhoto)
        holder.followingDate.text = followingItems[position].date
        Log.i("followingAdapter", followingItems[position].date)
        when(followingItems[position].weather){
            0-> holder.followingWeather.text="맑음"
            1-> holder.followingWeather.text="구름 조금"
            2-> holder.followingWeather.text="구름 많음"
            3-> holder.followingWeather.text="흐름"
            4-> holder.followingWeather.text="비"
            5-> holder.followingWeather.text="비/눈"
            6-> holder.followingWeather.text="눈"
        }
        //holder.followingWeather.text = followingItems[position].weather.toSt
        // ring()
        holder.followingTemp.text = followingItems[position].temperature
        holder.followingContent.text = followingItems[position].content
        holder.followingComment.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        holder.followingComment.adapter = CommentAdapter(followingItems[position].comment)
        holder.followingCommentBtn.text = "댓글 "+followingItems[position].comment.size +"개 모두 보기"
        holder.followingCommentBtn.setOnClickListener {
            val intent = Intent(context, CommentActivity::class.java)
            intent.putExtra("boardIdx",followingItems[position].boardIdx)
            /*var array = ArrayList<String>()
            for(i in 0..followingItems[position].comment.size-1){
                array.add(Gson().toJson(followingItems[i].comment,CommentTotalItem::class.java))
            }
            intent.putExtra("comment", toJsonString(followingItems[position].comment))*/
            context.startActivity(intent) }


    }

    fun toJsonString(list: List<BoardCommentItem>): String {
        return Gson().toJsonTree(list).asJsonArray.toString()
    }

}