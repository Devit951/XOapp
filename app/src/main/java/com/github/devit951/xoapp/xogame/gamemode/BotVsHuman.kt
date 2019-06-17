package com.github.devit951.xoapp.xogame.gamemode

import com.github.devit951.xoapp.board.BoardCoordinates
import com.github.devit951.xoapp.board.Cell
import com.github.devit951.xoapp.xogame.Moveable
import com.github.devit951.xoapp.xogame.Player

class BotVsHuman(private val player: Moveable, val bot: Moveable): Moveable {
    override fun move(boardCoordinates: BoardCoordinates, cells: Array<Array<Cell?>>, onMoved: (BoardCoordinates, Player) -> Unit) {
        player.move(boardCoordinates, cells, onMoved)
        bot.move(boardCoordinates, cells, onMoved)
    }
}