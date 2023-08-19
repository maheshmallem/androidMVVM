package com.example.mvvmtest

import Observer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var txtContent: TextView;
    lateinit var mainViewModel: MainViewModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Add observer for activity life cycle
        lifecycle.addObserver(Observer());
        // intilize view-model
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(12)).get(MainViewModel::class.java)

        txtContent = findViewById(R.id.txt_content);

        settext()
    }

    fun settext() {
        txtContent.text = mainViewModel.incrementValue.toString();
    }

    fun increment(view: View) {
        mainViewModel.increment(view);
        settext();
    }
}