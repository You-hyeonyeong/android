package org.weatherook.weatherook.ui.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.weatherook.weatherook.R

/**
 * Created by HYEON on 2018-07-07.
 */
class FriendFragment : Fragment(), View.OnClickListener {
    override fun onClick(p0: View?){

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.fragment_friend, container,false)
        return  v
    }

    override fun onStart() {
        super.onStart()

    }
}