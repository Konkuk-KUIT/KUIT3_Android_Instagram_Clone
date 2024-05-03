package com.example.cloneinstagram.profile.profile_main

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cloneinstagram.home.UsersData

class ProfileTLVPAdapter(fragment: Fragment, usersData: UsersData) : FragmentStateAdapter(fragment) {

    val data = usersData
    override fun getItemCount(): Int = 2
    override fun createFragment(position: Int): Fragment {
        val profilePostFragment = ProfilePostFragment()
        val profileTagFragment = ProfileTagFragment()
        profilePostFragment.arguments = bundleOf("usersData" to data)
        profileTagFragment.arguments = bundleOf("usersData" to data)

        return when(position) {
            0-> profilePostFragment
            else -> profileTagFragment
        }
    }

}