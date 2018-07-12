package org.weatherook.weatherook.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.weatherook.weatherook.R
import org.weatherook.weatherook.adapter.recyclerview.FollowingAdapter
import org.weatherook.weatherook.item.FollowingItem

class StoryActivity : AppCompatActivity() {

    lateinit var storyitem : ArrayList<FollowingItem>
    lateinit var storyadapter : FollowingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)

        storyitem = ArrayList()
        storyitem.clear()

        //정빈이꺼 복 붙

    }
}
