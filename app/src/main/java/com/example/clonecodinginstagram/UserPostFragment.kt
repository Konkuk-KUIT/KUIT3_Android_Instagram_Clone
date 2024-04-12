package com.example.clonecodinginstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clonecodinginstagram.databinding.FragmentUserPostBinding

class UserPostFragment : Fragment() {
    lateinit var binding : FragmentUserPostBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserPostBinding.inflate(inflater,container,false)
        binding.ivPost1.setImageResource(R.drawable.img_sample)
        return binding.root
    }
}