package com.github.devit951.xoapp.board.interceptor

import com.github.devit951.xoapp.*
import com.github.devit951.xoapp.board.BoardInterceptor
import com.github.devit951.xoapp.board.Cell

class DrawBoardInterceptor: BoardInterceptor {

    override fun interceptBoard(cells: Array<Array<Cell?>>, onBoardAction: (String) -> Unit): Boolean{
        if (isBoardFullOccupied(cells)){
            onBoardAction.invoke(XOApp.context.getString(R.string.draw))
        }
        return false
    }

    fun isBoardFullOccupied(cells: Array<Array<Cell?>>): Boolean{
        var cellOccupiedCount = 0
        cells.forEachIndexed { index, arrayOfCells ->
            arrayOfCells.forEachIndexed{ innerIndex, cell ->
                if (cells[index][innerIndex] != null) cellOccupiedCount++
            }
        }
        if (cellOccupiedCount == 9){
            return true
        }
        return false
    }
}