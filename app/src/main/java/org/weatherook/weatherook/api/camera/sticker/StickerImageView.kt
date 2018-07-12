package org.weatherook.weatherook.api.camera.sticker

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView


class StickerImageView : StickerView {

    var ownerId: String? = null
    var iv_main: ImageView? = null

    var imageBitmap: Bitmap
        get() = (this.iv_main!!.drawable as BitmapDrawable).bitmap
        set(bmp) = this.iv_main!!.setImageBitmap(bmp)

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {}

    public override fun getMainView(): View? {
        if (this.iv_main == null) {
            this.iv_main = ImageView(context)
            this.iv_main!!.scaleType = ImageView.ScaleType.FIT_XY
            this.iv_main!!.isClickable = true
        }
        return iv_main
    }

    fun setImageResource(res_id: Int) {
        this.iv_main!!.setImageResource(res_id)
    }

    fun setImageDrawable(drawable: Drawable) {
        this.iv_main!!.setImageDrawable(drawable)
    }

}