package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cloneinstagram.databinding.FragmentViewPagerTagBinding

class ViewPagerTagFragment : Fragment() {

    lateinit var binding : FragmentViewPagerTagBinding

    override fun onCreateView(
        layout : LayoutInflater,
        container : ViewGroup?,
        savedInstanceState: Bundle?) :View{
        super.onCreate(savedInstanceState)

        binding = FragmentViewPagerTagBinding.inflate(layout, container, false)

        context?.let {
            Glide.with(it)
                .load("https://cdn.pixabay.com/photo/2023/08/25/07/37/shoes-8212405_1280.jpg")
                .into(binding.iv11)
            Glide.with(it)
                .load("https://cdn.pixabay.com/photo/2023/06/05/02/01/starry-sky-8041247_1280.jpg")
                .into(binding.iv12)
            Glide.with(it)
                .load("https://cdn.pixabay.com/photo/2024/01/20/07/51/ai-generated-8520530_1280.png")
                .into(binding.iv13)
            Glide.with(it)
                .load("https://cdn.pixabay.com/photo/2024/02/10/02/46/fitness-8564036_1280.jpg")
                .into(binding.iv14)
        }



        return binding.root
    }
}