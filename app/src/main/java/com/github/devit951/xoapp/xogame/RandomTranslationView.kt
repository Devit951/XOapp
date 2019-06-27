package com.github.devit951.xoapp.xogame

import android.graphics.Canvas
import android.util.Log
import android.view.View
import java.util.*

class RandomTranslationView(val origin: View) {

    companion object {
        private const val TRANSLATE_SPEED = 10
    }

    private val random = Random()

    private val road: Queue<Coordinates> = LinkedList()
    private var currentDirection = Direction.LEFT_TO_RIGHT
    private var yPoint = 0

    fun randomlyTranslate(canvas: Canvas){
        yPoint = random.nextInt(canvas.height - origin.width)
        if (road.isEmpty()){
            when(currentDirection){
                Direction.LEFT_TO_RIGHT -> {
                    for (i in 0..canvas.width){
                        val calculatedX = i * TRANSLATE_SPEED
                        if (calculatedX >= canvas.width - origin.width){
                            break
                        }
                        road.add(Coordinates(calculatedX, yPoint))
                    }
                }
                Direction.RIGHT_TO_LEFT -> {
                    for (i in canvas.width downTo 0){
                        val calculatedX = i - ((canvas.width - i) * TRANSLATE_SPEED) - origin.width
                        if (calculatedX <= 0){
                            break
                        }
                        road.add(Coordinates(calculatedX, yPoint))
                    }
                }
            }

        } else {
            val coordinate = road.remove()
            val originSize = coordinate.x + origin.width

            origin.y = coordinate.y.toFloat()
            origin.x = coordinate.x.toFloat()

            when{
                originSize >= (canvas.width - origin.width) -> {
                    currentDirection = Direction.RIGHT_TO_LEFT
                }
                originSize <= canvas.width -> {
                    currentDirection = Direction.LEFT_TO_RIGHT
                }
            }
            Log.d("test333", "coordinate x = ${coordinate.x},  direction = $currentDirection")
        }
    }


    private data class Coordinates(val x: Int, val y: Int)
    private enum class Direction{
        LEFT_TO_RIGHT, RIGHT_TO_LEFT
    }
}