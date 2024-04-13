package com.example.clonecodinginstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.clonecodinginstagram.databinding.FragmentUserTagedPostBinding

class UserTagedPostFragment : Fragment() {
    lateinit var binding:FragmentUserTagedPostBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserTagedPostBinding.inflate(inflater,container,false)
        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2021/04/27/18/26/cygnet-6212139_1280.jpg")
            .into(binding.ivPost1)
        binding.ivPost2.setImageResource(R.drawable.img_sample2)
        binding.ivPost3.setImageResource(R.drawable.img_sample2)
        binding.ivPost4.setImageResource(R.drawable.img_sample2)
        binding.ivPost5.setImageResource(R.drawable.img_sample2)
        binding.ivPost6.setImageResource(R.drawable.img_sample2)
        return binding.root
    }

}