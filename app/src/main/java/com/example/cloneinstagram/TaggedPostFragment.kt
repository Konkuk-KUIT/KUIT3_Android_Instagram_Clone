package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cloneinstagram.databinding.FragmentTaggedPostBinding

class TaggedPostFragment : Fragment() {

    lateinit var binding: FragmentTaggedPostBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaggedPostBinding.inflate(inflater, container, false)

        initTaggedDummyData()

        return binding.root
    }

    private fun initTaggedDummyData() {
        Glide.with(this).load("https://cdn.pixabay.com/photo/2017/07/25/01/22/cat-2536662_1280.jpg").centerCrop().into(binding.ivTaggedPost1)
        Glide.with(this).load("https://cdn.pixabay.com/photo/2019/11/08/11/56/kitten-4611189_1280.jpg").centerCrop().into(binding.ivTaggedPost2)
        Glide.with(this).load("https://cdn.pixabay.com/photo/2017/11/09/21/41/cat-2934720_1280.jpg").centerCrop().into(binding.ivTaggedPost3)
        Glide.with(this).load("https://cdn.pixabay.com/photo/2014/04/13/20/49/cat-323262_1280.jpg").centerCrop().into(binding.ivTaggedPost4)
        Glide.with(this).load("https://cdn.pixabay.com/photo/2023/12/15/21/47/cat-8451431_1280.jpg").centerCrop().into(binding.ivTaggedPost5)
        Glide.with(this).load("https://cdn.pixabay.com/photo/2014/11/30/14/11/cat-551554_1280.jpg").centerCrop().into(binding.ivTaggedPost6)
    }

}