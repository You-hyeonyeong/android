package org.weatherook.weatherook.ui.fragment.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.BounceInterpolator
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_weather_today.*
import kotlinx.android.synthetic.main.fragment_weather_today.view.*
import org.weatherook.weatherook.R
import org.weatherook.weatherook.adapter.recyclerview.WeatherAdapter
import org.weatherook.weatherook.api.network.NetworkService
import org.weatherook.weatherook.item.WeatherItem
import org.weatherook.weatherook.singleton.LatLongDriver
import org.weatherook.weatherook.singleton.weatherDriver
import java.text.SimpleDateFormat
import java.util.*


class TodayFragment : Fragment(), View.OnClickListener {

    var state = true
    var mtime = arrayOf(weather_item_time1,weather_item_time2,weather_item_time3,weather_item_time4,weather_item_time5, weather_item_time6)
    var mweather = arrayOf(weather_item_weather1,weather_item_weather2,weather_item_weather3,weather_item_weather4,weather_item_weather5,weather_item_weather6)
    var mtemp = arrayOf(weather_item_temp1,weather_item_temp2,weather_item_temp3,weather_item_temp4,weather_item_temp5,weather_item_temp6)
    val networkService by lazy {
        NetworkService.create()
    }
    var disposable: Disposable? = null

    var weatherStr = arrayOf("맑음", "구름", "구름", "흐림", "비", "비", "눈")
    var weatherIcon = arrayOf(R.drawable.main_sun, R.drawable.main_cloud_sun_2, R.drawable.main_cloud_sun_2, R.drawable.main_cloud_2, R.drawable.main_cloud_2, R.drawable.main_rainy_big, R.drawable.main_snow_2)
    var weatherimg = arrayOf(R.drawable.main_sun2, R.drawable.main_cloud_sun, R.drawable.main_cloud_sun, R.drawable.main_cloud, R.drawable.main_rainy, R.drawable.main_rainy, R.drawable.main_snow)
    private var isWeatherButtons: Boolean = false
    override fun onClick(v: View) {
        if (!isWeatherButtons) {
            isWeatherButtons = true

            home_weather_alarm.visibility = View.INVISIBLE
           // home_weather_recycler.visibility = View.VISIBLE
            home_weather_grid.visibility = View.VISIBLE
        } else {
            isWeatherButtons = false
            home_weather_alarm.visibility = View.VISIBLE
           // home_weather_recycler.visibility = View.INVISIBLE
            home_weather_grid.visibility = View.INVISIBLE
        }

    }

    lateinit var weatherItems: ArrayList<WeatherItem>
    lateinit var weatherAdapter: WeatherAdapter
    private var x: Double = 0.0
    private var y: Double = 0.0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = View.inflate(activity!!, R.layout.fragment_weather_today, null)
        view.home_weather_location
        weatherDriver.weatherDriver.subscribe {
            if (it != null) {
                view.home_weather_location.text = it
            }
        }
        val image: ImageView = view.findViewById(R.id.frag_today_weatherimg)
        image.setOnClickListener {
            var anim = TranslateAnimation(TranslateAnimation.ABSOLUTE, 0f, TranslateAnimation.ABSOLUTE, 0f,
                    TranslateAnimation.RELATIVE_TO_PARENT, -0.05f, TranslateAnimation.RELATIVE_TO_PARENT, 0.05f)
            anim.duration = 1000
            anim.repeatCount = -1
            anim.repeatMode = Animation.REVERSE
            anim.interpolator = BounceInterpolator()
            anim.fillAfter = true
            image.startAnimation(anim)
        }

        val call = networkService.postTempWeather(23, 0)
        disposable = call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                        { WeatherCommentModel ->
                            home_weather_alarm.text = WeatherCommentModel.data.weatherTextTemp + "\n" + WeatherCommentModel.data.weatherTextWeather
                        }, { fail -> Log.i("TodayFragment", fail.message) })


        LatLongDriver.LatLongDriver.subscribe {

            x= it.x
            y = it.y

            Log.d("tag", "========================" + x + "======================" + y)
         //   Log.d("tag", "=========================time================" + mtime[1].text)
            val call1 = networkService.postTimeWeather(x, y)
            disposable = call1.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()).subscribe(
                            { WeatherTimeModel ->
                                for (i in 0..WeatherTimeModel.data.size - 1) {
                                    mtime[i].setText(WeatherTimeModel.data[i].hour)
                                    mweather[i].setImageResource(weatherimg[WeatherTimeModel.data[i].weather])
                                    mtemp[i].setText(WeatherTimeModel.data[i].temp.toString()+"º")
                                }
                            }, {/* fail -> Log.i("WeatherFragment", fail.message)*/ })
            /*
            weatherItems = ArrayList()

            weatherAdapter = WeatherAdapter(weatherItems)
            weatherAdapter.setOnItemClickListener(this)
            val weatherRecycler: RecyclerView = view.findViewById(R.id.home_weather_recycler)

            weatherRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            weatherRecycler.adapter = weatherAdapter

            val call1 = networkService.postTimeWeather(x, y)
            disposable = call1.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()).subscribe(
                            { WeatherTimeModel ->
                                for (i in 0..WeatherTimeModel.data.size - 1) {
                                    weatherItems.add(WeatherItem(WeatherTimeModel.data[i].hour + "시", weatherimg[WeatherTimeModel.data[i].weather], WeatherTimeModel.data[i].temp.toString() + "º"))
                                    weatherAdapter.notifyDataSetChanged()
                                }
                            }, { fail -> Log.i("WeatherFragment", fail.message) })

*/
            val call2 = networkService.postWeather(x, y, 2)
            disposable = call2.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()).subscribe(
                            { WeatherModel ->
                                home_weather_temp.setText(WeatherModel.data.currentTemp.toString())
                                home_weather_weather.setText(weatherStr[WeatherModel.data.currentWeather])
                                frag_today_weatherimg.setImageResource(weatherIcon[WeatherModel.data.currentWeather])
                                home_weather_prob.setText(WeatherModel.data.currentPop.toString())
                                home_weather_hum.setText(WeatherModel.data.currentReh.toString())
                                home_weather_tempmax.setText(WeatherModel.data.tempAm.toString())
                                home_weather_tempmin.setText(WeatherModel.data.tempAf.toString())

                            }, { /*fail -> Log.i("WeatherFragment", fail.message)*/ })

        }


        return view
    }

  /*  fun time() {
        val now = System.currentTimeMillis()
        val date = Date(now)
        val CurDateFormat = SimpleDateFormat("yyyy년 MM월 dd일")
        val strCurDate = CurDateFormat.format(date)
    }*/

    fun doYearMonthDay(): String {
        val formatter = SimpleDateFormat("MM월 dd일 E요일", Locale.KOREA)
        val date = Date()
        return formatter.format(date)
    }


    override fun onStart() {
        super.onStart()

        home_weather_change.setOnClickListener(this)
        home_weather_grid.setOnClickListener(this)

        home_weather_date.text = doYearMonthDay()

    }
}
