package org.weatherook.weatherook.ui.fragment.camera

import android.content.Intent
import android.graphics.PointF
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.SCALE_TYPE_CENTER_CROP
import org.weatherook.weatherook.api.glide.GlideApp
import kotlinx.android.synthetic.main.fragment_camhome.*
import org.weatherook.weatherook.R
import org.weatherook.weatherook.api.camera.CameraActivity
import org.weatherook.weatherook.api.camera.sticker.StickerImageView
import org.weatherook.weatherook.singleton.urlDriver


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
        urlDriver.urlDriver.subscribe {
            try {
                if(it!=null){
                    Log.i("driver",it)
                    //GlideApp.with(activity!!).load(it).into(camhome_container)
                    camhome_container.setImage(ImageSource.uri(it))
                    camhome_container.setMinimumScaleType(SCALE_TYPE_CENTER_CROP)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        val canvas : FrameLayout = view.findViewById(R.id.sticker_frame)
        val iv_sticker = StickerImageView(context!!)
        iv_sticker.setImageDrawable(getResources().getDrawable( R.drawable.moon))
        canvas.addView(iv_sticker)

        return view
    }
}