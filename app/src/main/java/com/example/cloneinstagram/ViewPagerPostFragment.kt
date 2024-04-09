package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cloneinstagram.databinding.FragmentViewPagerPostBinding

class ViewPagerPostFragment : Fragment() {

    lateinit var binding : FragmentViewPagerPostBinding

    override fun onCreateView(
        inflater:LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?) : View {
        super.onCreate(savedInstanceState)

        binding = FragmentViewPagerPostBinding.inflate(inflater, container, false)

        context?.let {
            Glide.with(it)
                .load("https://cdn.pixabay.com/photo/2014/11/30/14/11/cat-551554_1280.jpg")
                .into(binding.iv1)
            Glide.with(it)
                .load("https://cdn.pixabay.com/photo/2023/06/29/10/33/lion-8096155_1280.png")
                .into(binding.iv2)
            Glide.with(it)
                .load("https://cdn.pixabay.com/photo/2023/07/30/00/12/cat-8157889_1280.png")
                .into(binding.iv3)
            Glide.with(it)
                .load("https://cdn.pixabay.com/photo/2020/04/27/09/21/cat-5098930_1280.jpg")
                .into(binding.iv4)
            Glide.with(it)
                .load("https://cdn.pixabay.com/photo/2021/10/27/19/09/cat-6748193_1280.jpg")
                .into(binding.iv5)
            Glide.with(it)
                .load("https://cdn.pixabay.com/photo/2017/11/09/21/41/cat-2934720_1280.jpg")
                .into(binding.iv6)
        }

        return binding.root
    }

}