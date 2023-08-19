package com.example.mvvmtest

import android.view.View
import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel() {

    var incrementValue :Int = 0;

    fun increment(view: View){
        incrementValue ++;

    }

}