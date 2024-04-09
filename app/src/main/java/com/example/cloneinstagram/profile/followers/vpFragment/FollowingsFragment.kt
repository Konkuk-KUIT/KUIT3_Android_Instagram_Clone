package com.example.cloneinstagram.profile.followers.vpFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloneinstagram.R
import com.example.cloneinstagram.databinding.FragmentFollowingsBinding
import com.example.cloneinstagram.profile.followers.FollowerData
import com.example.cloneinstagram.profile.followers.adapter.FollowingAdapter

class FollowingsFragment : Fragment() {
    lateinit var binding : FragmentFollowingsBinding
    private val followingList = arrayListOf<FollowerData>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFollowingsBinding.inflate(inflater, container, false)

        initData()
        binding.rvFollowings.adapter = FollowingAdapter(followingList)

        return binding.root
    }

    private fun initData() {
        for (i in 1..10)
            followingList.add(
                FollowerData(R.drawable.img_sample, "쿠잇1", "kuit1.official")
            )
    }
}