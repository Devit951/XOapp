package com.github.devit951.xoapp.xogame.bot

import com.github.devit951.xoapp.board.BoardCoordinates
import com.github.devit951.xoapp.board.Cell
import com.github.devit951.xoapp.board.interceptor.DrawBoardInterceptor
import com.github.devit951.xoapp.xogame.Figure
import com.github.devit951.xoapp.xogame.Moveable
import com.github.devit951.xoapp.xogame.Player
import kotlin.random.Random

class EasyBot(figure: Figure): Moveable {

    private val botPlayer = Player(name = "Easy bot", figure = figure)
    private val drawBoardInterceptor = DrawBoardInterceptor()

    override fun move(boardCoordinates: BoardCoordinates, cells: Array<Array<Cell?>>, onMoved: (BoardCoordinates, Player) -> Unit) {
        if (!drawBoardInterceptor.isBoardFullOccupied(cells)){
            var makeMove = false
            while (!makeMove){
                val botCoordinates = BoardCoordinates(row = Random.nextInt(cells.size), column = Random.nextInt(cells.size))
                if (cells[botCoordinates.row][botCoordinates.column] == null){
                    cells[botCoordinates.row][botCoordinates.column] = Cell(botPlayer)
                    onMoved(botCoordinates, botPlayer)
                    makeMove = true
                }
            }
        }
    }
}