package com.github.devit951.xoapp.board

import android.widget.Button
import android.widget.GridLayout
import com.github.devit951.xoapp.xogame.Moveable
import com.github.devit951.xoapp.xogame.XOView

class Board(private val xoView: XOView,
            private val players: List<Moveable>,
            private val onBoardAction: (String) -> Unit){

    private var cells = Array<Array<Cell?>>(3) { arrayOfNulls(3) }
    private var buttons = Array<Array<Button?>>(3) { arrayOfNulls(3) }
    private var boardObserver = BoardObserver(cells, players, onBoardAction)

    init {
        invalidate()
    }

    fun invalidate(){
        moveToDefaultState()
        xoView.apply {
            rowCount = 3
            columnCount = 3
            for (row in 0 until rowCount){
                for (column in 0 until columnCount){
                    Button(context).apply {
                        layoutParams = GridLayout.LayoutParams().apply {
                            columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                            rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                        }
                        buttons[row][column] = this
                        addView(this)
                        setOnClickListener {
                            boardObserver.move(BoardCoordinates(row, column)){ boardCoordinates, currentPlayer ->
                                buttons[boardCoordinates.row][boardCoordinates.column]!!.text = currentPlayer.figure.toString()
                            }
                        }
                    }
                }
            }
        }
    }

    private fun moveToDefaultState(){
        cells = Array<Array<Cell?>>(3) { arrayOfNulls(3) }
        boardObserver = BoardObserver(cells, players, onBoardAction)
        buttons = Array<Array<Button?>>(3) { arrayOfNulls(3) }
        xoView.removeAllViews()
    }
}