package com.example.mvvmtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val postObj = Post("Intruduction to mvvm", "Introduction to MVVM Architecture Introduction to MVVM Architecture Model-View-ViewModel…", "https://next-studios.blogspot.com/2023/08/mvvm-architecture-in-android.html")
        mainBinding.post = postObj;

    }


}