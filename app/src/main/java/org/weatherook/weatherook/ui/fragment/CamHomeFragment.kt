package org.weatherook.weatherook.ui.fragment

import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.ListPreloader
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.integration.recyclerview.RecyclerViewPreloader
import com.bumptech.glide.util.FixedPreloadSizeProvider
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import org.weatherook.weatherook.R
import org.weatherook.weatherook.adapter.GalleryRecyclerviewAdapter
import org.weatherook.weatherook.api.glide.GlideApp
import java.util.*
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_camhome.*
import org.weatherook.weatherook.api.camera.CameraActivity
import org.weatherook.weatherook.singleton.Driver.gallayDriver


class CamHomeFragment : Fragment() , View.OnClickListener{

    override fun onClick(v: View?) {
        //do nothing
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = View.inflate(activity, R.layout.fragment_camhome, null)

        val camhome_cam_txt : TextView = view.findViewById(R.id.camhome_cam_txt)

        val fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction.replace(R.id.camhome_bottom_container, GalleryFragment()).commit()

        camhome_cam_txt.setOnClickListener {
            val intent = Intent(activity, CameraActivity::class.java)
            startActivity(intent)
        }

        val camhome_next: TextView = view.findViewById(R.id.camhome_next)
        camhome_next.setOnClickListener {
            val linearlayout: LinearLayout = view.findViewById(R.id.linearLayout)
            linearlayout.visibility = View.GONE
            val fragmentTransaction = fragmentManager!!.beginTransaction()
            fragmentTransaction.replace(R.id.camhome_bottom_container, WriteFragment()).commit()
        }

        val camhome_cancel: TextView = view.findViewById(R.id.camhome_cancel)
        camhome_cancel.setOnClickListener {
            val linearlayout: LinearLayout = view.findViewById(R.id.linearLayout)
            linearlayout.visibility = View.VISIBLE
            val fragmentTransaction = fragmentManager!!.beginTransaction()
            fragmentTransaction.replace(R.id.camhome_bottom_container, GalleryFragment()).commit()
        }
        gallayDriver.subscribe {
            GlideApp.with(activity!!).load(it).into(camhome_container)
        }
        return view
    }
}