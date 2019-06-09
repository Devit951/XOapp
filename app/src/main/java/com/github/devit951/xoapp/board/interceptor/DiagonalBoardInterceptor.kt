package com.github.devit951.xoapp.board.interceptor

import com.github.devit951.xoapp.*
import com.github.devit951.xoapp.board.BoardInterceptor
import com.github.devit951.xoapp.board.Cell

class DiagonalBoardInterceptor: BoardInterceptor {
    override fun interceptBoard(cells: Array<Array<Cell?>>, onBoardAction: (String) -> Unit): Boolean {
        if (cells[0][0] != null && cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2]){
            notifyWinnerPlayer(cells, onBoardAction)
            return true
        }
        if (cells[2][0] != null && cells[2][0] == cells[1][1] && cells[1][1] == cells[0][2]){
            notifyWinnerPlayer(cells, onBoardAction)
            return true
        }
        return false
    }

    private fun notifyWinnerPlayer(cells: Array<Array<Cell?>>, onBoardAction: (String) -> Unit){
        val winnerPlayer = cells[1][1]
        onBoardAction.invoke(XOApp.context.getString(R.string.the_winner_is, winnerPlayer))
    }
}