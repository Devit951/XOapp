package com.github.devit951.xoapp

import android.app.AlertDialog

class XOGame(xoView: XOView){

    init {
        val context = xoView.context
        Board(xoView){ message, board ->
            AlertDialog.Builder(context)
                    .setTitle(message)
                    .setPositiveButton(context.getString(R.string.new_game)){ dialog, which ->
                        board.invalidate()
                    }
                    .setCancelable(false)
                    .show()
        }
    }
}