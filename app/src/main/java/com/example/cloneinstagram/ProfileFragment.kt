package com.example.cloneinstagram

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cloneinstagram.databinding.FragmentProfileBinding
import com.google.android.material.tabs.TabLayoutMediator

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    private val tabIcons = arrayListOf(R.drawable.grid, R.drawable.tag)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        
        //HomeFragment로부터 받은 String을 프로필의 이름으로 설정
        val bundle = arguments
        if (bundle != null && bundle.containsKey("key")) {
            // Bundle에서 Serializable 객체를 가져와서 캐스팅
            val homePostData = bundle.getSerializable("key") as HomePostData

            binding.tvEditProfileName.text = homePostData.InstagramID
            binding.sivProfileEdit.setImageResource(homePostData.ProfileImage)
        }

        //TabLayout, ViewPager2 생성
        initView()

        //팔로워 팔로일 버튼 눌렀을 때 클릭 리스너 생성
        initFollowerFollowing()

        return binding.root
    }

    private fun initFollowerFollowing() {
        binding.tvFollower.setOnClickListener {
            val intent = Intent(requireActivity(), FollowerFollowingActivity::class.java)
            intent.putExtra("key", binding.tvEditProfileName.text)
            startActivity(intent)
        }

        binding.tvFollowing.setOnClickListener {
            val intent = Intent(requireActivity(), FollowerFollowingActivity::class.java)
            intent.putExtra("key", binding.tvEditProfileName.text)
            startActivity(intent)
        }
    }

    private fun initView() {
        binding.vpProfile.adapter = PostTabLayoutVPAdapter(this)

        TabLayoutMediator(binding.tlProfile, binding.vpProfile){ tab, position ->
            tab.setIcon(tabIcons[position])
        }.attach()
    }
}