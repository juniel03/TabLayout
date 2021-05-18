package com.bluesolution.tablayout.util

import android.content.Context
import android.content.res.Resources

class TabLayout_Util {
    companion object {
        fun dpToPx(dp: Int): Int {
            return ((dp * Resources.getSystem().displayMetrics.density).toInt());
        }

        fun pxToDp(px: Int, context: Context): Int {
            return ((px / Resources.getSystem().displayMetrics.density).toInt());
        }
    }
}