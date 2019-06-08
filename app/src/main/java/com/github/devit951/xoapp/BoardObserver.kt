package com.github.devit951.xoapp

import android.widget.Button

class BoardObserver(private val board: Board) {

    private val players = listOf(Player(name = "SpaceX", figure = Figure.X), Player(name ="yota", figure = Figure.O))
    private var currentPlayerIndex = 0
    private val boardInterceptors = listOf(
            DiagonalBoardInterceptor(),
            HorizontalBoardInterceptor(),
            VerticalBoardInterceptor(),
            DrawBoardInterceptor())

    fun move(tableCoordinates: TableCoordinates, button: Button){
        board.apply {
            if (cells[tableCoordinates.column][tableCoordinates.row] == null){
                val currentPlayer = players[currentPlayerIndex++ % 2]
                cells[tableCoordinates.column][tableCoordinates.row] = Cell(currentPlayer)
                button.text = currentPlayer.figure.toString()
            }
            for (boardInterceptor in boardInterceptors){
                if (boardInterceptor.interceptBoard(cells, this)){
                    break
                }
            }
        }
    }
}