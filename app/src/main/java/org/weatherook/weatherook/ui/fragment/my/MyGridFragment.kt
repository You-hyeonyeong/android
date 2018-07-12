package org.weatherook.weatherook.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.weatherook.weatherook.R
import org.weatherook.weatherook.adapter.recyclerview.MyGridRecyclerviewAdapter
import org.weatherook.weatherook.api.network.NetworkService
import org.weatherook.weatherook.item.MyGridRecyclerviewdata
import org.weatherook.weatherook.singleton.tokenDriver


/**
 * Created by HYEON on 2018-07-04.
 */
class MyGridFragment : Fragment(), View.OnClickListener {

    var token : String ?= null

    override fun onClick(p0: View?) {

    }
    lateinit var myitems: ArrayList<MyGridRecyclerviewdata>

    lateinit var myGridRecyclerviewAdapter: MyGridRecyclerviewAdapter

    val networkService by lazy {
        NetworkService.create()
    }
    var disposable: Disposable? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = View.inflate(context!!, R.layout.fragment_my_grid, null)
        tokenDriver.tokenDriver.subscribe{
            token = it
            Log.i("grid", token)
        }
        return view
    }

    override fun onStart() {
        super.onStart()

        val mypage_recycle: RecyclerView = view!!.findViewById(R.id.setting_grid_recycle)

        myitems = ArrayList()

        myGridRecyclerviewAdapter = MyGridRecyclerviewAdapter(myitems, context!!)
        myGridRecyclerviewAdapter.setOnItemClickListener(this)
        mypage_recycle.adapter = myGridRecyclerviewAdapter
        mypage_recycle.layoutManager = GridLayoutManager(activity, 2)

        if(token!=null){
            val call = networkService.getMyBoard(token!!)
            disposable = call.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()).subscribe(
                            { success->
                                Log.i("urls_success1", success.showBoardNumResult.toString())
                                for(i in 0..success.showBoardNumResult[0].boardNum-1){
                                    myitems.add(MyGridRecyclerviewdata(success.data[i].boardImg))
                                    Log.i("urls_success2", success.data[i].boardImg)
                                    Log.i("urls_success3", myitems[i].url)
                                    Log.i("urls_success4", ""+myitems.size)
                                    myGridRecyclerviewAdapter.notifyDataSetChanged()

                                }},{fail-> Log.i("urls_failed", fail.message)})

            /*myitems.add(MyGridRecyclerviewdata(R.drawable.brown))
            myitems.add(MyGridRecyclerviewdata(R.drawable.heart))
            myitems.add(MyGridRecyclerviewdata(R.drawable.heartcolor))
            myitems.add(MyGridRecyclerviewdata(R.drawable.heart))
            myitems.add(MyGridRecyclerviewdata(R.drawable.heartcolor))
            myitems.add(MyGridRecyclerviewdata(R.drawable.heart))*/


            //myGridRecyclerviewAdapter = MyGridRecyclerviewAdapter(myitems, context!!)
            myGridRecyclerviewAdapter.notifyDataSetChanged()
        }
    }
}