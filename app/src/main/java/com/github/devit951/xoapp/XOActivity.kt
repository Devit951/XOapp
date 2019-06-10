package com.github.devit951.xoapp

import android.app.Activity
import android.os.Bundle
import com.github.devit951.xoapp.xogame.BotVsHuman
import com.github.devit951.xoapp.xogame.Figure
import com.github.devit951.xoapp.xogame.Player
import com.github.devit951.xoapp.xogame.XOView
import com.github.devit951.xoapp.xogame.bot.EasyBot

class XOActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(XOView(this).apply {
            startGame(listOf(BotVsHuman(Player(name = "SpaceX", figure = Figure.X), EasyBot(Figure.O))))
        })
    }
}