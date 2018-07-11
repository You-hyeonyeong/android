package org.weatherook.weatherook.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.weatherook.weatherook.R
import org.weatherook.weatherook.api.glide.GlideApp
import org.weatherook.weatherook.item.MyListRecyclerviewData
import org.weatherook.weatherook.viewholder.MyListRecyclerviewViewHolder

/**
 * Created by HYEON on 2018-07-03.
 */

class MyListRecyclerviewAdapter(private var mylistrecyclerviewItems: ArrayList<MyListRecyclerviewData>, val context: Context) : RecyclerView.Adapter<MyListRecyclerviewViewHolder>() {


    private lateinit var onItemClick: View.OnClickListener

    fun setOnItemClickListener(l: View.OnClickListener) {
        onItemClick = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyListRecyclerviewViewHolder {

        val mainView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_following, parent, false)
        mainView.setOnClickListener(onItemClick)
        return MyListRecyclerviewViewHolder(mainView)
    }

    override fun getItemCount(): Int = mylistrecyclerviewItems.size

    override fun onBindViewHolder(holder: MyListRecyclerviewViewHolder, position: Int) {
        /*holder!!.apply {
            mylistrecyclerviewItems[position].let {
                MyStoryData.text = it.mystorydate


                GlideApp.with(context).load(it.mystoryprofile).into(MyStoryProfile)
            }

            val a : String? = null
            a.let {
                // null 이아닐때
            } ?: let {
                // null 일때
            }
        }*/
        // holder!!.MyImage.setImageResource(myrecyclerviewItems[position].myimage)  Glide가 더 성능이 좋음
        holder.apply {
            mylistrecyclerviewItems[position].let {
                MyStoryName.text=it.user_id
                MyStoryTemp.text=it.board_temp_min.toString()+"/"+it.board_temp_max.toString()
                MyStoryContent.text = it.board_desc
            }
        }
        GlideApp.with(context).load(mylistrecyclerviewItems[position].user_img).into(holder!!.MyStoryProfile)
        GlideApp.with(context).load(mylistrecyclerviewItems[position].board_img).into(holder!!.MyStoryImg)

    }
}