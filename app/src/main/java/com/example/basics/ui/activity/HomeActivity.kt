package com.example.basics.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.basics.R
import com.example.basics.databinding.ActivityHomeBinding
import com.example.basics.ui.fragment.FirstFragment
import com.example.basics.ui.fragment.SecondFragment

class HomeActivity : AppCompatActivity() {
    lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(FirstFragment())
        binding.btnFirst.setOnClickListener {
            replaceFragment(FirstFragment())
        }

        binding.btnSecond.setOnClickListener {
          replaceFragment(SecondFragment())
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager : FragmentManager =
            supportFragmentManager
        val fragmentTransaction : FragmentTransaction =
            fragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.frameLayout.id,
            fragment)
        fragmentTransaction.commit()
    }
}