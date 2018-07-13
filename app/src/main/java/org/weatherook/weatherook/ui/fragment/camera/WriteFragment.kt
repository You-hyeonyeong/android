package org.weatherook.weatherook.ui.fragment.camera

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.location.Geocoder
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_write.*
import kotlinx.android.synthetic.main.fragment_write.view.*
import org.weatherook.weatherook.R
import org.weatherook.weatherook.api.network.NetworkService
import org.weatherook.weatherook.item.WeatherDriverItem
import org.weatherook.weatherook.singleton.LatLongDriver
import org.weatherook.weatherook.singleton.WeatherDriver
import org.weatherook.weatherook.singleton.tokenDriver
import org.weatherook.weatherook.singleton.urlDriver
import org.weatherook.weatherook.ui.activity.WriteActivity
import java.text.SimpleDateFormat
import java.util.*

class WriteFragment : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v) {
            write_editText ->{
                var intent = Intent(activity, WriteActivity::class.java)
                intent.putExtra("date", write_date_cal.text.toString())
                intent.putExtra("location", write_date_txt.text.toString())
                intent.putExtra("temp", write_temp_txt.text.toString())
                intent.putExtra("weather", write_weather_txt.text.toString())
                intent.putExtra("url", url)
                startActivity(intent)
            }
        }
    }
    val networkService by lazy {
        NetworkService.create()
    }
    var disposable: Disposable? = null

    var token : String ?= null

    var style: ArrayList<TextView> = ArrayList()
    lateinit var datePickerDialog: DatePickerDialog
    val day_millis  = 86400000
    var x =0.toDouble()
    var y =0.toDouble()
    var url:String?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = View.inflate(activity, R.layout.fragment_write, null)

   //     style.add(view.write_style1)
   //     style.add(view.write_style2)
    //    style.add(view.write_style3)
    //    style.add(view.write_style4)
    //    style.add(view.write_style5)
    //    style.add(view.write_style6)

        val today : Date = Calendar.getInstance().time
        val dateformat = SimpleDateFormat("d-M-yyyy")
        val temp = dateformat.format(today)
        val date = temp.split("-")

        Log.i("today", dateformat.format(today))
        val write_date_cal : TextView = view.findViewById(R.id.write_date_cal)
        write_date_cal.text=date[1]+"월 "+date[0]+"일"
        datePickerDialog = DatePickerDialog(context, R.style.DialogTheme, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth -> write_date_cal.text=(month+1).toString()+"월 "+dayOfMonth.toString()+"일" }, date.get(2).toInt(),date.get(1).toInt()-1, date.get(0).toInt())
        datePickerDialog.datePicker.minDate = System.currentTimeMillis() - day_millis*2
        datePickerDialog.datePicker.maxDate = System.currentTimeMillis()

        view.write_date_cal.setOnClickListener { datePickerDialog.show() }
        WeatherDriver.weatherDriver.subscribe{
            x= it.x
            y = it.y
            val call2 = networkService.postWeather(x, y, 2)
            disposable = call2.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()).subscribe(
                            { WeatherModel ->
                                val temp : TextView = view.findViewById(R.id.write_temp_txt)
                                temp.setText(WeatherModel.data.tempAm.toString()+"/"+WeatherModel.data.tempAf.toString())
                                val weather : TextView = view.findViewById(R.id.write_weather_txt)
                                when(WeatherModel.data.currentWeather){
                                    0->weather.setText("맑음")
                                    1->weather.setText("흐림")
                                    2->weather.setText("구름 조금")
                                    3->weather.setText("구름 많음")
                                    4->weather.setText("비")
                                    5->weather.setText("비/눈")
                                    6->weather.setText("눈")
                                }

                            }, { fail -> Log.i("WeatherFragment", fail.message) })
        }
        WeatherDriver.weatherDriver.subscribe {
            try {
                if(it!=null){
                    view.write_date_txt.text = getAddress(context!!,it)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        urlDriver.urlDriver.subscribe {
            try {
                if(it!=null){
                    url = it
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        /*view.write_style1.setOnClickListener { if(!view.write_style1.isSelected){
            view.write_style1.isSelected = true
            view.write_style1.setTextColor(resources.getColor(android.R.color.white))
        }else{
            view.write_style1.isSelected = false
            view.write_style1.setTextColor(resources.getColor(R.color.colorAccent))
        } }*/
//

        for (st in style) {
            st.setOnClickListener {
                if (!st.isSelected) {
                    st.isSelected = true
                    st.setTextColor(resources.getColor(android.R.color.white))
                } else {
                    st.isSelected = false
                    st.setTextColor(resources.getColor(R.color.colorAccent))
                }
            }
        }

        return view
    }

    override fun onStart() {
        super.onStart()

        write_editText.setOnClickListener(this)

    }

    fun getAddress(context: Context, item : WeatherDriverItem): String {
        var nowAddress = "현재 위치를 확인할 수 없습니다."
        val geocoder = Geocoder(context, Locale.KOREA)
        var address = geocoder.getFromLocation(item.x, item.y, 1)
        try {
            if (address != null && address.size > 0) {
                val currentLocationAddress = address.get(0).subLocality
                nowAddress = currentLocationAddress
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return nowAddress
    }
}