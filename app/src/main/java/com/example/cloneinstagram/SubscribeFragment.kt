package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cloneinstagram.databinding.FragmentSubscribeBinding


class SubscribeFragment : Fragment() {
    lateinit var binding: FragmentSubscribeBinding
    private var itemList : ArrayList<SubscribeData> = arrayListOf()
    private var subscribeAdapter : SubscribeAdapter ?= null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSubscribeBinding.inflate(layoutInflater, container, false)
        listOf(binding)
        initRecyclerView()
        initData()
        return binding.root
    }

    private fun initData() {
        itemList.addAll(
            arrayListOf(
                SubscribeData(R.drawable.img_cloud4,"jjuyaaaaaaa_4","정주연"),
                SubscribeData(R.drawable.img_cloud4,"jjuyaaaaaaa_4","정주연"),
                SubscribeData(R.drawable.img_cloud4,"jjuyaaaaaaa_4","정주연"),
                SubscribeData(R.drawable.img_cloud4,"jjuyaaaaaaa_4","정주연"),
                SubscribeData(R.drawable.img_cloud4,"jjuyaaaaaaa_4","정주연"),
                SubscribeData(R.drawable.img_cloud4,"jjuyaaaaaaa_4","정주연"),
                SubscribeData(R.drawable.img_cloud4,"jjuyaaaaaaa_4","정주연"),
                SubscribeData(R.drawable.img_cloud4,"jjuyaaaaaaa_4","정주연")


            )
        )
    }
    private fun initRecyclerView() {
        var subscribeAdapter = SubscribeAdapter(itemList)
        binding.rvSubscribe.adapter = subscribeAdapter
        binding.rvSubscribe.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)

    }



}