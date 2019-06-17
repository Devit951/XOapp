package com.github.devit951.xoapp.xogame

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.github.devit951.xoapp.mainscreen.MainActivity
import com.github.devit951.xoapp.R
import com.github.devit951.xoapp.board.Board
import com.github.devit951.xoapp.extension.intent

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
                    .setNegativeButton(context.getString(R.string.main_menu)){ _, _ ->
                        context.startActivity(context.intent<MainActivity> { flags = Intent.FLAG_ACTIVITY_CLEAR_TOP })
                    }
                    .setCancelable(false)
                    .create().apply {
                        window!!.setBackgroundDrawable(ColorDrawable(Color.WHITE).apply { alpha = 10 })
                        show()
                    }
        }
    }
}