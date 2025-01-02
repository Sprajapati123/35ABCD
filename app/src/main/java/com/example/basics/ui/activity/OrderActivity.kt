package com.example.basics.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.basics.R
import com.example.basics.adapter.TabAdapter
import com.example.basics.databinding.ActivityOrderBinding
import com.google.android.material.tabs.TabLayoutMediator

class OrderActivity : AppCompatActivity() {
    lateinit var orderBinding: ActivityOrderBinding

    lateinit var adapter: TabAdapter

    //if tab ko header ma text rakne bhaye
    var data = arrayOf("Cancelled order","Delivered Order","Active Order")

    //if tab ko header ma icon rakne bhaye
    var icons = arrayOf(R.drawable.baseline_notifications_24,
        R.drawable.baseline_search_24,
        R.drawable.baseline_person_24)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        orderBinding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(orderBinding.root)

        adapter = TabAdapter(supportFragmentManager,lifecycle)
        orderBinding.viewPager.adapter = adapter

        TabLayoutMediator(orderBinding.tabLayout,orderBinding.viewPager){
           //if text rakne bhaye
//            tabs,position -> tabs.text = data[position]
             //if icon rakne bhaye
            tabs,position -> tabs.icon = resources.
                                        getDrawable(icons[position],null)
        }.attach()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}