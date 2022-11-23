package com.example.mymail.ui.outbox

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OutboxViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is outbox"
    }
    val text: LiveData<String> = _text
}