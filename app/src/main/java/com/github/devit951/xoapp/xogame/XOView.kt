package com.github.devit951.xoapp.xogame

import android.content.Context
import android.util.AttributeSet
import android.widget.GridLayout

class XOView(context: Context, attributeSet: AttributeSet? = null, defAttr: Int = 0): GridLayout(context, attributeSet, defAttr) {

    var onPlayerMoved: ((Player) -> Unit)? = null

    fun startGame(players: List<Moveable>){
        XOGame(this, players).onPlayerMoved = onPlayerMoved
    }
}