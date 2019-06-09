package com.github.devit951.xoapp

import android.app.Activity
import android.os.Bundle
import com.github.devit951.xoapp.xogame.XOView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(XOView(this))
    }
}
