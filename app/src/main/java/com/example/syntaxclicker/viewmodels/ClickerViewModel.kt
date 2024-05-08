package com.example.syntaxclicker.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ClickerViewModel : ViewModel() {

    private val _score = MutableLiveData<Int>(0)
    val score: LiveData<Int>
        get() = _score

    private val _easyMode = MutableLiveData<Boolean>(false)
    val easyMode: LiveData<Boolean>
        get() = _easyMode


    fun switchEasyMode() {

        _easyMode.value = !easyMode.value!!

//        val inhaltLiveData: Boolean = easyMode.value!!
//        if(inhaltLiveData == true){
//            _easyMode.value = false
//        } else if(inhaltLiveData == false){
//            _easyMode.value = true
//        }
    }

    fun click() {
        if (easyMode.value!!) {
            _score.value = score.value!! + 5
        } else {
            _score.value = score.value!! + 1
        }
        Log.d("ViewModel", "Neue Punktzahl: ${score.value}")
    }

    fun clickLong() {
        _score.value = score.value!! + 10
        Log.d("ViewModel", "Neue Punktzahl: ${score.value}")
    }
}