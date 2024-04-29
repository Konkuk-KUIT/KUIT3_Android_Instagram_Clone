package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.cloneinstagram.databinding.FragmentIdBinding
import com.google.android.material.tabs.TabLayoutMediator

class IdFragment : Fragment() {
    lateinit var binding : FragmentIdBinding
    lateinit var datas : PostData
    private val tabIcons = arrayListOf(R.drawable.ic_profile_grid, R.drawable.ic_profile_tag)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        datas = arguments?.getSerializable("key") as PostData
        binding = FragmentIdBinding.inflate(inflater, container, false)
        binding.tvProfileName.text = datas.postID
        binding.sivProfileEllipse.setImageResource(datas.postProfile)

        binding.tvProfileFollower.setOnClickListener{
            val replace = parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm, FollowFragment())
                .addToBackStack(null)
                .commit()
        }

        initView()

        return binding.root
    }
    private fun initView(){
        binding.vpProfile.adapter =TabLayoutVPAdapter(this)
        TabLayoutMediator(binding.tlPosts, binding.vpProfile){tab,position ->
            tab.setIcon(tabIcons[position])
        }.attach()
    }

}