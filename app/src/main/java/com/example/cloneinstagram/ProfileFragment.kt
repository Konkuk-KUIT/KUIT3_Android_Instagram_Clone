package com.example.cloneinstagram

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.cloneinstagram.R
import com.example.cloneinstagram.databinding.FragmentProfileBinding
import com.google.android.material.tabs.TabLayoutMediator

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    private val tabList= arrayListOf(R.drawable.ic_grid,R.drawable.ic_tag)
    private lateinit var dataList:ArrayList<PostData>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        val imageView: ImageView = binding.ivProfileImg
        imageView.setImageResource(R.drawable.img_sample)

        val profileData=arguments?.getSerializable("nameKey") as? PostData
        binding.tvProfileId.text=profileData?.postId
        binding.ivProfileImg.setImageResource(profileData!!.profileImgId)

        binding.vpProfile.adapter=ProfileTabVPAdapter(this)
        TabLayoutMediator(binding.tlGridTagTab,binding.vpProfile){ tab,position->
            tab.setIcon(tabList[position])
        }.attach()

        binding.tvFollower.setOnClickListener {
            val fragment=FollowListFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm,fragment)
                .commit()
            parentFragmentManager.executePendingTransactions()
            fragment.binding.tlFwList.getTabAt(0)?.select()

        }

        binding.tvFollowing.setOnClickListener {
            val fragment=FollowListFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm,fragment)
                .commit()
            parentFragmentManager.executePendingTransactions()
            fragment.binding.tlFwList.getTabAt(1)?.select()
        }

        binding.ivProfileBtn1.setOnClickListener {
            val fragment=ProfileEditFragment()
            val bundle=Bundle()
            bundle.putSerializable("profileData",profileData)
            fragment.arguments=bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm,fragment)
                .commit()
        }



        return binding.root
    }
}