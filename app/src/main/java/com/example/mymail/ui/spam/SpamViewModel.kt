package com.example.mymail.ui.trash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SpamViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is spam"
    }
    val text: LiveData<String> = _text
}