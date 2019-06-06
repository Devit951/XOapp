package com.github.devit951.xoapp

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class XOApp: Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}