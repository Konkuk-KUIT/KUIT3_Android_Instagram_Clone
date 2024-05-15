package com.example.cloneinstagram

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cloneinstagram.databinding.FragmentPostBinding

class PostFragment : Fragment() {

    lateinit var binding: FragmentPostBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostBinding.inflate(inflater, container, false)

        initDummyData()
        setupClickListener()

        return binding.root
    }

    private fun setupClickListener() {
        val listener = View.OnClickListener {
            val postDetailFragment = PostDetailFragment()


            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm, postDetailFragment)
                .addToBackStack(null)
                .commit()
        }

        binding.ivPost1.setOnClickListener(listener)
        binding.ivPost2.setOnClickListener(listener)
        binding.ivPost3.setOnClickListener(listener)
        binding.ivPost4.setOnClickListener(listener)
        binding.ivPost5.setOnClickListener(listener)
        binding.ivPost6.setOnClickListener(listener)
    }



    private fun initDummyData() {
        Glide.with(this).load("https://cdn.pixabay.com/photo/2014/11/30/14/11/cat-551554_1280.jpg").centerCrop().into(binding.ivPost1)
        Glide.with(this).load("https://cdn.pixabay.com/photo/2017/07/25/01/22/cat-2536662_1280.jpg").centerCrop().into(binding.ivPost2)
        Glide.with(this).load("https://cdn.pixabay.com/photo/2019/11/08/11/56/kitten-4611189_1280.jpg").centerCrop().into(binding.ivPost3)
        Glide.with(this).load("https://cdn.pixabay.com/photo/2017/11/09/21/41/cat-2934720_1280.jpg").centerCrop().into(binding.ivPost4)
        Glide.with(this).load("https://cdn.pixabay.com/photo/2014/04/13/20/49/cat-323262_1280.jpg").centerCrop().into(binding.ivPost5)
        Glide.with(this).load("https://cdn.pixabay.com/photo/2023/12/15/21/47/cat-8451431_1280.jpg").centerCrop().into(binding.ivPost6)
    }

}