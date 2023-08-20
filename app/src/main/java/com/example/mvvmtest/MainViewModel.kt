package com.example.mvvmtest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val quoteLivedata = MutableLiveData<String>("Intial Data")

    fun updateLiveData(){
        quoteLivedata.value = "After Update";
    }

}