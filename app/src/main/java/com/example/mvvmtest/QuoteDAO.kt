package com.example.mvvmtest

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface QuoteDAO {

    @Query("SELECT * FROM quote")
    fun getQuotes(): LiveData<List<Quote>>;


    @Insert
    suspend fun insertQuote(quote: Quote);

    @Insert
    suspend fun updateQuote(quote: Quote)

}