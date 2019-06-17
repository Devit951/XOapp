package com.github.devit951.xoapp.xogame

import android.app.Activity
import android.os.Bundle

class XOActivity: Activity() {

    companion object {
        const val ARG_MOVEABLE_PLAYERS = "ARG_MOVEABLE_PLAYERS"
    }

    private val players: List<Moveable>
        get() = intent.getSerializableExtra(ARG_MOVEABLE_PLAYERS) as List<Moveable>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(XOView(this).apply {
            startGame(players)
        })
    }
}