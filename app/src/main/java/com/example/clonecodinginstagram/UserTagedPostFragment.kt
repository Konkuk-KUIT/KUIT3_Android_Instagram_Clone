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
        Glide.with(requireContext())
            .load("https://cdn.pixabay.com/photo/2024/02/17/16/08/ai-generated-8579697_1280.jpg")
            .centerCrop()
            .override(400,400)
            .into(binding.ivPost1)
        Glide.with(requireContext())
            .load("https://cdn.pixabay.com/photo/2024/03/09/07/14/wild-duck-8622063_1280.jpg")
            .centerCrop()
            .override(400,400)
            .into(binding.ivPost2)
        Glide.with(requireContext())
            .load("https://cdn.pixabay.com/photo/2023/09/04/10/12/bird-8232427_1280.jpg")
            .centerCrop()
            .override(400,400)
            .into(binding.ivPost3)
        Glide.with(requireContext())
            .load("https://cdn.pixabay.com/photo/2023/07/11/13/03/dachshund-8120554_1280.jpg")
            .centerCrop()
            .override(400,400)
            .into(binding.ivPost4)
        Glide.with(requireContext())
            .load("https://cdn.pixabay.com/photo/2024/02/16/19/22/green-parrot-8578205_1280.jpg")
            .centerCrop()
            .override(400,400)
            .into(binding.ivPost5)
        Glide.with(requireContext())
            .load("https://cdn.pixabay.com/photo/2024/01/15/06/40/mallard-8509487_1280.jpg")
            .centerCrop()
            .override(400,400)
            .into(binding.ivPost6)
        return binding.root
    }

}