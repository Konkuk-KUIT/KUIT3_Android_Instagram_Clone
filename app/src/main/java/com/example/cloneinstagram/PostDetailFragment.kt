package com.example.cloneinstagram

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.cloneinstagram.databinding.FragmentPostDetailBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostDetailFragment : Fragment() {

    lateinit var binding: FragmentPostDetailBinding
    private val imgList = mutableListOf<String>()
    var isLiked: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPostDetailBinding.inflate(inflater, container, false)

        initData()
        initViewPager(requireActivity().applicationContext)

        val bundle = arguments
        if (bundle != null && bundle.containsKey("key")) {
            val postData = bundle.getSerializable("key") as PostData

            binding.tvIdTitle.text = postData.userId
            binding.tvPostDetailUseridBig.text = postData.userId
            binding.tvPostDetailUseridSmall.text = postData.userId

            binding.sivPostDetailProfile.setImageResource(postData.profileImg)
        }

        binding.ivPrevious.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        if (binding.tvPostDetailContent.length() < 15) {
            binding.ivPostDetailMore.visibility = View.GONE
        } else {
            binding.ivPostDetailMore.visibility = View.GONE
            binding.tvPostDetailContent.ellipsize = null
            binding.tvPostDetailContent.maxLines = Int.MAX_VALUE
        }

        binding.ivPostDetailLike.setOnClickListener {
            if (!isLiked) {
                binding.ivPostDetailLike.setImageResource(R.drawable.ic_like_filled)
                isLiked = true
            } else {
                binding.ivPostDetailLike.setImageResource(R.drawable.ic_like)
                isLiked = false
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                var count = binding.vpPostDetailImg.currentItem
                Thread.sleep(3000)

                withContext(Dispatchers.Main) {
                    if (count != 2) {
                        count += 1

                        binding.vpPostDetailImg.currentItem = count
                    } else {
                        binding.vpPostDetailImg.currentItem = 0
                    }
                }
            }
        }

        return binding.root
    }


    private fun initViewPager(context: Context) {
        binding.vpPostDetailImg.adapter = PostDetailVPIndicatorAdapter(context, imgList)
        binding.vpPostDetailImg.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.diImage.attachTo(binding.vpPostDetailImg)
    }

    private fun initData() {
        imgList.add("https://cdn.pixabay.com/photo/2014/11/30/14/11/cat-551554_1280.jpg")
        imgList.add("https://cdn.pixabay.com/photo/2017/07/25/01/22/cat-2536662_1280.jpg")
        imgList.add("https://cdn.pixabay.com/photo/2019/11/08/11/56/kitten-4611189_1280.jpg")
    }
}