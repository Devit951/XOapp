package com.github.devit951.xoapp.xogame

import android.graphics.Canvas
import com.github.devit951.xoapp.xogame.shape.Shapes

enum class Figure {

    X {
        override fun draw(canvas: Canvas){
            Shapes.get(X).drawShape(canvas)
        }
    },
    O {
        override fun draw(canvas: Canvas){
            Shapes.get(O).drawShape(canvas)
        }
    };

    abstract fun draw(canvas: Canvas)
}