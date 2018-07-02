package org.weatherook.weatherook.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.ListPreloader
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.integration.recyclerview.RecyclerViewPreloader
import com.bumptech.glide.util.FixedPreloadSizeProvider
import kotlinx.android.synthetic.main.fragment_camhome.*
import org.weatherook.weatherook.R
import org.weatherook.weatherook.api.glide.GlideApp

class CamHomeFragment : Fragment() {

    lateinit var myUrls: MutableList<String>

    val imageWidthPixels = 320
    val imageHeightPixels = 240

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = View.inflate(activity, R.layout.fragment_camhome, null)
        val sizeProvider: ListPreloader.PreloadSizeProvider<Any> = FixedPreloadSizeProvider<Any>(imageWidthPixels, imageHeightPixels)
        val modelProvider: ListPreloader.PreloadModelProvider<Any> = MyPreloadModelProvider()
        val preloader: RecyclerViewPreloader<Any> = RecyclerViewPreloader<Any>(GlideApp.with(this), modelProvider, sizeProvider, 10)

        val camhome_gallery_rv: RecyclerView = view.findViewById(R.id.camhome_gallery_rv)

        camhome_gallery_rv.addOnScrollListener(preloader)
        camhome_gallery_rv.layoutManager = GridLayoutManager(activity, 2)
        //camhome_gallery_rv.adapter

        return view
    }

    class MyPreloadModelProvider : ListPreloader.PreloadModelProvider<Any> {
        override fun getPreloadItems(position: Int): MutableList<Any> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getPreloadRequestBuilder(item: Any): RequestBuilder<*>? {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}