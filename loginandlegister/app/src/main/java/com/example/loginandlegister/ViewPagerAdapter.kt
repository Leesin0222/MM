package com.example.loginandlegister

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 6
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                ActionFragment()
            }
            1->{
                HorrorFragment()
            }
            2->{
                RomanceFragment()
            }
            3->{
                SportsFragment()
            }
            4->{
                CreditFragment()
            }
            5->{
                OutFragment()
            }
            else->{
                Fragment()
            }
        }
    }
}