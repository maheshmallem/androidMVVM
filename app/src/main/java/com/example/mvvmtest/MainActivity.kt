package com.example.mvvmtest

import Observer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {


    lateinit var mainViewModel: MainViewModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Add observer for activity life cycle
        lifecycle.addObserver(Observer());
        // intilize view-model
        mainViewModel = ViewModelProvider(this,MainViewModelFactory()).get(MainViewModel::class.java)


    }


}