package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cloneinstagram.databinding.FragmentFollowerBinding
import com.example.cloneinstagram.databinding.FragmentFollowingBinding

class FollowingFragment : Fragment() {
    lateinit var binding: FragmentFollowingBinding
    private var itemList : ArrayList<FollowingData> = arrayListOf()
    private var followingAdapter : FollowingAdapter ?= null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFollowingBinding.inflate(layoutInflater, container, false)
        listOf(binding)
        initRecyclerView()
        initData()
        return binding.root
    }

    private fun initData() {
        itemList.addAll(
            arrayListOf(
                FollowingData(R.drawable.img_gromit,"jjuyaaaaaaa_4","정주연"),
                FollowingData(R.drawable.img_gromit,"jjuyaaaaaaa_4","정주연"),
                FollowingData(R.drawable.img_gromit,"jjuyaaaaaaa_4","정주연"),
                FollowingData(R.drawable.img_gromit,"jjuyaaaaaaa_4","정주연"),
                FollowingData(R.drawable.img_gromit,"jjuyaaaaaaa_4","정주연"),
                FollowingData(R.drawable.img_gromit,"jjuyaaaaaaa_4","정주연"),
                FollowingData(R.drawable.img_gromit,"jjuyaaaaaaa_4","정주연"),
                FollowingData(R.drawable.img_gromit,"jjuyaaaaaaa_4","정주연"),
                FollowingData(R.drawable.img_gromit,"jjuyaaaaaaa_4","정주연"),
                FollowingData(R.drawable.img_gromit,"jjuyaaaaaaa_4","정주연"),
                FollowingData(R.drawable.img_gromit,"jjuyaaaaaaa_4","정주연"),
                FollowingData(R.drawable.img_gromit,"jjuyaaaaaaa_4","정주연"),
                FollowingData(R.drawable.img_gromit,"jjuyaaaaaaa_4","정주연"),
                FollowingData(R.drawable.img_gromit,"jjuyaaaaaaa_4","정주연"),
                FollowingData(R.drawable.img_gromit,"jjuyaaaaaaa_4","정주연")
            )
        )
    }
    private fun initRecyclerView() {
        var followingAdapter = FollowingAdapter(itemList)
        binding.rvFollowing.adapter = followingAdapter
        binding.rvFollowing.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)

    }
}