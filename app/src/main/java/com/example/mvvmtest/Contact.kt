package com.example.mvvmtest

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

//import java.sql.Date


@Entity("contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val name:String,
    val phone:String,
    val createdDate : Date,
    val isActive :Int
)
