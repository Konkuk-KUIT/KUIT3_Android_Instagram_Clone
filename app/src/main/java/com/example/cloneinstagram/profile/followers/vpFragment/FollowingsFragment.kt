package com.example.cloneinstagram.profile.followers.vpFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cloneinstagram.R
import com.example.cloneinstagram.databinding.FragmentFollowingsBinding
import com.example.cloneinstagram.profile.followers.FollowerData
import com.example.cloneinstagram.profile.followers.adapter.FollowerAdapter
import com.example.cloneinstagram.profile.followers.adapter.FollowingAdapter

class FollowingsFragment : Fragment() {
    lateinit var binding : FragmentFollowingsBinding
    private val followingList = arrayListOf<FollowerData>()
    private lateinit var followerAdapter : FollowerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFollowingsBinding.inflate(inflater, container, false)

        initData()
        initRV()

        return binding.root
    }

    private fun initRV() {
        followerAdapter = FollowerAdapter(followingList)
        binding.rvFollowings.adapter = followerAdapter
        binding.tvFollowingsText.text = "abcd"
        binding.rvFollowings.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun initData() {
        for (i in 1..10)
            followingList.add(
                FollowerData(R.drawable.img_sample, "쿠잇1", "kuit1.official")
            )
    }
}