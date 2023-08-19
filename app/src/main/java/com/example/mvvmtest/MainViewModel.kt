package com.example.mvvmtest

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class MainViewModel(val context :Context) :ViewModel() {

  private  var quotesList : Array<Quote> = emptyArray();

  private var index : Int = 0;

  init {
    quotesList  = loadQuotesFromAssert();
  }

  fun getQuote() = quotesList[index];

  fun nextQuote() = quotesList[++index];

  fun previusQuote() = quotesList[++index];
  private fun loadQuotesFromAssert(): Array<Quote> {
     var inputStream = context.assets.open("quotes.json");

    var size : Int = inputStream.available();
    var buffer =ByteArray(size)
    inputStream.read(buffer);
    inputStream.close();

    var json = String(buffer,Charsets.UTF_8)
    var gson = Gson();
    return gson.fromJson(json, Array<Quote>::class.java)
  }

}