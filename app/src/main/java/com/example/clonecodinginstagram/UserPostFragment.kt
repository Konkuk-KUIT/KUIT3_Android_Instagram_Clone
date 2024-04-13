package com.example.clonecodinginstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.clonecodinginstagram.databinding.FragmentUserPostBinding

class UserPostFragment : Fragment() {
    lateinit var binding : FragmentUserPostBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserPostBinding.inflate(inflater,container,false)
        Glide.with(requireContext())
            .load("https://cdn.pixabay.com/photo/2021/04/27/18/26/cygnet-6212139_1280.jpg")
            .centerCrop()
            .into(binding.ivPost1)
        Glide.with(requireContext())
            .load("https://cdn.pixabay.com/photo/2016/10/26/22/02/dog-1772759_1280.jpg")
            .centerCrop()
            .into(binding.ivPost2)
        binding.ivPost3.setImageResource(R.drawable.img_sample)
        binding.ivPost4.setImageResource(R.drawable.img_sample)
        binding.ivPost5.setImageResource(R.drawable.img_sample)
        binding.ivPost6.setImageResource(R.drawable.img_sample)

        return binding.root
    }
}