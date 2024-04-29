package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cloneinstagram.databinding.FragmentFollowerBinding


class FollowerFragment : Fragment() {

    lateinit var binding: FragmentFollowerBinding
    private var itemList : ArrayList<FollowerData> = arrayListOf()
    private var followerAdapter : FollowerAdapter ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFollowerBinding.inflate(layoutInflater, container, false)
        listOf(binding)
        initRecyclerView()
        initData()
        return binding.root
    }
    private fun initData() {
        itemList.addAll(
            arrayListOf(
                FollowerData(R.drawable.img_cloud,"jjuyaaaaaaa_4","정주연"),
                FollowerData(R.drawable.img_cloud,"jjuyaaaaaaa_4","정주연"),
                FollowerData(R.drawable.img_cloud,"jjuyaaaaaaa_4","정주연"),
                FollowerData(R.drawable.img_cloud,"jjuyaaaaaaa_4","정주연"),
                FollowerData(R.drawable.img_cloud,"jjuyaaaaaaa_4","정주연"),
                FollowerData(R.drawable.img_cloud,"jjuyaaaaaaa_4","정주연"),
                FollowerData(R.drawable.img_cloud,"jjuyaaaaaaa_4","정주연"),
                FollowerData(R.drawable.img_cloud,"jjuyaaaaaaa_4","정주연"),
                FollowerData(R.drawable.img_cloud,"jjuyaaaaaaa_4","정주연"),
                FollowerData(R.drawable.img_cloud,"jjuyaaaaaaa_4","정주연"),
                FollowerData(R.drawable.img_cloud,"jjuyaaaaaaa_4","정주연"),
                FollowerData(R.drawable.img_cloud,"jjuyaaaaaaa_4","정주연"),
                FollowerData(R.drawable.img_cloud,"jjuyaaaaaaa_4","정주연"),
                FollowerData(R.drawable.img_cloud,"jjuyaaaaaaa_4","정주연"),
                FollowerData(R.drawable.img_cloud,"jjuyaaaaaaa_4","정주연")
                )
        )
    }
    private fun initRecyclerView() {
        var followerAdapter = FollowerAdapter(itemList)
        binding.rvFollower.adapter = followerAdapter
        binding.rvFollower.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)

    }

}