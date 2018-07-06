package org.weatherook.weatherook.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*
import org.weatherook.weatherook.R
import org.weatherook.weatherook.adapter.FollowingAdapter
import org.weatherook.weatherook.adapter.HomePagerAdapter
import org.weatherook.weatherook.adapter.RecommendAdapter
import org.weatherook.weatherook.ui.item.FollowingItem
import org.weatherook.weatherook.ui.item.RecommendItem

class HomeFragment : Fragment(), View.OnClickListener {


    override fun onClick(v: View?) {
/*

  */
        }


    lateinit var recommendItems : ArrayList<RecommendItem>
    lateinit var recommendAdapter : RecommendAdapter
    lateinit var followingItems : ArrayList<FollowingItem>
    lateinit var followingAdapter : FollowingAdapter
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = View.inflate(activity, R.layout.fragment_home, null)
        return view
    }

    override fun onStart() {
        super.onStart()



        recommendItems = ArrayList()

        recommendItems.add(RecommendItem(R.drawable.heartcolor))
        recommendItems.add(RecommendItem(R.drawable.heartcolor))
        recommendItems.add(RecommendItem(R.drawable.heartcolor))
        recommendItems.add(RecommendItem(R.drawable.heartcolor))

        recommendAdapter = RecommendAdapter(recommendItems,context!!)
   //     recommendAdapter.setOnItemClickListener(this)
        home_recommend_recycler.layoutManager = GridLayoutManager(context,2)
        home_recommend_recycler.adapter = recommendAdapter


        followingItems = ArrayList()

        followingItems.add(FollowingItem(R.drawable.heartcolor, "kim", R.drawable.main_sun))
        followingItems.add(FollowingItem(R.drawable.heartcolor, "kim", R.drawable.main_cloud_sun_2))
        followingItems.add(FollowingItem(R.drawable.heartcolor, "kim", R.drawable.main_sun))
        followingItems.add(FollowingItem(R.drawable.heartcolor, "kim", R.drawable.main_rain))

        followingAdapter = FollowingAdapter(followingItems)
  //      followingAdapter.setOnItemClickListener(this)
        home_following_recycler.layoutManager = LinearLayoutManager(context)
        home_following_recycler.adapter = followingAdapter


        val viewPager = view!!.findViewById<ViewPager>(R.id.weather_viewPager)
        val adapter = HomePagerAdapter(childFragmentManager)

        viewPager.adapter = adapter
        viewPager.currentItem = 1
    }
}
