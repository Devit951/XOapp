package com.github.devit951.xoapp.xogame

import android.graphics.Canvas
import android.util.Log
import android.view.View
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs
import kotlin.random.Random

class RandomTranslationView(val origin: View) {

    companion object {
        private val TAG = RandomTranslationView::class.java.simpleName
    }

    private val road: Queue<Coordinate> = LinkedList()
    private var currentDirection = Direction.values().get(0)
    private var lastCoordinate: Coordinate? = null

    fun randomlyTranslate(canvas: Canvas){
        val randomY = Random.nextDouble(canvas.height - origin.width.toDouble()).toFloat()
        if (road.isEmpty()){
            when(currentDirection){
                Direction.LEFT_TO_RIGHT -> {
                    if (lastCoordinate == null){
                        lastCoordinate = Coordinate(0f, randomY)
                    }
                    val secondCoordinate = Coordinate(canvas.width.toFloat(), randomY)
                    road.addAll(lastCoordinate!!.horizontalDistanceLeftToRight(secondCoordinate))
                    lastCoordinate = secondCoordinate
                }
                Direction.RIGHT_TO_LEFT -> {
                    if (lastCoordinate == null){
                        lastCoordinate = Coordinate(canvas.width.toFloat(), randomY)
                    }
                    val secondCoordinate = Coordinate(0f, randomY)
                    road.addAll(lastCoordinate!!.horizontalDistanceRightToLeft(secondCoordinate))
                    lastCoordinate = secondCoordinate
                }
            }

        } else {
            val coordinate = road.remove()
            val xOriginSize = coordinate.x + origin.width

            origin.x = coordinate.x
            origin.y = coordinate.y

            when{
                xOriginSize >= (canvas.width - origin.width) -> {
                    currentDirection = Direction.RIGHT_TO_LEFT
                }
                xOriginSize <= canvas.width -> {
                    currentDirection = Direction.LEFT_TO_RIGHT
                }
            }
            Log.d(TAG, "coordinate $coordinate,  direction = $currentDirection")
        }
    }


    private inner class Coordinate(val x: Float, val y: Float){
        fun horizontalDistanceLeftToRight(anotherCoordinate: Coordinate): List<Coordinate>{
            val coordinates = ArrayList<Coordinate>()
            val translationSpeed = Random.nextDouble(10.0, 30.0).toFloat()
            val yDiff = abs(y - anotherCoordinate.y) / anotherCoordinate.x
            for (i in 0..anotherCoordinate.x.toInt()){
                val calculatedX = x + i * translationSpeed
                val calculatedY = if (anotherCoordinate.y > y) y + yDiff * i * translationSpeed else y - yDiff * i * translationSpeed
                if (calculatedX >= anotherCoordinate.x - origin.width) break
                coordinates.add(Coordinate(calculatedX, calculatedY))
            }
            return coordinates
        }

        fun horizontalDistanceRightToLeft(anotherCoordinate: Coordinate): List<Coordinate>{
            val coordinates = ArrayList<Coordinate>()
            val translationSpeed = Random.nextDouble(10.0, 30.0).toFloat()
            val yDiff = abs(y - anotherCoordinate.y) / x
            for (i in x.toInt() downTo 0){
                val calculatedX = x - ((x - i) * translationSpeed) - origin.width
                val calculatedY = if (anotherCoordinate.y > y) y + (yDiff *(x - i) * translationSpeed) - (origin.height - translationSpeed) else y - (yDiff *(x - i) * translationSpeed) - (origin.height - translationSpeed)
                if (calculatedX <= 0) break
                coordinates.add(Coordinate(calculatedX, calculatedY))
            }
            return coordinates
        }

        override fun toString() = "Coordinate(x=$x, y=$y)"
    }
    private enum class Direction{
        LEFT_TO_RIGHT, RIGHT_TO_LEFT
    }
}