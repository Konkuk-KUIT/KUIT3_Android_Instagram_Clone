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
            .override(400,400)
            .into(binding.ivPost1)
        Glide.with(requireContext())
            .load("https://cdn.pixabay.com/photo/2016/10/26/22/02/dog-1772759_1280.jpg")
            .centerCrop()
            .override(400,400)
            .into(binding.ivPost2)
        Glide.with(requireContext())
            .load("https://cdn.pixabay.com/photo/2022/09/02/19/55/crystal-7428278_1280.jpg")
            .centerCrop()
            .override(400,400)
            .into(binding.ivPost3)
        Glide.with(requireContext())
            .load("https://cdn.pixabay.com/photo/2020/04/12/12/29/swans-5034065_1280.jpg")
            .centerCrop()
            .override(400,400)
            .into(binding.ivPost4)
        Glide.with(requireContext())
            .load("https://cdn.pixabay.com/photo/2021/08/27/10/16/cat-6578336_1280.jpg")
            .centerCrop()
            .override(400,400)
            .into(binding.ivPost5)
        Glide.with(requireContext())
            .load("https://cdn.pixabay.com/photo/2024/04/04/03/08/ai-generated-8674235_1280.png")
            .centerCrop()
            .override(400,400)
            .into(binding.ivPost6)


        return binding.root
    }
}