package com.example.mvvmtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   lateinit var binding :ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        var quoteObj = Quote("Iam King when i want","Mahesh Mallem")
        binding.quote = quoteObj;

    }


}