package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.example.cloneinstagram.databinding.FragmentHomeDetailBinding


class HomeDetailFragment : Fragment() {

    lateinit var binding:FragmentHomeDetailBinding
    lateinit var vpIndicatorAdapter: VPIndicatorAdapter
    private val imgList= mutableListOf<String>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHomeDetailBinding.inflate(inflater,container,false)

        val detail=arguments?.getString("imageKey")
        initImageList(detail)

        vpIndicatorAdapter=VPIndicatorAdapter(context,imgList)
        binding.vpHdPostPic.adapter=vpIndicatorAdapter
        binding.vpHdPostPic.orientation=ViewPager2.ORIENTATION_HORIZONTAL
        binding.diPic.attachTo(binding.vpHdPostPic)



        binding.icHdLike.setOnClickListener {
            binding.icHdLike.visibility=View.GONE
            binding.icHdLikeFilled.visibility=View.VISIBLE
        }

        binding.icHdLikeFilled.setOnClickListener {
            binding.icHdLikeFilled.visibility=View.GONE
            binding.icHdLike.visibility=View.VISIBLE

        }

        binding.tvHdDetail.setOnClickListener {
            binding.tvHdPostContent.apply {
                ellipsize=null
                maxLines= Int.MAX_VALUE
                binding.tvHdDetail.isVisible=false
            }
        }

        return binding.root
    }

    private fun initImageList(detail: String?) {

        detail?.let {
            imgList.add(it)
        }
        imgList.add("https://cdn.pixabay.com/photo/2022/08/22/12/42/bird-7403593_1280.jpg")
        imgList.add("https://cdn.pixabay.com/photo/2019/06/06/22/50/sea-4257204_1280.jpg")
    }


}