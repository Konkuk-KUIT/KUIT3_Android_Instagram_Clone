package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cloneinstagram.databinding.FragmentTagBinding

class TagFragment : Fragment() {
    lateinit var binding: FragmentTagBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentTagBinding.inflate(inflater,container,false)

        Glide.with(this).load("https://cdn.pixabay.com/photo/2019/08/07/14/11/dog-4390885_960_720.jpg").centerCrop().into(binding.ivTag1)
        Glide.with(this).load("https://cdn.pixabay.com/photo/2016/02/18/18/37/puppy-1207816_640.jpg").centerCrop().into(binding.ivTag2)
        Glide.with(this).load("https://cdn.pixabay.com/photo/2019/07/30/05/53/dog-4372036_1280.jpg").centerCrop().into(binding.ivTag3)
        Glide.with(this).load("https://cdn.pixabay.com/photo/2016/01/05/17/51/maltese-1123016_1280.jpg").centerCrop().into(binding.ivTag4)
        Glide.with(this).load("https://cdn.pixabay.com/photo/2018/05/26/18/06/dog-3431913_640.jpg").centerCrop().into(binding.ivTag5)
        Glide.with(this).load("https://cdn.pixabay.com/photo/2022/01/17/19/59/dog-6945696_1280.jpg").centerCrop().into(binding.ivTag6)

        return binding.root
    }
}