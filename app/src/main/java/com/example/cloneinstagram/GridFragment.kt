package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cloneinstagram.databinding.FragmentGridBinding


class GridFragment : Fragment() {
    lateinit var binding:FragmentGridBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGridBinding.inflate(inflater, container, false)


        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2016/12/13/05/15/puppy-1903313_1280.jpg")
            .error(R.drawable.img_cloud4)
            .into(binding.ivGridImg1)

        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2016/02/18/18/37/puppy-1207816_1280.jpg")
            .error(R.drawable.img_cloud4)
            .into(binding.ivGridImg2)

        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2016/01/05/17/51/maltese-1123016_1280.jpg")
            .error(R.drawable.img_cloud4)
            .into(binding.ivGridImg3)

        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2018/05/11/08/11/dog-3389729_1280.jpg")
            .error(R.drawable.img_cloud4)
            .into(binding.ivGridImg4)

        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2020/11/08/10/25/dog-5723334_1280.jpg")
            .error(R.drawable.img_cloud4)
            .into(binding.ivGridImg5)
        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2019/11/07/08/40/puppy-4608266_1280.jpg")
            .error(R.drawable.img_cloud4)
            .into(binding.ivGridImg6)

        return binding.root
    }

}