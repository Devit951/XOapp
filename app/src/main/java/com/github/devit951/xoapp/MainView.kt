package com.github.devit951.xoapp

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.FrameLayout

class MainView(context: Context): FrameLayout(context){

    private val botsInfo = listOf(
            BotInfo(title = context.getString(R.string.easy_bot), titleColor = Color.GREEN, onClick = { context.startActivity<XOActivity>() }),
            BotInfo(title = context.getString(R.string.medium_bot), titleColor = Color.BLUE, onClick = {  }),
            BotInfo(title = context.getString(R.string.hard_bot), titleColor = Color.RED, onClick = {  }))

    init {
        val defaultPadding = 48.dp
        val buttonsFrameLayout = FrameLayout(context).apply {
            layoutParams = FrameLayout.LayoutParams(matchParent, matchParent)
            botsInfo.forEachIndexed{ index, botInfo ->
                addView(button{
                    text = botInfo.title
                    setOnClickListener { botInfo.onClick.invoke() }
                    setTextColor(botInfo.titleColor)
                    layoutParams = FrameLayout.LayoutParams(wrapContent, wrapContent).apply {
                        topMargin = (index * defaultPadding)
                        gravity = Gravity.CENTER
                    }
                })
            }
            setPadding(0, 0, 0, defaultPadding * (botsInfo.size - 1))
        }
        addView(buttonsFrameLayout)
    }


    private fun button(button: Button.() -> Unit): Button{
        return Button(context).apply {
            button(this)
        }
    }

    private class BotInfo(val title: String, val titleColor: Int, val onClick: () -> Unit)
}