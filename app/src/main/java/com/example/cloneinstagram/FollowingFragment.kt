package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cloneinstagram.databinding.FragmentFollowingBinding

class FollowingFragment : Fragment() {

    lateinit var binding: FragmentFollowingBinding
    private var itemList: ArrayList<UserData> = arrayListOf()
    private var followingAdapter: UserAdapter ?= null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFollowingBinding.inflate(inflater, container, false)

        initData()
        initRecyclerView()


        return binding.root
    }

    private fun initRecyclerView() {
        followingAdapter = UserAdapter(itemList)
        binding.rvFollowing.adapter = followingAdapter
        binding.rvFollowing.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
    }

    private fun initData() {
        itemList.addAll(
            arrayListOf(
                UserData(R.drawable.img_sample, "ri._.nny", "김채린"),
                UserData(R.drawable.img_sample, "ri._.nny", "김채린"),
                UserData(R.drawable.img_sample, "ri._.nny", "김채린"),
                UserData(R.drawable.img_sample, "ri._.nny", "김채린"),
                UserData(R.drawable.img_sample, "ri._.nny", "김채린"),
                UserData(R.drawable.img_sample, "ri._.nny", "김채린"),
                UserData(R.drawable.img_sample, "ri._.nny", "김채린"),
                UserData(R.drawable.img_sample, "ri._.nny", "김채린"),
            )
        )
    }

}