package com.example.cloneinstagram

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class FwlistVpAdpater(fragment: FollowListFragment):FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int =3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->FollowerFragment()
            1->FollowingFragment()
            else->SubscribeFragment()
        }
    }

}