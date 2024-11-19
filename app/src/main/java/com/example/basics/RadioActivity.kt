package com.example.basics

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RadioActivity : AppCompatActivity() {
    lateinit var radioApple: RadioButton
    lateinit var radioMango: RadioButton
    lateinit var radioGrapes: RadioButton
    lateinit var imageViewRadio: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_radio)

        radioApple = findViewById(R.id.btnApple)
        radioMango = findViewById(R.id.btnMango)
        radioGrapes = findViewById(R.id.btnGrapes)
        imageViewRadio = findViewById(R.id.imageViewRadio)

        radioApple.setOnClickListener {
            imageViewRadio.setImageResource(R.drawable.apple)
        }
        radioGrapes.setOnClickListener {
            imageViewRadio.setImageResource(R.drawable.grapes)
        }
        radioMango.setOnClickListener {
            imageViewRadio.setImageResource(R.drawable.mango)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}