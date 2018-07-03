package org.weatherook.weatherook.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_my.*
import org.weatherook.weatherook.MyRecyclerviewAdapter
import org.weatherook.weatherook.MyStoryActivity
import org.weatherook.weatherook.Mydata
import org.weatherook.weatherook.R

class MyFragment : Fragment(), View.OnClickListener {
    override fun onClick(p0: View?) {
        val idx : Int = setting_recycle.getChildAdapterPosition(p0) //몇번쨰 인지에 대한 정보를 알려줌
        val myimage : Int = myitems[idx].myimage
        var intent : Intent = Intent(activity,MyStoryActivity::class.java)
        intent.putExtra("myimage",myimage)
        requireActivity().startActivity(intent!!)

    }
    var myitems : ArrayList<Mydata> = ArrayList()
    lateinit var myRecyclerviewAdapter : MyRecyclerviewAdapter




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = View.inflate(activity, R.layout.fragment_my, null)
        val setting_recycle : RecyclerView = view.findViewById(R.id.setting_recycle)

        myitems.add(Mydata(R.drawable.heartcolor))
        myitems.add(Mydata(R.drawable.heart))
        myitems.add(Mydata(R.drawable.heartcolor))
        myitems.add(Mydata(R.drawable.heart))
        myitems.add(Mydata(R.drawable.heartcolor))
        myitems.add(Mydata(R.drawable.heart))


        setting_recycle.layoutManager = GridLayoutManager(activity,2)
        myRecyclerviewAdapter = MyRecyclerviewAdapter(myitems,context!!)
        myRecyclerviewAdapter.setOnItemClickListener(this@MyFragment)
        setting_recycle.adapter = myRecyclerviewAdapter
        return view
    }
}