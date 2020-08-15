package com.aaglobal.jnc_playground.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashViewModel : ViewModel() {

    private val _isInProgress = MutableLiveData(true)

    val isInProgress: LiveData<Boolean> = _isInProgress


    init {
        // Add special delay for splash screen
        viewModelScope.launch {
            delay(2000L)
            _isInProgress.value = false
        }
    }

}