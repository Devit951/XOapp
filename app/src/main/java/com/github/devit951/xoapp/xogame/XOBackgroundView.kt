package com.github.devit951.xoapp.xogame

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.FrameLayout
import com.github.devit951.xoapp.extension.dp

class XOBackgroundView(context: Context,
                       attributeSet: AttributeSet? = null,
                       defAttr: Int = 0): FrameLayout(context, attributeSet, defAttr){

    companion object {
        private val SIZE_OF_FIGURE = 100.dp
    }

    private var actualY = 0

    private val xoViews = listOf(XView(context), OView(context), XView(context), OView(context))

    init {
        xoViews.forEach {
            addView(it.apply {
                post {
                    layoutParams = FrameLayout.LayoutParams(SIZE_OF_FIGURE, SIZE_OF_FIGURE)
                }
            })
        }
        setWillNotDraw(false)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        actualY = (actualY + 10) % height
        for (i in 0 until childCount){
            getChildAt(i).apply {
                top = actualY
                bottom = top + SIZE_OF_FIGURE
                left = SIZE_OF_FIGURE * i
                right = left + SIZE_OF_FIGURE
            }
        }
        invalidate()
    }
}