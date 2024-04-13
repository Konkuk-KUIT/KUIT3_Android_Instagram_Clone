package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloneinstagram.databinding.FragmentFollowListBinding
import com.google.android.material.tabs.TabLayoutMediator

class FollowListFragment : Fragment() {
    lateinit var binding: FragmentFollowListBinding
    private val tabList= arrayListOf("팔로워","팔로잉","구독")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentFollowListBinding.inflate(inflater,container,false)
        initView()
        return binding.root
    }

    private fun initView() {
        binding.vpFwList.adapter=FwlistVpAdpater(this)
        TabLayoutMediator(binding.tlFwList,binding.vpFwList){tab,position->
            tab.text=tabList[position]
        }.attach()
    }
}