package com.github.devit951.xoapp

import android.app.AlertDialog
import android.content.Context
import android.util.AttributeSet
import android.widget.GridLayout

class XOView(context: Context, attributeSet: AttributeSet? = null, defAttr: Int = 0): GridLayout(context, attributeSet, defAttr) {

    init {
        XOGame(this)
    }
}