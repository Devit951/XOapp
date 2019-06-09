package com.github.devit951.xoapp.board

import android.widget.Button
import com.github.devit951.xoapp.xogame.Figure
import com.github.devit951.xoapp.xogame.Player
import com.github.devit951.xoapp.board.interceptor.DiagonalBoardInterceptor
import com.github.devit951.xoapp.board.interceptor.DrawBoardInterceptor
import com.github.devit951.xoapp.board.interceptor.HorizontalBoardInterceptor
import com.github.devit951.xoapp.board.interceptor.VerticalBoardInterceptor

class BoardObserver(private val cells: Array<Array<Cell?>>,
                    private val onBoardAction: (String) -> Unit) {

    private val players = listOf(Player(name = "SpaceX", figure = Figure.X), Player(name = "yota", figure = Figure.O))
    private var currentPlayerIndex = 0
    private val boardInterceptors = listOf(
            DiagonalBoardInterceptor(),
            HorizontalBoardInterceptor(),
            VerticalBoardInterceptor(),
            DrawBoardInterceptor())

    fun move(boardCoordinates: BoardCoordinates, button: Button){
        if (cells[boardCoordinates.column][boardCoordinates.row] == null){
            val currentPlayer = players[currentPlayerIndex++ % 2]
            cells[boardCoordinates.column][boardCoordinates.row] = Cell(currentPlayer)
            button.text = currentPlayer.figure.toString()
        }
        for (boardInterceptor in boardInterceptors){
            if (boardInterceptor.interceptBoard(cells, onBoardAction)){
                break
            }
        }
    }
}