package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloneinstagram.databinding.FragmentFollowerBinding
import com.example.cloneinstagram.databinding.FragmentSubscribeBinding

class SubscribeFragment : Fragment() {

    lateinit var binding : FragmentSubscribeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSubscribeBinding.inflate(inflater, container, false)

        return binding.root
    }

}