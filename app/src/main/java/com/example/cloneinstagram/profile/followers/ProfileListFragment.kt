package com.example.cloneinstagram.profile.followers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloneinstagram.databinding.FragmentProfileListBinding
import com.example.cloneinstagram.home.PostData
import com.google.android.material.tabs.TabLayoutMediator

class ProfileListFragment : Fragment() {
    lateinit var binding: FragmentProfileListBinding
    private val tabList = arrayListOf("팔로워", "팔로잉", "구독")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileListBinding.inflate(inflater, container, false)

//        val data = arguments?.getInt("key")
//        if (data != null) {
//            binding.vpFollowersList.setCurrentItem(data, false)
//        }

        initAdapter()

        binding.ivProfileListChevronLeft.setOnClickListener{
            parentFragmentManager.popBackStack()
        }



        return binding.root
    }

    private fun initAdapter() {
        binding.vpFollowersList.adapter = FollowerTLVPAdapter(requireActivity())
        TabLayoutMediator(binding.tlFollowersList, binding.vpFollowersList) { tab, position ->
            tab.text = tabList[position]
        }.attach()
    }
}