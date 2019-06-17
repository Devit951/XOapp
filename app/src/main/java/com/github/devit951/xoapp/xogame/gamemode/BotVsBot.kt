package com.github.devit951.xoapp.xogame.gamemode

import com.github.devit951.xoapp.board.BoardCoordinates
import com.github.devit951.xoapp.board.Cell
import com.github.devit951.xoapp.xogame.Figure
import com.github.devit951.xoapp.xogame.Moveable
import com.github.devit951.xoapp.xogame.Player
import com.github.devit951.xoapp.xogame.bot.EasyBot

class BotVsBot: Moveable {

    private val firstEasyBot = EasyBot(Figure.O)
    private val secondEasyBot = EasyBot(Figure.X)

    override fun move(boardCoordinates: BoardCoordinates, cells: Array<Array<Cell?>>, onMoved: (BoardCoordinates, Player) -> Unit) {
        firstEasyBot.move(boardCoordinates, cells, onMoved)
        secondEasyBot.move(boardCoordinates, cells, onMoved)
    }

    fun bots() = listOf(firstEasyBot, secondEasyBot)
}
