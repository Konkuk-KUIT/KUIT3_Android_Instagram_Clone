package com.example.cloneinstagram.profile.followers

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cloneinstagram.profile.followers.vpFragment.FollowersFragment
import com.example.cloneinstagram.profile.followers.vpFragment.FollowingsFragment
import com.example.cloneinstagram.profile.followers.vpFragment.SubscribeFragment

class FollowerTLVPAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity){
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0-> FollowersFragment()
            1-> FollowingsFragment()
            else-> SubscribeFragment()
        }
    }

}