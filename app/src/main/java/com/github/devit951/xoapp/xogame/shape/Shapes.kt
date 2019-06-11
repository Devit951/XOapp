package com.github.devit951.xoapp.xogame.shape

import com.github.devit951.xoapp.xogame.Figure

object Shapes {
    private val poolOfShapes = mapOf(
            Figure.X to XShape(),
            Figure.O to OShape())

    fun get(figure: Figure) = poolOfShapes.getValue(figure)
}