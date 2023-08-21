package com.example.mvvmtest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDAO {

    // Suspend will work on background
    @Insert
    suspend fun insertContact(contact: Contact);

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)


    // live data default background works
    @Query("SELECT * FROM contact")
    fun getContacts(): LiveData<List<Contact>>

}