package com.moashrafff.nectar.helpers

import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue

class SizeUtils {

    companion object{
        fun DpTopx(dp: Float, context: Context): Float {
            return dp * ((context.resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)).toFloat()
        }
    }

    fun pxToDp(context: Context, px: Float): Float {
        return px / context.resources.displayMetrics.density
    }



    fun spToPx(sp: Int, context: Context): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP,
            sp.toFloat(),
            context.resources.displayMetrics
        ).toInt()
    }
}