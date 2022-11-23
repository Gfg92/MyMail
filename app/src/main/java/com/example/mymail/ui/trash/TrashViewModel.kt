package com.example.mymail.ui.trash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TrashViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is trash"
    }
    val text: LiveData<String> = _text
}