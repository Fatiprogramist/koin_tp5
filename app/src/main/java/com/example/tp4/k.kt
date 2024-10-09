package com.example.tp4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyView: ViewModel() {
    private val _myLiveData = MutableLiveData<String>()
    val myLiveData: LiveData<String> = _myLiveData
    fun updateData(newData: String) {
        _myLiveData.value = newData
    }
}