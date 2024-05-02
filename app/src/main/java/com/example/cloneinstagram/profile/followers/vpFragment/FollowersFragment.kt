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
    /**더미데이터생성**/
    private fun initData() {
        for (i in 1..10){
            followerList.add(
                FollowerData(R.drawable.img_sample, "쿠잇", "kuit.official")
            )}
    }
    /**어댑터설정**/
    private fun initRV() {
        val size = followerList.size
        followerAdapter = FollowerAdapter(followerList)
        binding.rvFollowers.adapter = followerAdapter
        binding.tvFollowersText.text = "$size 팔로워"
        binding.rvFollowers.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
}