package com.github.devit951.xoapp

class VerticalBoardInterceptor: BoardInterceptor {

    override fun interceptBoard(cells: Array<Array<Cell?>>, board: Board): Boolean {
        for (row in 0 until cells.size){
            var countOfSameFigureInColumn = 0
            for (column in 0 until cells.size){
                if (cells[row][row] != null && cells[row][row] == cells[column][row]){
                    countOfSameFigureInColumn += 1
                }
                if (countOfSameFigureInColumn == 3){
                    val winnerPlayer = cells[row][row]
                    board.onBoardAction.invoke(XOApp.context.getString(R.string.the_winner_is, winnerPlayer), board)
                    return true
                }
            }
        }
        return false
    }

}