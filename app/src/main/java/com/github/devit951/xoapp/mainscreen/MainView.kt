package com.github.devit951.xoapp.mainscreen

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.FrameLayout
import com.github.devit951.xoapp.*
import com.github.devit951.xoapp.extension.dp
import com.github.devit951.xoapp.extension.intent
import com.github.devit951.xoapp.extension.matchParent
import com.github.devit951.xoapp.extension.wrapContent
import com.github.devit951.xoapp.xogame.*
import com.github.devit951.xoapp.xogame.bot.EasyBot
import com.github.devit951.xoapp.xogame.gamemode.BotVsBot
import com.github.devit951.xoapp.xogame.gamemode.BotVsHuman
import com.github.devit951.xoapp.xogame.gamemode.HumanVsHuman
import java.io.Serializable

class MainView(context: Context): FrameLayout(context){

    private val gameModes = listOf(
            GameMode(title = context.getString(R.string.easy_bot), titleColor = Color.GREEN, onClick = { context.startActivity(context.intent<XOActivity> { putExtra(XOActivity.ARG_MOVEABLE_PLAYERS, listOf(BotVsHuman(Player(name = "SpaceX", figure = Figure.X), EasyBot(Figure.O))) as Serializable) }) }),
            GameMode(title = context.getString(R.string.medium_bot), titleColor = Color.BLUE, onClick = { }),
            GameMode(title = context.getString(R.string.hard_bot), titleColor = Color.RED, onClick = { }),
            GameMode(title = context.getString(R.string.human_vs_human), titleColor = Color.MAGENTA, onClick = { context.startActivity(context.intent<XOActivity> { putExtra(XOActivity.ARG_MOVEABLE_PLAYERS, HumanVsHuman(Player(name = "xSpace", figure = Figure.X), Player(name = "Vasya202", figure = Figure.O)).players() as Serializable) }) }),
            GameMode(title = context.getString(R.string.bot_vs_bot), titleColor = Color.CYAN, onClick = { context.startActivity(context.intent<XOActivity> { putExtra(XOActivity.ARG_MOVEABLE_PLAYERS, BotVsBot().bots() as Serializable) }) }))

    init {
        addView(XOBackgroundView(context))
        val defaultPadding = 48.dp
        val buttonsFrameLayout = FrameLayout(context).apply {
            layoutParams = FrameLayout.LayoutParams(matchParent, matchParent)
            gameModes.forEachIndexed { index, gameMode ->
                addView(button{
                    text = gameMode.title
                    setOnClickListener { gameMode.onClick.invoke() }
                    setTextColor(gameMode.titleColor)
                    layoutParams = FrameLayout.LayoutParams(wrapContent, wrapContent).apply {
                        topMargin = (index * defaultPadding)
                        gravity = Gravity.CENTER
                    }
                })
            }
            setPadding(0, 0, 0, defaultPadding * (gameModes.size - 1))
        }
        addView(buttonsFrameLayout)
    }


    private fun button(button: Button.() -> Unit): Button{
        return Button(context).apply {
            button(this)
        }
    }

    private class GameMode(val title: String, val titleColor: Int, val onClick: () -> Unit)
}