package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloneinstagram.databinding.FragmentFollowerBinding
import com.example.cloneinstagram.databinding.FragmentFollowingBinding

class FollowingFragment : Fragment() {

    lateinit var binding : FragmentFollowingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFollowingBinding.inflate(inflater, container, false)

        return binding.root
    }

}