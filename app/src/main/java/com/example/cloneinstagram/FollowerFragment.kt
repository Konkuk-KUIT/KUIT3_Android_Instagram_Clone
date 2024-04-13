package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cloneinstagram.databinding.FragmentFollowerBinding
import com.example.cloneinstagram.databinding.FragmentFollowingBinding

class FollowerFragment : Fragment() {
    lateinit var binding: FragmentFollowerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentFollowerBinding.inflate(inflater,container,false)

        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        val followerAdapter= TabFollowAdapter()
        binding.rvFollower.adapter=followerAdapter
        binding.rvFollower.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
    }
}