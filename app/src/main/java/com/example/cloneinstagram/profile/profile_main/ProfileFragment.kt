package com.example.cloneinstagram.profile.profile_main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.cloneinstagram.R
import com.example.cloneinstagram.home.PostData
import com.example.cloneinstagram.databinding.FragmentProfileBinding
import com.example.cloneinstagram.home.UsersData
import com.example.cloneinstagram.profile.followers.ProfileFollowerListFragment
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
        val usersData = UsersData.Builder()
            .setProfileImage(data.profileImage)
            .setProfileUserId(data.profileUserId)
            .setUserName(data.profileName)
            .build()


        // 프로필 편집 클릭
        binding.tvProfileEditProfile.setOnClickListener {
            val intent = Intent(activity, ProfileEditActivity::class.java)
            intent.putExtra("data", usersData)
            startActivity(intent)
        }

        binding.tvProfileUserId.text = data.profileUserId
        binding.sivProfileProfileImage.setImageResource(data.profileImage)

        initAdapter(usersData) // 어댑터 적용

        /** 팔로워 클릭 **/
        binding.llProfileFollowers.setOnClickListener {
            val profileFollowerListFragment = ProfileFollowerListFragment()
            profileFollowerListFragment.arguments = bundleOf("tab" to 0)

            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm, profileFollowerListFragment)
                .addToBackStack(null)
                .commit()
        }
        /** 팔로잉 클릭 **/
        binding.llProfileFollowings.setOnClickListener{
            val profileFollowerListFragment = ProfileFollowerListFragment()
            profileFollowerListFragment.arguments = bundleOf("tab" to 1)

            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm, profileFollowerListFragment)
                .addToBackStack(null)
                .commit()
        }




        return binding.root
    }

    private fun initAdapter(usersData: UsersData) {
        binding.vpProfilePostTag.adapter = ProfileTLVPAdapter(this, usersData)
        TabLayoutMediator(binding.tlProfilePostTag, binding.vpProfilePostTag) { tab, position ->
            tab.setIcon(tabIcon[position])
        }.attach()
    }

}