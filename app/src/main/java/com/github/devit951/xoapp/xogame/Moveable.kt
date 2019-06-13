package com.github.devit951.xoapp.xogame

import com.github.devit951.xoapp.board.BoardCoordinates
import com.github.devit951.xoapp.board.Cell
import java.io.Serializable

interface Moveable: Serializable {
    fun move(boardCoordinates: BoardCoordinates, cells: Array<Array<Cell?>>, onMoved: (BoardCoordinates, Player) -> Unit)
}