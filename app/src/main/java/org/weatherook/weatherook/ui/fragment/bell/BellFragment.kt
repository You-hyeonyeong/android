package org.weatherook.weatherook.ui.fragment.bell

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.weatherook.weatherook.R
import org.weatherook.weatherook.adapter.recyclerview.BellRecyclerviewAdapter
import org.weatherook.weatherook.api.network.NetworkService
import org.weatherook.weatherook.item.BellRecyclerViewData
import org.weatherook.weatherook.singleton.tokenDriver

class BellFragment : Fragment(), View.OnClickListener {
    var token: String? = null


    val networkService by lazy {
        NetworkService.create()
    }
    var disposable: Disposable? = null

    lateinit var likeitems: ArrayList<BellRecyclerViewData>
    lateinit var bellRecyclerviewAdapter: BellRecyclerviewAdapter


    override fun onClick(p0: View?) {
       /* val idx : Int = like_recycle.getChildAdapterPosition(p0)
        val image : String = likeitems[idx].bellprofile
        val id : String = likeitems[idx].bellname
        val heartcount : Int = likeitems[idx]....
        val photo : String = likeitems[idx].bellboardimg
*/
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = View.inflate(activity, R.layout.fragment_bell, null)
        val like_recycle: RecyclerView = view!!.findViewById(R.id.like_recycle)
        likeitems = ArrayList()

        tokenDriver.tokenDriver.subscribe {
            token = it
            Log.i("list", token)
        }

        bellRecyclerviewAdapter = BellRecyclerviewAdapter(likeitems, context!!)
        bellRecyclerviewAdapter.setOnItemClickListener(this)
        like_recycle.adapter = bellRecyclerviewAdapter
        like_recycle.layoutManager = LinearLayoutManager(activity)

        if (token != null) {
            val call = networkService.getBell(token!!)
            disposable = call.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()).subscribe(
                            { bellModel ->
                                Log.i("urls_success1", bellModel.data.toString())
                                for (i in 0..bellModel.data.size - 1) {
                                    if (bellModel.data[i].flag == 0) {
                                        likeitems.add(BellRecyclerViewData(bellModel.data[i].commentImg,
                                                bellModel.data[i].commentId, bellModel.data[i].commentStr,
                                                bellModel.data[i].commentDesc, bellModel.data[i].date, bellModel.data[i].boardImg))
                                        bellRecyclerviewAdapter.notifyDataSetChanged()
                                    }
                                    if (bellModel.data[i].flag == 1) {
                                        likeitems.add(BellRecyclerViewData(bellModel.data[i].followImg,
                                                bellModel.data[i].follow, bellModel.data[i].followStr,
                                                "팔로우 하시겠습니까?", bellModel.data[i].date, "R.drawable.follow_state"))
                                        bellRecyclerviewAdapter.notifyDataSetChanged()
                                        Log.i("urls_success3",bellModel.data.toString())
                                    } else


                                    Log.i("urls_success2", bellModel.data[i].boardImg)
                                }

                                //Log.i("urls_success3", mylistitems[i].)
                                Log.i("urls_success4", "" + likeitems.size)
                                //  myListRecyclerviewAdapter.notifyDataSetChanged()

                            }, { fail -> Log.i("urls_failed", fail.message) })
        }


        //  likeitems.add(BellRecyclerViewData(R.drawable.main_night_2, "유클라", "님이 댓글을 남겼습니다.", "오늘 너무 더워요오", "14", R.drawable.brown))
        //  likeitems.add(BellRecyclerViewData(R.drawable.main_snow_2, "프린스정", "님이 댓글을 남겼습니다.", "오늘 너무 더워요오", "15", R.drawable.brown))
        // likeitems.add(BellRecyclerViewData(R.drawable.main_cloud_sun_2, "유클라", "님이 댓글을 남겼습니다.", "오늘 너무 더워요오", "220", R.drawable.brown))


        return view
    }

    override fun onStart() {
        super.onStart()


    }
}