package org.weatherook.weatherook.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*
import org.weatherook.weatherook.R
import org.weatherook.weatherook.adapter.FollowingAdapter
import org.weatherook.weatherook.adapter.RecommendAdapter
import org.weatherook.weatherook.adapter.WeatherAdapter
import org.weatherook.weatherook.item.FollowingItem
import org.weatherook.weatherook.item.RecommendItem
import org.weatherook.weatherook.item.WeatherItem

class HomeFragment : Fragment(), View.OnClickListener {

    private var isWeatherButtons: Boolean = false
    override fun onClick(v: View?) {

        if (!isWeatherButtons) {
            isWeatherButtons = true
            home_weather_alarm.visibility = View.INVISIBLE
            home_weather_recycler.visibility = View.VISIBLE

        } else {
            isWeatherButtons = false
            home_weather_alarm.visibility = View.VISIBLE
            home_weather_recycler.visibility = View.INVISIBLE
        }
    }

    lateinit var weatherItems : ArrayList<WeatherItem>
    lateinit var weatherAdapter : WeatherAdapter
    lateinit var recommendItems : ArrayList<RecommendItem>
    lateinit var recommendAdapter : RecommendAdapter
    lateinit var followingItems: ArrayList<FollowingItem>
    lateinit var followingAdapter: FollowingAdapter
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = View.inflate(activity, R.layout.fragment_home, null)
        return view
    }

    override fun onStart() {
        super.onStart()

        home_weather_change.setOnClickListener(this)

        weatherItems = ArrayList()

        weatherItems.add(WeatherItem("지금", R.drawable.main_sun2, "25º"))
        weatherItems.add(WeatherItem("1시", R.drawable.main_sun2, "25º"))
        weatherItems.add(WeatherItem("2시", R.drawable.main_rain_2, "25º"))
        weatherItems.add(WeatherItem("3시", R.drawable.main_rain_2, "25º"))
        weatherItems.add(WeatherItem("4시", R.drawable.main_sun2, "25º"))
        weatherItems.add(WeatherItem("5시", R.drawable.main_cloud_sun_2, "25º"))
        weatherItems.add(WeatherItem("6시", R.drawable.main_sun2, "25º"))
        weatherItems.add(WeatherItem("1시", R.drawable.main_sun2, "25º"))
        weatherItems.add(WeatherItem("2시", R.drawable.main_rain_2, "25º"))
        weatherItems.add(WeatherItem("3시", R.drawable.main_rain_2, "25º"))
        weatherItems.add(WeatherItem("4시", R.drawable.main_sun2, "25º"))
        weatherItems.add(WeatherItem("지금", R.drawable.main_cloud_sun_2, "25º"))
        weatherAdapter = WeatherAdapter(weatherItems)
        weatherAdapter.setOnItemClickListener(this)
        home_weather_recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        home_weather_recycler.adapter = weatherAdapter

        recommendItems = ArrayList()

        recommendItems.add(RecommendItem(R.drawable.heartcolor))
        recommendItems.add(RecommendItem(R.drawable.heartcolor))
        recommendItems.add(RecommendItem(R.drawable.heartcolor))
        recommendItems.add(RecommendItem(R.drawable.heartcolor))

        recommendAdapter = RecommendAdapter(recommendItems, context!!)
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


    }
}
