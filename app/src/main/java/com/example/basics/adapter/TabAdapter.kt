package com.example.basics.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.basics.ui.fragment.ActiveFragment
import com.example.basics.ui.fragment.CancelledFragment
import com.example.basics.ui.fragment.DeliveredFragment

class TabAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return CancelledFragment()
            1 -> return DeliveredFragment()
            2 -> return ActiveFragment()
            else -> return CancelledFragment()
        }
    }
}