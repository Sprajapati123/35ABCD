package com.example.basics.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basics.R

class FruitsAdapter(
    val context: Context,
    val imageList : ArrayList<Int>,
    val nameList : ArrayList<String>,
    val descList : ArrayList<String>,
    ) : RecyclerView.Adapter<FruitsAdapter.FruitsViewHolder>() {
    class FruitsViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){
        val image : ImageView= itemView.findViewById(R.id.fruitsImage)
        val title : TextView = itemView.findViewById(R.id.fruitsName)
        val desc : TextView = itemView.findViewById(R.id.fruitsDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsViewHolder {

    }

    override fun getItemCount(): Int {

    }

    override fun onBindViewHolder(holder: FruitsViewHolder, position: Int) {

    }
}