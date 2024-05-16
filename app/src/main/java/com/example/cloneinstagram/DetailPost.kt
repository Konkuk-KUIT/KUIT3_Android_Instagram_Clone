package com.example.cloneinstagram

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.viewpager2.widget.ViewPager2
import com.example.cloneinstagram.databinding.FragmentDetailPostBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

//        var mHandler = mainHandler()
//
//        class MyRunnable : Runnable{
//            override fun run() {
//                while(binding.vpDetailPostMainViewPager.currentItem < 5) {
//                    Thread.sleep(1000)
//                    mHandler.sendEmptyMessage(0)
//                }
//            }
//        }
//
//        var myRunnable = MyRunnable()
//        Thread(myRunnable).start()

        CoroutineScope(Dispatchers.IO).launch{
            while(binding.vpDetailPostMainViewPager.currentItem < 5) {
                Thread.sleep((1000))
                val vp = binding.vpDetailPostMainViewPager

                withContext(Dispatchers.Main){
                    vp.currentItem = vp.currentItem + 1
                }
            }
        }

        

        return binding.root
    }

    private fun initList(){
        imgUrlList.add("https://cdn.pixabay.com/photo/2014/11/30/14/11/cat-551554_1280.jpg")
        imgUrlList.add("https://cdn.pixabay.com/photo/2023/06/29/10/33/lion-8096155_1280.png")
        imgUrlList.add("https://cdn.pixabay.com/photo/2023/07/30/00/12/cat-8157889_1280.png")
        imgUrlList.add("https://cdn.pixabay.com/photo/2020/04/27/09/21/cat-5098930_1280.jpg")
        imgUrlList.add("https://cdn.pixabay.com/photo/2023/11/02/16/49/cat-8361048_1280.jpg")
    }

    inner class mainHandler : Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {

            val vp = binding.vpDetailPostMainViewPager
            vp.currentItem = vp.currentItem + 1
        }
    }
}

