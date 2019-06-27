package com.github.devit951.xoapp.xogame

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.FrameLayout

class XOBackgroundView(context: Context,
                       attributeSet: AttributeSet? = null,
                       defAttr: Int = 0): FrameLayout(context, attributeSet, defAttr){

    private val randomlyTranslateViews = listOf(
            RandomTranslationView(XView(context)),
            RandomTranslationView(XView(context)),
            RandomTranslationView(OView(context)),
            RandomTranslationView(OView(context)))

    init {
        randomlyTranslateViews.forEach { addView(it.origin) }
        setWillNotDraw(false)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        randomlyTranslateViews.forEach { it.randomlyTranslate(canvas) }
        invalidate()
    }
}