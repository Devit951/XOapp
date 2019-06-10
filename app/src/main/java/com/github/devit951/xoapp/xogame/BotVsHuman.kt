package com.github.devit951.xoapp.xogame

import com.github.devit951.xoapp.board.BoardCoordinates
import com.github.devit951.xoapp.board.Cell

class BotVsHuman(private val player: Moveable, val bot: Moveable): Moveable {
    override fun move(boardCoordinates: BoardCoordinates, cells: Array<Array<Cell?>>, onMoved: (BoardCoordinates, Player) -> Unit) {
        player.move(boardCoordinates, cells, onMoved)
        bot.move(boardCoordinates, cells, onMoved)
    }
}