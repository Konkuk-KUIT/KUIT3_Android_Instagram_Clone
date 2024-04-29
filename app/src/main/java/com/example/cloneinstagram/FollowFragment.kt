package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloneinstagram.databinding.FragmentFollowBinding
import com.google.android.material.tabs.TabLayoutMediator

class FollowFragment : Fragment() {
    lateinit var binding:FragmentFollowBinding
    private val tabList = arrayListOf("팔로워", "팔로잉", "구독")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFollowBinding.inflate(layoutInflater,container, false)

        initView()
        return binding.root
    }


    private fun initView(){
        binding.vpFollow.adapter = FollowTabLayoutVPAdapter(this)
        TabLayoutMediator(binding.tlFollow, binding.vpFollow){tab,position ->
            tab.text = tabList[position]
        }.attach()
    }
}