package com.github.devit951.xoapp.xogame

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.FrameLayout
import kotlin.random.Random

class XOBackgroundView(context: Context,
                       attributeSet: AttributeSet? = null,
                       defAttr: Int = 0): FrameLayout(context, attributeSet, defAttr){

    private val randomlyTranslateViews = mutableListOf(
            RandomTranslationView(XView(context)),
            RandomTranslationView(XView(context)),
            RandomTranslationView(OView(context)),
            RandomTranslationView(OView(context)))

    init {
        randomlyTranslateViews.forEach { addView(it.origin) }
        for (i in 1..10){
            growTranslationViewList(context, 5000 * i)
        }
        setWillNotDraw(false)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        randomlyTranslateViews.forEach { it.randomlyTranslate(canvas) }
        invalidate()
    }

    private fun growTranslationViewList(context: Context, delay: Int){
        postDelayed({
            val randomView = if (Random.nextInt(2) == 1) RandomTranslationView(XView(context)) else RandomTranslationView(OView(context))
            randomlyTranslateViews.add(randomView)
            addView(randomView.origin)
        }, delay.toLong())
    }
}