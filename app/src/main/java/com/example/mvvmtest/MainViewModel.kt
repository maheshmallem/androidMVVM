package com.example.mvvmtest

import android.view.View
import androidx.lifecycle.ViewModel

class MainViewModel(val intialValue:Int) :ViewModel() {

    var incrementValue :Int = intialValue;

    fun increment(view: View){
        incrementValue ++;

    }

}