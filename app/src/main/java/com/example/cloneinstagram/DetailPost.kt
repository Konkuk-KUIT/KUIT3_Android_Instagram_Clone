package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.viewpager2.widget.ViewPager2
import com.example.cloneinstagram.databinding.FragmentDetailPostBinding

class DetailPost : Fragment() {

    lateinit var binding: FragmentDetailPostBinding
    private val imgUrlList = mutableListOf<String>()
    var isLike = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDetailPostBinding.inflate(inflater, container, false)
        initList()

        val text = binding.tvDetailPostPostingContent
        val moreText = binding.tvDetailPostPostingContentMore

        binding.vpDetailPostMainViewPager.adapter = DetailPostAdapter(requireActivity(), imgUrlList)
        binding.vpDetailPostMainViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.diDetailPostDotsIndicator.attachTo(binding.vpDetailPostMainViewPager)

        moreText.setOnClickListener{
            text.width = WindowManager.LayoutParams.WRAP_CONTENT
            text.maxLines = 100
            moreText.visibility = View.GONE
        }

        binding.flDetailPostClickbar.setOnClickListener {
            if(!isLike) {
                binding.ivHomePostingFilledLike.visibility = View.VISIBLE
                binding.ivHomePostingEmptyLike.visibility = View.GONE
                isLike = true
            }else{
                binding.ivHomePostingFilledLike.visibility = View.GONE
                binding.ivHomePostingEmptyLike.visibility = View.VISIBLE
                isLike = false
            }

        }

        return binding.root
    }

    private fun initList(){
        imgUrlList.add("https://cdn.pixabay.com/photo/2014/11/30/14/11/cat-551554_1280.jpg")
        imgUrlList.add("https://cdn.pixabay.com/photo/2023/06/29/10/33/lion-8096155_1280.png")
        imgUrlList.add("https://cdn.pixabay.com/photo/2023/07/30/00/12/cat-8157889_1280.png")
    }

}
