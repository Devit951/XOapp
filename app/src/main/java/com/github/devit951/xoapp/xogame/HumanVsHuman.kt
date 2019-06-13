package com.github.devit951.xoapp.xogame

class HumanVsHuman(private val firstPlayer: Player, private val secondPlayer: Player){
    fun players(): List<Player> = listOf(firstPlayer, secondPlayer)
}