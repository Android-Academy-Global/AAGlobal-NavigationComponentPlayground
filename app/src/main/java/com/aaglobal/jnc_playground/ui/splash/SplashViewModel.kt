package com.aaglobal.jnc_playground.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashViewModel : ViewModel() {

    companion object {
        private const val SPLASH_DELAY_IN_MS = 1500L
    }

    private val _isInProgress = MutableLiveData(true)

    val isInProgress: LiveData<Boolean> = _isInProgress


    init {
        // Add special delay for splash screen
        viewModelScope.launch {
            delay(SPLASH_DELAY_IN_MS)
            _isInProgress.value = false
        }
    }

}