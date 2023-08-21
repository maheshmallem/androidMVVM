package com.example.mvvmtest

import android.icu.util.DateInterval
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.sql.Date


class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = ContactDatabase.getDatabase(this);

        GlobalScope.launch {
            val ct =  Converters();
            database.contactDao().insertContact(Contact(0,"Mahesh","7032214460", java.util.Date() , 1))
        }

    }

    fun getData(view: View){
        database.contactDao().getContacts().observe(this, {
            Log.d("MAHESH", it.toString())
        })

    }


}