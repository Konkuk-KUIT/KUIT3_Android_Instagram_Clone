package com.example.cloneinstagram.profile.followers.vpFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloneinstagram.R
import com.example.cloneinstagram.databinding.FragmentSubscribeBinding
import com.example.cloneinstagram.profile.followers.FollowerData
import com.example.cloneinstagram.profile.followers.adapter.SubscribeAdapter

class SubscribeFragment : Fragment() {
    lateinit var binding : FragmentSubscribeBinding
    private val subscribeList = arrayListOf<FollowerData>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSubscribeBinding.inflate(inflater, container, false)

        initData()
        binding.rvSubscribe.adapter = SubscribeAdapter(subscribeList)

        return binding.root
    }

    private fun initData() {
        for (i in 1..10)
            subscribeList.add(
                FollowerData(R.drawable.img_sample, "쿠잇2", "kuit2.official")
            )
    }
}