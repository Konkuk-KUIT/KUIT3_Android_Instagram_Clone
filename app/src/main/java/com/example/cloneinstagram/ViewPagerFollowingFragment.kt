package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cloneinstagram.databinding.FragmentViewPagerFollowingBinding

class ViewPagerFollowingFragment : Fragment() {

    lateinit var binding : FragmentViewPagerFollowingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewPagerFollowingBinding.inflate(inflater, container, false)

        binding.rvFollowing.adapter = FollowAdapter()
        binding.rvFollowing.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)

        return binding.root
    }
}