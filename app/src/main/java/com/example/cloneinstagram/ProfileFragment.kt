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

    private val tabIcons = arrayListOf(R.drawable.ic_grid, R.drawable.ic_tag)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        val bundle = arguments
        if (bundle != null && bundle.containsKey("key")) {
            val postData = bundle.getSerializable("key") as PostData

            binding.tvProfileId.text = postData.userId
            binding.sivProfileImg.setImageResource(postData.profileImg)
        }

        binding.ivEditProfile.setOnClickListener {
            val intent = Intent(requireActivity(), EditProfileActivity::class.java)
            intent.putExtra("name", binding.tvName.text)
            intent.putExtra("ID", binding.tvProfileId.text)

            if(bundle!=null && bundle.containsKey("key")) {
                val postData = bundle.getSerializable("key") as PostData
                intent.putExtra("profile", postData.profileImg)
            }

            startActivity(intent)
        }

        initView()

        initUsers()

        return binding.root
    }

    private fun initUsers() {
        binding.tvFollower.setOnClickListener {
            val intent = Intent(requireActivity(), TabActivity::class.java)
            intent.putExtra("key", binding.tvProfileId.text)
            intent.putExtra("fragment_index", 0)

            startActivity(intent)
        }

        binding.tvFollowing.setOnClickListener {
            val intent = Intent(requireActivity(), TabActivity::class.java)
            intent.putExtra("key", binding.tvProfileId.text)
            intent.putExtra("fragment_index", 1)

            startActivity(intent)
        }
    }

    private fun initView() {
        binding.vpProfileTab.adapter = ProfileTabLayoutVPAdapter(requireActivity())

        TabLayoutMediator(binding.tlProfile, binding.vpProfileTab) { tab, position ->
            tab.setIcon(tabIcons[position])
        }.attach()
    }
}