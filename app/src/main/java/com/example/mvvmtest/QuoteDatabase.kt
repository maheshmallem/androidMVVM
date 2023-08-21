package com.example.mvvmtest

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {
    abstract fun quoteData(): QuoteDAO

    companion object {
        private var INSTACE: QuoteDatabase? = null;
        fun getDatabse(context: Context): QuoteDatabase {
            if (INSTACE == null) {
                synchronized(this) {
                    INSTACE = Room.databaseBuilder(context, QuoteDatabase::class.java, "quote_database")
                        .createFromAsset("quotes.db")
                        .build();
                }
            }
            return INSTACE!!;
        }
    }
}