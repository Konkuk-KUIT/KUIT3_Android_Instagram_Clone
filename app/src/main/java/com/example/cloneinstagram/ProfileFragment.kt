package com.example.cloneinstagram

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cloneinstagram.databinding.FragmentProfileBinding
import com.google.android.material.tabs.TabLayoutMediator

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding

    val tabList = listOf(R.drawable.grid, R.drawable.tag)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.tvProfileLogo.text = arguments?.getString("id") ?: "kuit"
        arguments?.let { binding.sivProfileImg.setImageResource(it.getInt("imageId")) }

        //fragment에서 FragmentActivity를 접근하고 싶을 땐 requireActivity() 메서드를 호출하면 된다.
        binding.vpProfileMainViewPager.adapter = TabLayoutProfileAdapter(requireActivity())

        TabLayoutMediator(binding.tlProfileMainTab, binding.vpProfileMainViewPager){ tab, position ->
            tab.setIcon(tabList[position])
        }.attach()

        //팔로워 클릭 시 이동하는 것 구현
        binding.tvProfileNumberOfFollower.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm, FollowFragment())
                .commit()
        }
        binding.tvProfileNumberOfFollowing.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm, FollowFragment())
                .commit()
        }

        return binding.root
    }
}