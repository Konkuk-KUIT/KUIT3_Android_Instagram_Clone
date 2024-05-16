package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cloneinstagram.databinding.FragmentGridBinding
import com.example.cloneinstagram.databinding.FragmentTagBinding


class TagFragment : Fragment() {
    lateinit var binding: FragmentTagBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTagBinding.inflate(inflater, container, false)

        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2020/04/27/09/21/cat-5098930_1280.jpg")
            .error(R.drawable.img_gromit)
            .into(binding.ivTagImg1)
        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2017/04/30/18/33/kittens-2273598_1280.jpg")
            .error(R.drawable.img_gromit)
            .into(binding.ivTagImg2)
        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2022/05/21/09/30/cat-7211080_1280.jpg")
            .error(R.drawable.img_gromit)
            .into(binding.ivTagImg3)
        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2015/06/07/19/42/animal-800760_1280.jpg")
            .error(R.drawable.img_gromit)
            .into(binding.ivTagImg4)
        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2016/03/28/10/05/kitten-1285341_1280.jpg")
            .error(R.drawable.img_gromit)
            .into(binding.ivTagImg5)
        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2021/10/13/11/50/cat-6706393_1280.jpg")
            .error(R.drawable.img_gromit)
            .into(binding.ivTagImg6)
        return binding.root
    }

}