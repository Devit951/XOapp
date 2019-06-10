package com.github.devit951.xoapp.board

import com.github.devit951.xoapp.board.interceptor.DiagonalBoardInterceptor
import com.github.devit951.xoapp.board.interceptor.DrawBoardInterceptor
import com.github.devit951.xoapp.board.interceptor.HorizontalBoardInterceptor
import com.github.devit951.xoapp.board.interceptor.VerticalBoardInterceptor
import com.github.devit951.xoapp.xogame.Moveable
import com.github.devit951.xoapp.xogame.Player

class BoardObserver(private val cells: Array<Array<Cell?>>,
                    private val players: List<Moveable>,
                    private val onBoardAction: (String) -> Unit) {

    private var currentPlayerIndex = 0

    private val boardInterceptors = listOf(
            DiagonalBoardInterceptor(),
            HorizontalBoardInterceptor(),
            VerticalBoardInterceptor(),
            DrawBoardInterceptor())

    fun move(boardCoordinates: BoardCoordinates, onMoved: (BoardCoordinates, Player) -> Unit){
        if (cells[boardCoordinates.row][boardCoordinates.column] == null){
            val currentPlayer: Moveable
            if (players.size == 1){
                currentPlayer = players.single()
            } else {
                currentPlayer = players[currentPlayerIndex++ % 2]
            }
            currentPlayer.move(boardCoordinates, cells, onMoved)
        }
        for (boardInterceptor in boardInterceptors){
            if (boardInterceptor.interceptBoard(cells, onBoardAction)){
                break
            }
        }
    }
}