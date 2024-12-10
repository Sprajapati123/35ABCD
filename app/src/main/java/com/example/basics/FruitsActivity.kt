package com.example.basics

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class FruitsActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    val imageList = ArrayList<Int>()
    val nameList = ArrayList<String>()
    val descList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fruits)
        recyclerView = findViewById(R.id.recyclerView)

        imageList.add(R.drawable.apple)
        imageList.add(R.drawable.mango)
        imageList.add(R.drawable.grapes)

        nameList.add("Apple")
        nameList.add("Mango")
        nameList.add("Grapes")

        descList.add("This is apple")
        descList.add("This is mango")
        descList.add("This is grapes")





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}