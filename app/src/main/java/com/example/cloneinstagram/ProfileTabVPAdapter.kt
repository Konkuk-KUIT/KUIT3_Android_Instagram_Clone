package com.example.cloneinstagram

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ProfileTabVPAdapter(fragment: ProfileFragment):FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int =2
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->GridFragment()
            else -> TagFragment()
        }
    }
}