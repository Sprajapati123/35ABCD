package com.example.basics

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.basics.databinding.ActivityButtonBinding

class ButtonActivity : AppCompatActivity() {
    lateinit var binding: ActivityButtonBinding
    lateinit var sharedPreference : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreference = getSharedPreferences("user",
            Context.MODE_PRIVATE)

        //button
        binding.btnNavigate.setOnClickListener {
            val username : String = binding.editUsername.text.toString()
            val password : String = binding.editPassword.text.toString()

            if(username.isEmpty()){
                binding.editUsername.error = "Username can't be empty"
            }else if(password.isEmpty()){
                binding.editPassword.error = "Password can't be empty"

            }else{
                if(binding.checkBox.isChecked){
                    val editor = sharedPreference.edit()
                    editor.putString("username",username)
                    editor.putString("password",password)
                    editor.apply()
                }
                var intent = Intent(this@ButtonActivity,
                    DestinationActivity::class.java)
                intent.putExtra("username",username)
                intent.putExtra("password",password)
                startActivity(intent)
            }

        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}