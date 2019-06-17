package com.github.devit951.xoapp.xogame

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import com.github.devit951.xoapp.xogame.shape.XShape

class XView(context: Context,
            attributeSet: AttributeSet? = null,
            defAttr: Int = 0): View(context, attributeSet, defAttr){

    private val xShape = XShape()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        xShape.drawShape(canvas)
    }
}