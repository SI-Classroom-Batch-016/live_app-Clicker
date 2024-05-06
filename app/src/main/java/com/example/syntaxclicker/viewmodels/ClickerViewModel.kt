package com.example.syntaxclicker.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel

class ClickerViewModel : ViewModel() {

    //So könnten die Fragmente die Variable direkt verändern
    //Bei einer sauberen Software Architektur vermeiden wir das
    //    var score = 0

    private var _score = 0
    val score: Int
        get() = _score

    private var _easyMode: Boolean = false
    val easyMode: Boolean
        get() = _easyMode

    fun switchEasyMode(){
        _easyMode = !easyMode
    }


    fun click() {
        if (easyMode) {
            _score += 5
        } else {
            _score++
        }
        Log.d("ViewModel", "Neue Punktzahl: $score")
    }

    fun clickLong() {
        _score += 10
        Log.d("ViewModel", "Neue Punktzahl: $score")
    }
}