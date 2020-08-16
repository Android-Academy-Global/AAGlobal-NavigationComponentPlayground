package com.aaglobal.jnc_playground.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aaglobal.jnc_playground.core.mvvm.SingleLiveEvent
import com.aaglobal.jnc_playground.di.GlobalDI
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashViewModel : ViewModel() {

    companion object {
        private const val SPLASH_DELAY_IN_MS = 1500L
    }


    private val authRepository = GlobalDI.getAuthRepository()

    private val _splashNavCommand = SingleLiveEvent<SplashNavCommand?>()

    val splashNavCommand: LiveData<SplashNavCommand?> = _splashNavCommand


    init {
        // Add special delay for splash screen
        viewModelScope.launch {
            delay(SPLASH_DELAY_IN_MS)

            val navCommand = if (authRepository.hasAuthData()) {
                SplashNavCommand.NAVIGATE_TO_MAIN
            } else {
                SplashNavCommand.NAVIGATE_TO_AUTH
            }
            _splashNavCommand.postValue(navCommand)
        }
    }

}