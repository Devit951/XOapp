package com.github.devit951.xoapp.xogame

import android.app.AlertDialog
import com.github.devit951.xoapp.R
import com.github.devit951.xoapp.board.Board

class XOGame(xoView: XOView){

    private lateinit var board: Board

    init {
        val context = xoView.context
        board =  Board(xoView) { message ->
            AlertDialog.Builder(context)
                    .setTitle(message)
                    .setPositiveButton(context.getString(R.string.new_game)) { dialog, which ->
                        board.invalidate()
                    }
                    .setCancelable(false)
                    .show()
        }
    }
}