package com.example.mvvmtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ProgrammingAdapter : ListAdapter<ProgrammingItem,ProgrammingAdapter.ViewHolder>(DiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_view, parent,false);
        return ViewHolder(view);

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position);
        holder.bind(item);
    }

    class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
     val name = view.findViewById<TextView>(R.id.name);
     val intial = view.findViewById<TextView>(R.id.intial);

        fun bind(item: ProgrammingItem){
            name.text = item.name;
            intial.text = item.intial
        }

    }

    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<ProgrammingItem>(){
        override fun areItemsTheSame(oldItem: ProgrammingItem, newItem: ProgrammingItem): Boolean {
           return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProgrammingItem,
            newItem: ProgrammingItem
        ): Boolean {
            return  oldItem == newItem;
        }

    }

}