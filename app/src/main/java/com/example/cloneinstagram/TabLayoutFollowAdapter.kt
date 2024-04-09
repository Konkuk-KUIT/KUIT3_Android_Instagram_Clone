package com.example.cloneinstagram

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabLayoutFollowAdapter(activity: FragmentActivity) :FragmentStateAdapter(activity){
    override fun getItemCount(): Int =3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ViewPagerFollowerFragment()
            1 -> ViewPagerFollowingFragment()
            else -> ViewPagerSubscriberFragment()
        }
    }
}