package com.example.cloneinstagram

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class FollowTabLayoutVPAdapter(fragment: FollowFragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> FollowerFragment()
            1 -> FollowingFragment()
            else -> SubscribeFragment()
        }
    }

}