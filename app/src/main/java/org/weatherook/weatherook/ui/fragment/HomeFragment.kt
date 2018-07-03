package org.weatherook.weatherook.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home_recommend.*
import org.weatherook.weatherook.R
import org.weatherook.weatherook.ui.adapter.RecommendAdapter
import org.weatherook.weatherook.ui.adapter.WeatherAdapter
import org.weatherook.weatherook.ui.item.RecommendItem
import org.weatherook.weatherook.ui.item.WeatherItem

class HomeFragment : Fragment() {
    lateinit var weatherItems : ArrayList<WeatherItem>
    lateinit var weatherAdapter : WeatherAdapter
    lateinit var recommendItems : ArrayList<RecommendItem>
    lateinit var recommendAdapter : RecommendAdapter

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = View.inflate(activity, R.layout.fragment_home, null)
        return view
    }

    override fun onStart() {
        super.onStart()

        weatherItems = ArrayList()

        weatherItems.add(WeatherItem("지금",R.drawable.abc_ab_share_pack_mtrl_alpha,"25º"))
        weatherItems.add(WeatherItem("지금",R.drawable.abc_ab_share_pack_mtrl_alpha,"25º"))
        weatherItems.add(WeatherItem("지금",R.drawable.abc_ab_share_pack_mtrl_alpha,"25º"))
        weatherItems.add(WeatherItem("지금",R.drawable.abc_ab_share_pack_mtrl_alpha,"25º"))
        weatherItems.add(WeatherItem("지금",R.drawable.abc_ab_share_pack_mtrl_alpha,"25º"))
        weatherItems.add(WeatherItem("지금",R.drawable.abc_btn_borderless_material,"25º"))
        weatherItems.add(WeatherItem("지금",R.drawable.abc_ab_share_pack_mtrl_alpha,"25º"))
        weatherItems.add(WeatherItem("지금",R.drawable.abc_ab_share_pack_mtrl_alpha,"25º"))
        weatherItems.add(WeatherItem("지금",R.drawable.abc_ab_share_pack_mtrl_alpha,"25º"))
        weatherItems.add(WeatherItem("지금",R.drawable.abc_ab_share_pack_mtrl_alpha,"25º"))
        weatherItems.add(WeatherItem("지금",R.drawable.abc_ab_share_pack_mtrl_alpha,"25º"))
        weatherItems.add(WeatherItem("지금",R.drawable.abc_ab_share_pack_mtrl_alpha,"25º"))

        weatherAdapter = WeatherAdapter(weatherItems)
        home_weather_recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        home_weather_recycler.adapter = weatherAdapter

        recommendItems = ArrayList()

        recommendItems.add(RecommendItem(R.drawable.heartcolor))
        recommendItems.add(RecommendItem(R.drawable.heartcolor))
        recommendItems.add(RecommendItem(R.drawable.heartcolor))
        recommendItems.add(RecommendItem(R.drawable.heartcolor))
        recommendItems.add(RecommendItem(R.drawable.heartcolor))
        recommendItems.add(RecommendItem(R.drawable.heartcolor))

        recommendAdapter = RecommendAdapter(recommendItems)
        home_recommend_recycler.layoutManager = GridLayoutManager(context,2)
        home_recommend_recycler.adapter = recommendAdapter
    }
}
