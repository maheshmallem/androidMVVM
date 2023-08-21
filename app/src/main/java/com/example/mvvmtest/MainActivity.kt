package com.example.mvvmtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rcv_quotes);
        val adapter = ProgrammingAdapter();

        val p1 = ProgrammingItem(1, "J", "JAVA");
        val p2 = ProgrammingItem(2, "K", "KOTLIN");
        val p3 = ProgrammingItem(3, "A", "ANDROID");

        adapter.submitList(listOf(p1, p2, p3))
        recyclerView.layoutManager = LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.adapter = adapter;


        Handler(Looper.getMainLooper()).postDelayed({
            val p3 = ProgrammingItem(3, "A", "ANDROID");
            val p4 = ProgrammingItem(4, "R", "RUST");
            val p5 = ProgrammingItem(5, "G", "GO LANG");
            val p6 = ProgrammingItem(6, "N", "NODE");

            adapter.submitList(listOf(p3,p4,p5,p6))

        },4000)

    }


}