package com.github.devit951.xoapp.board

import android.widget.Button
import android.widget.GridLayout
import com.github.devit951.xoapp.xogame.XOView

class Board(private val xoView: XOView,
            private val onBoardAction: (String) -> Unit){

    private var cells = Array<Array<Cell?>>(3) { arrayOfNulls(3) }
    private var boardObserver = BoardObserver(cells, onBoardAction)

    init {
        invalidate()
    }

    fun invalidate(){
        cells = Array<Array<Cell?>>(3) { arrayOfNulls(3) }
        boardObserver = BoardObserver(cells, onBoardAction)
        xoView.removeAllViews()
        xoView.apply {
            rowCount = 3
            columnCount = 3
            for (row in 0 until 3){
                for (column in 0 until 3){
                    addView(Button(context).apply {
                        setOnClickListener {
                            boardObserver.move(BoardCoordinates(row, column), this)
                        }
                        layoutParams = GridLayout.LayoutParams().apply {
                            columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                            rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                        }
                    })
                }
            }
        }
    }
}