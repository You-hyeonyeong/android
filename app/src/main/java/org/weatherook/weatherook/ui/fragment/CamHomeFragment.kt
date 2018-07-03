package org.weatherook.weatherook.ui.fragment

import android.app.Activity
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
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
import org.weatherook.weatherook.adapter.GalleryItem
import org.weatherook.weatherook.adapter.GalleryRecyclerviewAdapter
import org.weatherook.weatherook.api.glide.GlideApp
import java.util.*

class CamHomeFragment : Fragment() {

    lateinit var myUrls: ArrayList<String>

    val imageWidthPixels = 320
    val imageHeightPixels = 240

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = View.inflate(activity, R.layout.fragment_camhome, null)
        val sizeProvider: ListPreloader.PreloadSizeProvider<Any> = FixedPreloadSizeProvider<Any>(imageWidthPixels, imageHeightPixels)
        val modelProvider: ListPreloader.PreloadModelProvider<Any> = MyPreloadModelProvider()
        val preloader: RecyclerViewPreloader<Any> = RecyclerViewPreloader<Any>(GlideApp.with(this), modelProvider, sizeProvider, 10)

        val camhome_gallery_rv: RecyclerView = view.findViewById(R.id.camhome_gallery_rv)
        myUrls = getAllShownImagesPath()



        camhome_gallery_rv.addOnScrollListener(preloader)
        camhome_gallery_rv.layoutManager = GridLayoutManager(activity, 2)
        camhome_gallery_rv.adapter = GalleryRecyclerviewAdapter(myUrls)
        //camhome_gallery_rv.adapter

        return view
    }





    private inner class MyPreloadModelProvider : ListPreloader.PreloadModelProvider<Any> {
        override fun getPreloadItems(position: Int): MutableList<Any> {
            val url = myUrls.get(position)
            if(TextUtils.isEmpty(url)){
                return Collections.emptyList()
            }
            return Collections.singletonList(url)
        }

        override fun getPreloadRequestBuilder(item: Any): RequestBuilder<*>? {
            return GlideApp.with(
                    this@CamHomeFragment.context!!
            ).load(item).override(imageWidthPixels, imageHeightPixels)
        }
    }

    private fun getAllShownImagesPath() : ArrayList<String> {
        val uri: Uri
        val cursor: Cursor?
        val column_index_data: Int
        val column_index_folder_name: Int
        val listOfAllImages = ArrayList<String>()
        var absolutePathOfImage: String? = null
        uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI

        val projection = arrayOf(MediaStore.MediaColumns.DATA, MediaStore.Images.Media.BUCKET_DISPLAY_NAME)
        cursor = context!!.contentResolver.query(uri, projection, null, null, null)

        column_index_data = cursor!!.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA)
        column_index_folder_name = cursor!!
                .getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME)
        while (cursor!!.moveToNext()) {
            absolutePathOfImage = cursor!!.getString(column_index_data)

            listOfAllImages.add(absolutePathOfImage)
        }
        return listOfAllImages
    }
}