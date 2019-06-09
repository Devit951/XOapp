package com.github.devit951.xoapp.board

import com.github.devit951.xoapp.board.Board
import com.github.devit951.xoapp.board.Cell

interface BoardInterceptor {
    fun interceptBoard(cells: Array<Array<Cell?>>, board: Board): Boolean
}