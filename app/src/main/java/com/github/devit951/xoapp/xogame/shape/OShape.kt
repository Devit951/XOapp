package com.github.devit951.xoapp.xogame.shape

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class OShape: Shape {

    private val circlePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
        style = Paint.Style.STROKE
        strokeWidth = 10f
    }

    override fun drawShape(canvas: Canvas) {
        canvas.drawCircle(canvas.width / 2f, canvas.height / 2f, 100f, circlePaint)
    }
}