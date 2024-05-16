package com.example.cloneinstagram.profile.profile_main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.cloneinstagram.databinding.FragmentProfileDetailPostBinding
import com.example.cloneinstagram.data.PostData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ProfileDetailPostFragment : Fragment() {
    lateinit var binding: FragmentProfileDetailPostBinding
    lateinit var imgUrlList: ArrayList<String>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileDetailPostBinding.inflate(inflater, container, false)
        val data = arguments?.getSerializable("data") as PostData
        imgUrlList =
            arrayListOf<String>(data.postImageURL, data.postImageURL, data.postImageURL)

        initVP(imgUrlList)
        binding.tvProfileDetailUserID.text = data.profileUserId
        binding.tvProfileDetailName.text = data.profileName
        binding.tvProfileDetailCommenter.text = data.profileUserId

        binding.tvProfileDetailShowMore.setOnClickListener {
            binding.tvProfileDetailContents.maxLines = Int.MAX_VALUE
            binding.tvProfileDetailContents.layoutParams.width = 270//
            binding.tvProfileDetailShowMore.visibility = View.GONE
        }

        var isLiked = false
        binding.flProfileDetailPostLike.setOnClickListener {
            if (isLiked == false) {
                binding.ivProfileDetailPostLikeEmpty.visibility = View.INVISIBLE
                binding.ivProfileDetailPostLikeFilled.visibility = View.VISIBLE
                isLiked = true
            } else {
                binding.ivProfileDetailPostLikeEmpty.visibility = View.VISIBLE
                binding.ivProfileDetailPostLikeFilled.visibility = View.INVISIBLE
                isLiked = false
            }
        }

        binding.ivProfileDetailLeft.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

//        autoPostViewThread()

        autoPostViewCoroutine()

        return binding.root
    }

    private fun autoPostViewCoroutine() {
        CoroutineScope(Dispatchers.Main).launch {
            while(true){
                if (binding.vpProfileDetailPost.currentItem == imgUrlList.size - 1) {
                    delay(3000)
                    binding.vpProfileDetailPost.currentItem = 0
                } else {
                    delay(3000)
                    binding.vpProfileDetailPost.currentItem += 1
                }
            }
        }
    }

    private fun autoPostViewThread() {
        class PostViewThread : Thread() {
            override fun run() {
                while(true){
                    if (binding.vpProfileDetailPost.currentItem == imgUrlList.size - 1) {
                        Thread.sleep(3000)
                        binding.vpProfileDetailPost.currentItem = 0
                    } else {
                        Thread.sleep(3000)
                        binding.vpProfileDetailPost.currentItem += 1
                    }
                }
            }
        }
        val pvTh = PostViewThread()
        pvTh.start()
    }

    private fun initVP(imgUrlList : ArrayList<String>) {
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