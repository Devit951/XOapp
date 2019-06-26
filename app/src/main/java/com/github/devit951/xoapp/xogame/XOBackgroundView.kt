package com.github.devit951.xoapp.xogame

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.FrameLayout

class XOBackgroundView(context: Context,
                       attributeSet: AttributeSet? = null,
                       defAttr: Int = 0): FrameLayout(context, attributeSet, defAttr){

    private var actualY = 0

    private val xoViews = listOf(XView(context), OView(context), XView(context), OView(context))

    init {
        xoViews.forEach {
            addView(it)
        }
        setWillNotDraw(false)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        actualY = (actualY + 10) % height
        for (i in 0 until childCount){
            getChildAt(i).apply {
                val sizeOfFigure = Math.min(measuredWidth, measuredHeight)
                top = actualY
                bottom = top + sizeOfFigure
                left = sizeOfFigure * i
                right = left + sizeOfFigure
            }
        }
        invalidate()
    }
}