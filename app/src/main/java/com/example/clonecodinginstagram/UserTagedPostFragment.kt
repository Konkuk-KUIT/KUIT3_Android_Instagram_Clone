package com.example.clonecodinginstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clonecodinginstagram.databinding.FragmentUserTagedPostBinding

class UserTagedPostFragment : Fragment() {
    lateinit var binding:FragmentUserTagedPostBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserTagedPostBinding.inflate(inflater,container,false)
        return binding.root
    }

}