package org.weatherook.weatherook.api.camera.sticker

import android.content.Context
import android.support.v4.content.res.TypedArrayUtils.getText
import android.view.View
import android.view.Gravity
import android.R.attr.gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import android.graphics.Color
import android.util.AttributeSet
import org.weatherook.weatherook.api.camera.sticker.AutoResizeTextView
import android.support.v4.content.res.TypedArrayUtils.getText






class StickerTextView : StickerView {
    private lateinit var tv_main: AutoResizeTextView

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    public override fun getMainView(): View {
        if (tv_main != null)
            return tv_main

        tv_main = AutoResizeTextView(context)
        //tv_main.setTextSize(22);
        tv_main.setTextColor(Color.WHITE)
        tv_main.gravity = Gravity.CENTER
        tv_main.setTextSize(400f)
        tv_main.setShadowLayer(4f, 0f, 0f, Color.BLACK)
        tv_main.maxLines = 1
        val params = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        )
        params.gravity = Gravity.CENTER
        tv_main.layoutParams = params
        if (getImageViewFlip() != null)
            getImageViewFlip().visibility = View.GONE
        return tv_main
    }

    fun setText(text: String) {
        if (tv_main != null)
            tv_main.text = text
    }

    fun getText(): String? {
        return if (tv_main != null) tv_main.text.toString() else null

    }

    fun pixelsToSp(context: Context, px: Float): Float {
        val scaledDensity = context.resources.displayMetrics.scaledDensity
        return px / scaledDensity
    }


}