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

        initAdapter()
        initVP()

        /** 뒤로가기 버튼 **/
        binding.ivProfileListChevronLeft.setOnClickListener{
            parentFragmentManager.popBackStack()
        }



        return binding.root
    }
    /** 시작될 뷰페이저의 위치 설정, argument의 값이 0-> 팔로워, 1-> 팔로잉 **/
    private fun initVP() {
        val data = arguments?.getInt("tab") as Int
        binding.vpFollowersList.setCurrentItem(data, false)
    }
/** 어댑터 설정 **/
    private fun initAdapter() {
        binding.vpFollowersList.adapter = FollowerTLVPAdapter(requireActivity())
        TabLayoutMediator(binding.tlFollowersList, binding.vpFollowersList) { tab, position ->
            tab.text = tabList[position]
        }.attach()

    }
}