package com.example.customviewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel :ViewModel() {
    var counter = MutableLiveData<Int>(0)




    var increaseCounter = {
        counter.value = counter.value?.plus(1)

    }

    var decreaseCounter = {
        Log.i("MainScreen", "Counter Value is: ${counter}")
        counter.value = counter.value?.minus(1)

    }
}