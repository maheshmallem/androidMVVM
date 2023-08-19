package com.example.mvvmtest

import Observer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var incrementValue :Int = 0;
    lateinit var txtContent :TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtContent = findViewById(R.id.txt_content);

        // Add observer for activity life cycle
        lifecycle.addObserver(Observer());
    }
    fun increment(view:View){
        incrementValue ++;
        settext();
    }
    fun  settext() {
       txtContent.text = incrementValue.toString();
    }
}