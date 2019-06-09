package com.github.devit951.xoapp.board

interface BoardInterceptor {
    fun interceptBoard(cells: Array<Array<Cell?>>, onBoardAction: (String) -> Unit): Boolean
}