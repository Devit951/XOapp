package com.github.devit951.xoapp

interface BoardInterceptor {
    fun interceptBoard(cells: Array<Array<Cell?>>, board: Board): Boolean
}