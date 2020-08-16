package com.aaglobal.jnc_playground.ui.auth

import androidx.lifecycle.ViewModel
import com.aaglobal.jnc_playground.di.GlobalDI


class FinishAuthViewModel : ViewModel() {

    private val authRepository = GlobalDI.getAuthRepository()


    fun setFinishAuthFlag() {
        authRepository.putHasAuthData(true)
    }

}