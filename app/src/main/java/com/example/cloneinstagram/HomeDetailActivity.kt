package com.example.cloneinstagram

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.example.cloneinstagram.databinding.ActivityHomeDetailBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeDetailBinding
    private val imgList= mutableListOf<String>()
    //**Thread
    var pHandler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeDetailBinding.inflate(layoutInflater)

        val detail= intent.getStringExtra("imagekey")
        initImageList(detail)
        initVp()

        binding.icHdLike.setOnClickListener {
            binding.icHdLike.visibility=View.GONE
            binding.icHdLikeFilled.visibility= View.VISIBLE
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

        setContentView(binding.root)
    }

    private fun initVp() {
        binding.vpHdPostPic.adapter=VPIndicatorAdapter(applicationContext,imgList)

        binding.vpHdPostPic.orientation= ViewPager2.ORIENTATION_HORIZONTAL
        binding.diPic.attachTo(binding.vpHdPostPic)

        //**Thread
        var passTh=passRun()
        Thread(passRun()).start()

        //**Coroutine
        CoroutineScope(Dispatchers.Main).launch {
            while(true){
                delay(3000)
                val next = (binding.vpHdPostPic.currentItem+1)%imgList.size
                binding.vpHdPostPic.setCurrentItem(next,true)
            }
        }


    }
    inner class passRun:Runnable{ //**Thread
        override fun run() {
            while(true){
                Thread.sleep(3000)
                pHandler.post(timerSendRun())
            }
        }

    }
    inner class timerSendRun:Runnable{
        override fun run() {
            val next = (binding.vpHdPostPic.currentItem+1) % imgList.size
            binding.vpHdPostPic.setCurrentItem(next)
        }
    }


    private fun initImageList(detail: String?) {
        detail?.let {
            imgList.add(it)
        }
        imgList.add("https://cdn.pixabay.com/photo/2022/08/22/12/42/bird-7403593_1280.jpg")
        imgList.add("https://cdn.pixabay.com/photo/2019/06/06/22/50/sea-4257204_1280.jpg")
    }
}