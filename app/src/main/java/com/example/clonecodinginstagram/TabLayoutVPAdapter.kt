package com.example.clonecodinginstagram

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabLayoutVPAdapter(fragment: ProfileScreenFragment):FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int= 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> UserPostFragment()
            else -> UserTagedPostFragment()
        }
    }
}