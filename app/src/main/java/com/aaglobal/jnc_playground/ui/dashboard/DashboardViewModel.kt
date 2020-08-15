package com.aaglobal.jnc_playground.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    private val _counter = MutableLiveData<Int>().apply {
        value = 0
    }

    val text: LiveData<String> = _text
    val counter: LiveData<Int> = _counter


    fun incCounter() {
        _counter.postValue(_counter.value?.inc())
    }

}