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

        val image1 = binding.iv1
        val image2 = binding.iv2
        val image3 = binding.iv3
        val image4 = binding.iv4
        val image5 = binding.iv5
        val image6 = binding.iv6


        context?.let {
            Glide.with(it)
                .load("https://cdn.pixabay.com/photo/2014/11/30/14/11/cat-551554_1280.jpg")
                .into(image1)
            Glide.with(it)
                .load("https://cdn.pixabay.com/photo/2023/06/29/10/33/lion-8096155_1280.png")
                .into(image2)
            Glide.with(it)
                .load("https://cdn.pixabay.com/photo/2023/07/30/00/12/cat-8157889_1280.png")
                .into(image3)
            Glide.with(it)
                .load("https://cdn.pixabay.com/photo/2020/04/27/09/21/cat-5098930_1280.jpg")
                .into(image4)
            Glide.with(it)
                .load("https://cdn.pixabay.com/photo/2021/10/27/19/09/cat-6748193_1280.jpg")
                .into(image5)
            Glide.with(it)
                .load("https://cdn.pixabay.com/photo/2017/11/09/21/41/cat-2934720_1280.jpg")
                .into(image6)
        }

        image1.setOnClickListener{
            val detailPost = DetailPost()

            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm, detailPost)
                .commit()
        }

        return binding.root
    }

}