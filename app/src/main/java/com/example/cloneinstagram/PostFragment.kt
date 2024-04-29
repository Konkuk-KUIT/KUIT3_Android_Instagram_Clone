package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cloneinstagram.databinding.FragmentPostBinding

class PostFragment : Fragment() {

    lateinit var binding : FragmentPostBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostBinding.inflate(inflater, container, false)

        initPostPicture()

        return binding.root
    }

    private fun initPostPicture() {
        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2021/09/28/13/14/cat-6664412_1280.jpg")
            .into(binding.ivPost1)
        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2020/04/27/09/21/cat-5098930_1280.jpg")
            .into(binding.ivPost2)
        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2021/09/02/16/48/cat-6593947_1280.jpg")
            .into(binding.ivPost3)
        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2018/07/13/10/20/kittens-3535404_1280.jpg")
            .into(binding.ivPost4)
        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2016/12/30/12/16/cat-1940487_1280.jpg")
            .into(binding.ivPost5)
        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2016/12/18/18/42/kittens-1916542_1280.jpg")
            .into(binding.ivPost6)

    }

}