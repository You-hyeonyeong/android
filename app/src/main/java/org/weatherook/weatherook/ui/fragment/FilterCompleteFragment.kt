package org.weatherook.weatherook.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_filter_complete.*
import org.weatherook.weatherook.R
import org.weatherook.weatherook.adapter.FollowingAdapter
import org.weatherook.weatherook.item.FollowingItem

/**
 * Created by HYEON on 2018-07-09.
 */
class FilterCompleteFragment : Fragment(),View.OnClickListener {
    override fun onClick(p0: View?) {

        when(p0){
            refilter_txt-> {
                fragmentManager!!.beginTransaction().remove(this).commit()
                fragmentManager!!.popBackStack()
            }
        }
    }
    lateinit var filtercomitems : ArrayList<FollowingItem>
    lateinit var filtercomadapter : FollowingAdapter

    override fun onCreateView(inflater: LayoutInflater, conatiner: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = View.inflate(activity, R.layout.fragment_filter_complete, null)

        return view
    }

    override fun onStart() {
        super.onStart()
        filtercomitems = ArrayList()
        filtercomitems.add(FollowingItem(R.drawable.brown, "hiriyo", R.drawable.heart,"100",R.drawable.main_night_2,"7월 25일","맑음","25/31","정빈이는 체고다 정비니 짱짱"))
        filtercomitems.add(FollowingItem(R.drawable.cony, "프린스 빈", R.drawable.heart,"100",R.drawable.main_rain_2,"7월 26일","흐림","24/31","정빈이는 체고다 정비니 짱짱"))
        filtercomitems.add(FollowingItem(R.drawable.selly, "정시후", R.drawable.heart,"112",R.drawable.main_snow_2,"7월 27일","맑음","25/31","정빈이는 체고다 정비니 짱짱"))
        filtercomitems.add(FollowingItem(R.drawable.moon, "hiriyo", R.drawable.heart,"112",R.drawable.main_cloud_sun_2,"7월 2일","맑음","27/31","정빈이는 체고다 정비니 짱짱"))

        filtercomadapter = FollowingAdapter(filtercomitems,context!!)
        //      followingAdapter.setOnItemClickListener(this)
        filter_com_recycle.layoutManager = LinearLayoutManager(context)
        filter_com_recycle.adapter = filtercomadapter

        refilter_txt.setOnClickListener(this)


    }


}