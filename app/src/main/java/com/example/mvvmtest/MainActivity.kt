package com.example.mvvmtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding;
    lateinit var viewModel: MainViewModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val dao = QuoteDatabase.getDatabse(applicationContext).quoteData();
        val repository = QuoteRepository(dao);
        viewModel = ViewModelProvider(this, ViewModelFactory(repository) ).get(MainViewModel::class.java)

       viewModel.getQuotes().observe(this, {
           binding.txtQuoutes.text = it.last().toString();
       })

      binding.btnInsertQuote.setOnClickListener({
          val quote = Quote(0,"Test Quote with mahesh", "Mahesh Mallem")
          viewModel.insertQuote(quote);
      })

    }


}