package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cloneinstagram.databinding.FragmentFollowBinding
import com.google.android.material.tabs.TabLayoutMediator

class FollowFragment : Fragment() {

    lateinit var binding : FragmentFollowBinding
    val tabList = listOf("100팔로워", "100팔로잉", "구독")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFollowBinding.inflate(inflater, container, false)

        binding.vpFollowMainViewPager.adapter = TabLayoutFollowAdapter(requireActivity())

        TabLayoutMediator(binding.tlFollowMainTab, binding.vpFollowMainViewPager){ tab, position ->
            tab.text = tabList[position]
        }.attach()

        return binding.root
    }
}