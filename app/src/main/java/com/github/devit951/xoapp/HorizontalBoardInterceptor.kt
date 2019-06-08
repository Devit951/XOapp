package com.github.devit951.xoapp

class HorizontalBoardInterceptor: BoardInterceptor {
    override fun interceptBoard(cells: Array<Array<Cell?>>, board: Board): Boolean{
        for (row in 0 until cells.size){
            if (figuresInRowSame(cells[row])){
                val winnerPlayer = cells[row][0]!!.player
                board.onBoardAction.invoke(XOApp.context.getString(R.string.the_winner_is, winnerPlayer), board)
                return true
            }
        }
        return false
    }

    private fun figuresInRowSame(verticalCells: Array<Cell?>): Boolean{
        if (verticalCells[0]?.player == null || verticalCells[1]?.player == null || verticalCells[2]?.player == null){
            return false
        }
        return verticalCells[0]?.player?.figure == verticalCells[1]?.player?.figure && verticalCells[1]?.player?.figure == verticalCells[2]?.player?.figure
    }
}