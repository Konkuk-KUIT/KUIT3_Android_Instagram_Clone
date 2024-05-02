package com.example.cloneinstagram.profile.profile_main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.cloneinstagram.databinding.FragmentProfileDetailPostBinding
import com.example.cloneinstagram.home.PostData

class ProfileDetailPostFragment : Fragment() {
    lateinit var binding: FragmentProfileDetailPostBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileDetailPostBinding.inflate(inflater, container, false)
        val data = arguments?.getSerializable("data") as PostData

        initVP(data)
        binding.tvProfileDetailUserID.text = data.profileUserId
        binding.tvProfileDetailName.text = data.profileUserId

//        if (data.postImageURL == "") {
//            binding.ivProfileDetailPostImg.setImageResource(data.postImage)
//        } else {
//            Glide.with(this)
//                .load(data.postImageURL)
//                .into(binding.ivProfileDetailPostImg)
//        }

        binding.tvProfileDetailShowMore.setOnClickListener {
            binding.tvProfileDetailContents.maxLines = Int.MAX_VALUE
            binding.tvProfileDetailContents.layoutParams.width = 700//
            binding.tvProfileDetailShowMore.visibility = View.GONE
        }

        val isLiked = false
        binding.flProfileDetailPostLike.setOnClickListener {
            if (isLiked == false) {
                binding.ivProfileDetailPostLikeEmpty.visibility = View.INVISIBLE
                binding.ivProfileDetailPostLikeFilled.visibility = View.VISIBLE
            }
        }


        // Inflate the layout for this fragment
        return binding.root
    }

    private fun initVP(data: PostData) {
        val imgUrlList =
            arrayListOf<String>(data.postImageURL, data.postImageURL, data.postImageURL)
        binding.vpProfileDetailPost.adapter = ProfileDetailVPAdapter(this, imgUrlList)
        binding.vpProfileDetailPost.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.sdiProfileDetailPostIndicator.attachTo(binding.vpProfileDetailPost)
//        binding.vpProfileDetailPost.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//            override fun onPageSelected(position: Int) {
//                binding.tvFruit.text = textList[position]
//            }
//    }
    }
}