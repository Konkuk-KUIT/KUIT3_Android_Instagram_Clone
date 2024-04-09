package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cloneinstagram.databinding.FragmentViewPagerFollowerBinding

class ViewPagerFollowerFragment : Fragment() {

    lateinit var binding : FragmentViewPagerFollowerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewPagerFollowerBinding.inflate(inflater, container, false)

        binding.rvFollower.adapter = FollowAdapter()
        binding.rvFollower.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)

        return binding.root
    }


}