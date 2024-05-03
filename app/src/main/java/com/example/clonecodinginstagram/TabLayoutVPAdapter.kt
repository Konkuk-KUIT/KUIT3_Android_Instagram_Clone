package com.example.clonecodinginstagram

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.clonecodinginstagram.databinding.FragmentProfileBinding
import com.example.clonecodinginstagram.databinding.FragmentProfileScreenBinding
import com.example.clonecodinginstagram.databinding.FragmentUserPostBinding

class TabLayoutVPAdapter(val fragment: ProfileScreenFragment):FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int= 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> UserPostFragment()
            else -> UserTagedPostFragment()
        }
    }
}