package com.github.devit951.xoapp.board

import java.io.Serializable

interface BoardInterceptor: Serializable {
    fun interceptBoard(cells: Array<Array<Cell?>>, onBoardAction: (String) -> Unit): Boolean
}