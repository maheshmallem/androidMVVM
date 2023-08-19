package com.example.mvvmtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel;
   private val txtFacts: TextView
        get()= findViewById(R.id.txt_facts);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Intilize view model

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java);

        mainViewModel.factsLiveData.observe(this) {
            txtFacts.text = it
        }
    }

    fun onUpdate(view: View) {
        mainViewModel.updateLiveData();
    }

}