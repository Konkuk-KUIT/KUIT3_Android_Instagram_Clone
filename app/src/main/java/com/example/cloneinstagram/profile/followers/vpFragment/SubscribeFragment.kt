package com.example.cloneinstagram.profile.followers.vpFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cloneinstagram.R
import com.example.cloneinstagram.databinding.FragmentSubscribeBinding
import com.example.cloneinstagram.profile.followers.FollowerData
import com.example.cloneinstagram.profile.followers.adapter.SubscribeAdapter

class SubscribeFragment : Fragment() {
    lateinit var binding : FragmentSubscribeBinding
    private val subscribeList = arrayListOf<FollowerData>()
    private lateinit var subscribeAdapter: SubscribeAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSubscribeBinding.inflate(inflater, container, false)

        initData()
        initRV()
        binding.rvSubscribe.adapter = SubscribeAdapter(subscribeList)

        return binding.root
    }

    private fun initRV() {
        subscribeAdapter = SubscribeAdapter(subscribeList)
        binding.rvSubscribe.adapter = subscribeAdapter
        binding.tvSubscribeText.text = "구독"
        binding.rvSubscribe.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
    private fun initData() {
        for (i in 1..10)
            subscribeList.add(
                FollowerData(R.drawable.img_sample, "쿠잇2", "kuit2.official")
            )
    }
}