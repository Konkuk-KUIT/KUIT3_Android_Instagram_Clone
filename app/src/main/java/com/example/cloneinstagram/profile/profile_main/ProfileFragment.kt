package com.example.cloneinstagram.profile.profile_main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.cloneinstagram.R
import com.example.cloneinstagram.home.PostData
import com.example.cloneinstagram.databinding.FragmentProfileBinding
import com.example.cloneinstagram.profile.followers.ProfileListFragment
import com.example.cloneinstagram.profile.followers.vpFragment.FollowersFragment
import com.google.android.material.tabs.TabLayoutMediator

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    private val tabIcon = arrayListOf(R.drawable.ic_grid, R.drawable.ic_tag)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        /** 프로필 userId, 프사, 이름 설정 **/
        val data = arguments?.getSerializable("data") as PostData


        binding.tvProfileUserId.text = data.profileUserId
        binding.sivProfileProfileImage.setImageResource(data.profileImage)

        initAdapter() // 어댑터 적용

        /** 팔로워 클릭 **/
        /** fragment 의 arguments 로 보낸 정수형 데이트를 통해 탭의 위치를 조정함. **/
        binding.llProfileFollowers.setOnClickListener {
            val profileListFragment = ProfileListFragment()
            profileListFragment.arguments = bundleOf("tab" to 0)

            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm, profileListFragment)
                .addToBackStack(null)
                .commit()
        }
        /** 팔로잉 클릭 **/
        binding.llProfileFollowings.setOnClickListener{
            val profileListFragment = ProfileListFragment()
            profileListFragment.arguments = bundleOf("tab" to 1)

            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm, profileListFragment)
                .addToBackStack(null)
                .commit()
        }


        return binding.root
    }

    private fun initAdapter() {
        binding.vpProfilePostTag.adapter = ProfileTLVPAdapter(this)
        TabLayoutMediator(binding.tlProfilePostTag, binding.vpProfilePostTag) { tab, position ->
            tab.setIcon(tabIcon[position])
        }.attach()
    }

}