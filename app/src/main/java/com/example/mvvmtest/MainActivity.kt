package com.example.mvvmtest

import Observer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var txtQuote: TextView;
    lateinit var mainViewModel: MainViewModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Add observer for activity life cycle
        lifecycle.addObserver(Observer());
        txtQuote = findViewById(R.id.txt_quote);
        // intilize view-model
        mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(application)
        ).get(MainViewModel::class.java)
        setText(mainViewModel.getQuote());
    }

    fun onNext(view: View) {
        setText(mainViewModel.nextQuote())
    }

    fun onPrevius(view: View) {
        setText(mainViewModel.previusQuote())
    }

    fun setText(quote: Quote) {
        txtQuote.text = quote.text;
    }

}