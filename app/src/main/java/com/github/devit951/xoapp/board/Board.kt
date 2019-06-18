package com.github.devit951.xoapp.board

import android.annotation.TargetApi
import android.content.res.Resources
import android.widget.Button
import android.widget.GridLayout
import com.github.devit951.xoapp.xogame.Moveable
import com.github.devit951.xoapp.xogame.XOView
import android.graphics.drawable.BitmapDrawable
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Build
import com.github.devit951.xoapp.xogame.Player

class Board(private val xoView: XOView,
            private val players: List<Moveable>,
            private val onBoardAction: (String) -> Unit){

    private val sizeOfBoard = 3

    private var cells = Array<Array<Cell?>>(sizeOfBoard) { arrayOfNulls(sizeOfBoard) }
    private var buttons = Array<Array<Button?>>(sizeOfBoard) { arrayOfNulls(sizeOfBoard) }
    private var boardObserver = BoardObserver(cells, players, onBoardAction)

    var onPlayerMoved: ((Player) -> Unit)? = null

    init {
        invalidate()
    }

    fun invalidate(){
        moveToDefaultState()
        xoView.apply {
            rowCount = sizeOfBoard
            columnCount = sizeOfBoard
            for (row in 0 until rowCount){
                for (column in 0 until columnCount){
                    Button(context).apply {
                        buttons[row][column] = this
                        layoutParams = GridLayout.LayoutParams().apply {
                            columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                            rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                        }
                        setOnClickListener {
                            boardObserver.move(BoardCoordinates(row, column)){ boardCoordinates, currentPlayer ->
                                onPlayerMoved?.invoke(currentPlayer)
                                drawFigureOn(buttons[boardCoordinates.row][boardCoordinates.column]!!, currentPlayer)
                            }
                        }
                        addView(this)
                    }
                }
            }
        }
    }

    private fun moveToDefaultState(){
        cells = Array<Array<Cell?>>(sizeOfBoard) { arrayOfNulls(sizeOfBoard) }
        boardObserver = BoardObserver(cells, players, onBoardAction)
        buttons = Array<Array<Button?>>(sizeOfBoard) { arrayOfNulls(sizeOfBoard) }
        xoView.removeAllViews()
    }

    @TargetApi(Build.VERSION_CODES.M)
    private fun drawFigureOn(button: Button, currentPlayer: Player){
        val bitmap = Bitmap.createBitmap(button.width, button.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val drawable = BitmapDrawable(Resources.getSystem(), bitmap)
        button.foreground = drawable
        currentPlayer.figure.draw(canvas)
    }
}