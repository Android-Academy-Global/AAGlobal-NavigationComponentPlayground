package com.aaglobal.jnc_playground.di

import android.content.Context
import com.aaglobal.jnc_playground.domain.AuthRepository


/**
 * Singleton for "DI" in our example app
 */
object GlobalDI {

    private lateinit var applicationContext: Context


    fun initWithContext(applicationContext: Context) {
        this.applicationContext = applicationContext
    }

    fun getAuthRepository(): AuthRepository {
        return AuthRepository(applicationContext)
    }

}