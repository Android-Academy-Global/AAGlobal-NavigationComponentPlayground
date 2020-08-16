package com.aaglobal.jnc_playground.domain

import android.content.Context


/**
 * Simple repository for holding "hasAuthData" flag
 */
class AuthRepository(applicationContext: Context) {

    companion object {
        private const val PREFS_AUTH_NAME = "auth_prefs"

        private const val PREFS_HAS_AUTH_DATA = "${PREFS_AUTH_NAME}.has_auth_data"
    }


    private val sharedPrefs by lazy {
        applicationContext.getSharedPreferences(PREFS_AUTH_NAME, Context.MODE_PRIVATE)
    }


    fun putHasAuthData(hasAuthData: Boolean) {
        sharedPrefs.edit()
            .putBoolean(PREFS_HAS_AUTH_DATA, hasAuthData)
            .apply()
    }

    fun hasAuthData(): Boolean = sharedPrefs.getBoolean(PREFS_HAS_AUTH_DATA, false)

}