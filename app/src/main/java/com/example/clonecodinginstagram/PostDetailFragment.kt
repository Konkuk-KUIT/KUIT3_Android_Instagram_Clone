package com.example.clonecodinginstagram

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clonecodinginstagram.databinding.FragmentPostDetailBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PostDetailFragment : Fragment() {
    lateinit var binding : FragmentPostDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostDetailBinding.inflate(inflater,container,false)
        binding.tvIdPost.text = this.arguments?.getString("id")
        binding.tvId.text = this.arguments?.getString("id")
        binding.tvEditName.text = this.arguments?.getString("id")

        binding.vpPostimage.adapter = PostVPAdapter(this.requireContext())
        binding.idPostimage.attachTo(binding.vpPostimage)

        binding.ivEditCancelBtn.setOnClickListener{
            parentFragmentManager.popBackStack()
        }

        binding.tvPostText.setOnClickListener{
            binding.tvPostText.maxLines = Int.MAX_VALUE
        }

        binding.ivLikeEmpty.setOnClickListener{
            binding.ivLikeFilled.visibility = View.VISIBLE
        }

        binding.ivLikeFilled.setOnClickListener{
            binding.ivLikeFilled.visibility = View.GONE
        }

        //1. thread로 구현
        /*val imgthread = imgview()
        imgthread.start()*/

        //2. coroutine으로 구현
        CoroutineScope(Dispatchers.Main).launch {
            while(true) {
                delay(3000)
                val index = binding.vpPostimage.currentItem
                if (index + 1 == binding.vpPostimage.adapter?.itemCount) {
                    binding.vpPostimage.setCurrentItem(0, true)

                } else {
                    binding.vpPostimage.setCurrentItem(index + 1, true)
                }
            }
        }

        return binding.root
    }

    inner class imgview : Thread(){
        override fun run() {
            while(true){
                Thread.sleep(3000)
                imghandler().sendEmptyMessage(0)
            }
        }
    }

    inner class imghandler : Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            val index = binding.vpPostimage.currentItem
            if (index+1 == binding.vpPostimage.adapter?.itemCount){
                binding.vpPostimage.setCurrentItem(0,true)

            }else{
                binding.vpPostimage.setCurrentItem(index+1, true)
            }
        }
    }
}