package org.weatherook.weatherook.utils

import android.app.Activity
import android.content.Context
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager

/**
 * Created by jbw10 on 2018-02-09.
 */

class KeyboardVisibility {
    companion object {


        fun hideKeyboard(context: Context) {
            try {
                (context as Activity).window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
                if (context.currentFocus != null && context.currentFocus!!.windowToken != null) {
                    (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(context.currentFocus!!.windowToken, 0)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

        fun showKeyboard(context: Context) {
            (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
        }
    }
}