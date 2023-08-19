package com.example.mvvmtest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val factsLiveData = MutableLiveData<String>("this is fact")

   fun updateLiveData(){
       factsLiveData.value = "Another fact";
   }


}