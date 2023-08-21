package com.example.mvvmtest

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(private val repository: QuoteRepository) :ViewModel() {

    fun getQuotes(): LiveData<List<Quote>>{
       return repository.getQuotes();
    }

    fun insertQuote(quote: Quote){
        viewModelScope.launch {
            repository.insertQuote(quote)
        }
    }

}