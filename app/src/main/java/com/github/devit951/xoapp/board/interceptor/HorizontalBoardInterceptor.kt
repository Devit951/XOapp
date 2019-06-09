package com.github.devit951.xoapp.board.interceptor

import com.github.devit951.xoapp.*
import com.github.devit951.xoapp.board.Board
import com.github.devit951.xoapp.board.BoardInterceptor
import com.github.devit951.xoapp.board.Cell

class HorizontalBoardInterceptor: BoardInterceptor {
    override fun interceptBoard(cells: Array<Array<Cell?>>, onBoardAction: (String) -> Unit): Boolean{
        for (row in 0 until cells.size){
            var countOfSameFigureInRow = 0
            for (column in 0 until cells.size){
                if (cells[row][row] != null && cells[row][row] == cells[row][column]){
                    countOfSameFigureInRow++
                }
                if (countOfSameFigureInRow == 3){
                    val winnerPlayer = cells[row][row]
                    onBoardAction.invoke(XOApp.context.getString(R.string.the_winner_is, winnerPlayer))
                    return true
                }
            }
        }
        return false
    }
}