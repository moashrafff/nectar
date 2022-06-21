package com.moashrafff.nectar.views.widgets

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.moashrafff.nectar.R
import com.moashrafff.nectar.helpers.SizeUtils

class MainButton : AppCompatButton {


    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    init {
        setTextColor(context.getColor(R.color.white))
        isAllCaps = false
        gravity = 0x11
        typeface = ResourcesCompat.getFont(context, R.font.gilroy_semibold)
        background = getDrawable(context.getColor(R.color.main_color),25f)

    }

     private fun getDrawable(color: Int, radius: Float): Drawable {
        val shape = GradientDrawable()
        shape.setColor(color)
        shape.shape = GradientDrawable.RECTANGLE
        shape.cornerRadius = SizeUtils.DpTopx(radius,context)
        return shape
    }

}