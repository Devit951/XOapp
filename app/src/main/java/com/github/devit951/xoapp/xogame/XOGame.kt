package com.github.devit951.xoapp.xogame

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.github.devit951.xoapp.R
import com.github.devit951.xoapp.board.Board

class XOGame(xoView: XOView, players: List<Moveable>){

    private lateinit var board: Board

    init {
        val context = xoView.context
        board =  Board(xoView, players) { message ->
            AlertDialog.Builder(context)
                    .setMessage(message)
                    .setPositiveButton(context.getString(R.string.new_game)) { dialog, which ->
                        board.invalidate()
                    }
                    .setCancelable(false)
                    .create().apply {
                        window!!.setBackgroundDrawable(ColorDrawable(Color.WHITE).apply { alpha = 10 })
                        show()
                    }
        }
    }
}