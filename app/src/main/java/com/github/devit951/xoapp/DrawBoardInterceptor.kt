package com.github.devit951.xoapp

class DrawBoardInterceptor: BoardInterceptor {
    override fun interceptBoard(cells: Array<Array<Cell?>>, board: Board): Boolean{
        var cellOccupiedCount = 0
        cells.forEachIndexed { index, arrayOfCells ->
            arrayOfCells.forEachIndexed{ innerIndex, cell ->
                if (cells[index][innerIndex] != null) cellOccupiedCount++
            }
        }
        if (cellOccupiedCount == 9){
            board.onBoardAction.invoke(XOApp.context.getString(R.string.draw), board)
            return true
        }
        return false
    }
}