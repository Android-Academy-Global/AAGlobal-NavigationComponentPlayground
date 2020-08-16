package com.aaglobal.jnc_playground.ui.dialogs.dialog_a
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ABottomSheetDialogViewModel : ViewModel() {

    private val _counter: MutableLiveData<Int> = MutableLiveData(0)

    val counter: LiveData<Int> = _counter


    fun increaseCounter() {
        _counter.postValue(_counter.value?.inc())
    }

}