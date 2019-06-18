package com.github.devit951.xoapp.xogame

import android.graphics.Canvas
import com.github.devit951.xoapp.xogame.shape.Shapes

enum class Figure {

    X {
        override fun draw(canvas: Canvas){
            Shapes.get(X).drawShape(canvas)
        }
        override fun opposite() = O
    },
    O {
        override fun draw(canvas: Canvas){
            Shapes.get(O).drawShape(canvas)
        }
        override fun opposite() = X
    };

    abstract fun draw(canvas: Canvas)
    abstract fun opposite(): Figure
}