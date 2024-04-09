package com.example.cloneinstagram.profile.followers.vpFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.cloneinstagram.R
import com.example.cloneinstagram.databinding.FragmentFollowersBinding
import com.example.cloneinstagram.profile.followers.FollowerData
import com.example.cloneinstagram.profile.followers.adapter.FollowerAdapter

class FollowersFragment : Fragment() {
    lateinit var binding : FragmentFollowersBinding
    private val followerList = arrayListOf<FollowerData>()
    private lateinit var followerAdapter: FollowerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFollowersBinding.inflate(inflater, container, false)

        initData()
        initRV()


        return binding.root
    }
    private fun initData() {
//        for (i in 1..10){
//            followerList.add(
//                FollowerData(R.drawable.img_sample, "쿠잇", "kuit.official")
//            )}
        followerList.addAll(
            arrayListOf(
                FollowerData(
                    R.drawable.img_sample, "kuit1", "kuit1.official"),
                FollowerData(
                    R.drawable.img_sample, "kuit2", "kuit2.official"),
//                FollowerData(
//                    R.drawable.img_sample, "kuit3", "kuit3.official")
            )
        )
    }

    private fun initRV() {
        followerAdapter = FollowerAdapter(followerList)
        binding.rvFollowers.adapter = followerAdapter
        binding.tvFollowersText.text = "abcd"
        binding.rvFollowers.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//        binding.rvFollowers.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
    }
}