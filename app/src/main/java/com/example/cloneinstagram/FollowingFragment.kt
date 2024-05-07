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
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentFollowingBinding.inflate(inflater,container,false)

        initRecyclerView()
        return binding.root
    }
    private fun initRecyclerView() {
        val followingAdapter= TabFollowAdapter()
        binding.rvFollowing.adapter=followingAdapter
        binding.rvFollowing.layoutManager=LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
    }
}