package com.github.devit951.xoapp.xogame

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.github.devit951.xoapp.extension.dp
import com.github.devit951.xoapp.xogame.shape.OShape

class OView(context: Context,
            attributeSet: AttributeSet? = null,
            defAttr: Int = 0): View(context, attributeSet, defAttr) {

    private val oShape = OShape()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        oShape.drawShape(canvas)
    }

    @SuppressLint("SwitchIntDef")
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(100.dp, 100.dp)
    }
}