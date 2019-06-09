package com.github.devit951.xoapp

class DiagonalBoardInterceptor: BoardInterceptor {
    override fun interceptBoard(cells: Array<Array<Cell?>>, board: Board): Boolean {
        if (cells[0][0] != null && cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2]){
            notifyWinnerPlayer(board, board.onBoardAction)
            return true
        }
        if (cells[2][0] != null && cells[2][0] == cells[1][1] && cells[1][1] == cells[0][2]){
            notifyWinnerPlayer(board, board.onBoardAction)
            return true
        }
        return false
    }

    private fun notifyWinnerPlayer(board: Board, onBoardAction: (String, Board) -> Unit){
        val winnerPlayer = board.cells[1][1]
        onBoardAction.invoke(XOApp.context.getString(R.string.the_winner_is, winnerPlayer), board)
    }
}