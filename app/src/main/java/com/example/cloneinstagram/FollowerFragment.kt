package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cloneinstagram.databinding.FragmentFollowerBinding

class FollowerFragment : Fragment() {

    lateinit var binding : FragmentFollowerBinding
    private var itemList : ArrayList<FollowerData> = arrayListOf()
    private var followerAdapter : FollowerAdapter ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFollowerBinding.inflate(inflater, container, false)

        initData()
        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        followerAdapter = FollowerAdapter(itemList)
        binding.rvFollower.adapter = followerAdapter
        binding.rvFollower.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
    }

    private fun initData() {
        itemList.addAll(
            arrayListOf(
                FollowerData(R.drawable.img_sample, "ri._.nny", "김채린"),
                FollowerData(R.drawable.img_sample, "ri._.nny", "김채린"),
                FollowerData(R.drawable.img_sample, "ri._.nny", "김채린"),
                FollowerData(R.drawable.img_sample, "ri._.nny", "김채린"),
                FollowerData(R.drawable.img_sample, "ri._.nny", "김채린"),
                FollowerData(R.drawable.img_sample, "ri._.nny", "김채린"),
                FollowerData(R.drawable.img_sample, "ri._.nny", "김채린"),
                FollowerData(R.drawable.img_sample, "ri._.nny", "김채린"),
                FollowerData(R.drawable.img_sample, "ri._.nny", "김채린"),
                FollowerData(R.drawable.img_sample, "ri._.nny", "김채린")
            )
        )
    }

}