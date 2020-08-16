package com.aaglobal.jnc_playground

import android.app.Application
import com.aaglobal.jnc_playground.di.GlobalDI


class App : Application() {

    override fun onCreate() {
        super.onCreate()

        GlobalDI.initWithContext(this)
    }

}