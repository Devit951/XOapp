package com.github.devit951.xoapp.xogame.shape

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class XShape: Shape {

    private val xPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLUE
        strokeWidth = 10f
    }

    override fun drawShape(canvas: Canvas) {
        val halfHeight = canvas.height * 0.5f
        val halfWidth = canvas.width * 0.5f
        canvas.drawLine(halfWidth - 100, halfHeight - 100, halfWidth + 100, halfHeight + 100, xPaint)
        canvas.drawLine(halfWidth + 100, halfHeight - 100, halfWidth - 100, halfHeight + 100, xPaint)
    }
}