package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cloneinstagram.databinding.FragmentViewPagerSubscriberBinding

class ViewPagerSubscriberFragment : Fragment() {

    lateinit var binding : FragmentViewPagerSubscriberBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewPagerSubscriberBinding.inflate(inflater, container, false)

        binding.rvSubscriber.adapter = FollowAdapter()
        binding.rvSubscriber.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)

        return binding.root
    }


}