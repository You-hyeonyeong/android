package org.weatherook.weatherook.ui.fragment

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
import org.weatherook.weatherook.adapter.recyclerview.MyListRecyclerviewAdapter
import org.weatherook.weatherook.api.network.NetworkService
import org.weatherook.weatherook.item.MyListRecyclerviewData
import org.weatherook.weatherook.singleton.tokenDriver

/**
 * Created by HYEON on 2018-07-04.
 */

class MyListFragment : Fragment(), View.OnClickListener {

    var token : String ?= null

    override fun onClick(p0: View?) {

    }

    val networkService by lazy {
        NetworkService.create()
    }
    var disposable: Disposable? = null

    var mylistitems: ArrayList<MyListRecyclerviewData> = ArrayList()

    lateinit var myListRecyclerviewAdapter: MyListRecyclerviewAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = View.inflate(activity, R.layout.fragment_my_list, null)
        tokenDriver.tokenDriver.subscribe{
            token = it
            Log.i("grid", token)
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        val mypage_recycle: RecyclerView = view!!.findViewById(R.id.setting_list_recycle)

        myListRecyclerviewAdapter = MyListRecyclerviewAdapter(mylistitems, context!!)
        myListRecyclerviewAdapter.setOnItemClickListener(this)
        mypage_recycle.layoutManager = LinearLayoutManager(activity)
        mypage_recycle.adapter = myListRecyclerviewAdapter

        if(token!=null){
            val call = networkService.getMyBoard(token!!)
            disposable = call.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()).subscribe(
                            { success->
                                Log.i("urls_success1", success.showBoardNumResult.toString())
                                for(i in 0..success.showBoardNumResult[0].boardNum-1){
                                    mylistitems.add(MyListRecyclerviewData(success.showUserPageResult[0].userImg.toString(),
                                            success.showUserPageResult[0].userId,success.showUserPageResult[0].userDesc.toString(),
                                            success.data[i].boardImg, success.data[i].boardDesc,
                                            success.data[i].boardDate, success.data[i].boardWeather,
                                            success.data[i].boardTempMin, success.data[i].boardTempMax))
                                    Log.i("urls_success2", success.data[i].boardImg)
                                }

                                    //Log.i("urls_success3", mylistitems[i].)
                                    Log.i("urls_success4", ""+mylistitems.size)
                                    myListRecyclerviewAdapter.notifyDataSetChanged()

                                },{fail-> Log.i("urls_failed", fail.message)})
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}