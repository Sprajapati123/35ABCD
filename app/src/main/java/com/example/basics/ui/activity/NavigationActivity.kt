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
import com.example.basics.databinding.ActivityNavigationBinding
import com.example.basics.ui.fragment.HomeFragment
import com.example.basics.ui.fragment.NotificationFragment
import com.example.basics.ui.fragment.ProfileFragment
import com.example.basics.ui.fragment.SearchFragment

class NavigationActivity : AppCompatActivity() {
    lateinit var binding: ActivityNavigationBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeFragment())

        binding.bottomView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navHome -> replaceFragment(HomeFragment())
                R.id.navSearch -> replaceFragment(SearchFragment())
                R.id.navNotification -> replaceFragment(NotificationFragment())
                R.id.navProfile -> replaceFragment(ProfileFragment())
                else -> {}
            }
            true
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager =
            supportFragmentManager
        val fragmentTransaction: FragmentTransaction =
            fragmentManager.beginTransaction()
        fragmentTransaction.replace(
            binding.frameBottom.id,
            fragment
        )
        fragmentTransaction.commit()
    }
}