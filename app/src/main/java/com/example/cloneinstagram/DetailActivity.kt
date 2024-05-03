package com.example.cloneinstagram

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.cloneinstagram.databinding.ActivityDetailBinding
import com.example.cloneinstagram.databinding.ActivityDetailBinding.*
import com.example.cloneinstagram.databinding.ItemImageBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    private val imgList = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        initDummyData()
        initViewPager()
        setContentView(binding.root)

        binding.ivLikeEmpty.setOnClickListener{
            binding.ivLikeEmpty.visibility = View.GONE
            binding.ivLikeRed.visibility = View.VISIBLE
        }
        binding.ivLikeRed.setOnClickListener{
            binding.ivLikeEmpty.visibility = View.VISIBLE
            binding.ivLikeRed.visibility = View.GONE
        }
    }
    private fun initViewPager() {
        binding.vpImage.adapter = DetailVPIndicatorAdapter(applicationContext, imgList)
        binding.vpImage.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.diImage.attachTo(binding.vpImage)
    }

    private fun initDummyData(){
        imgList.add("https://cdn.pixabay.com/photo/2016/07/15/15/55/dachshund-1519374_1280.jpg")
        imgList.add("https://cdn.pixabay.com/photo/2018/05/11/08/11/dog-3389729_1280.jpg")
        imgList.add("https://cdn.pixabay.com/photo/2016/01/05/17/51/maltese-1123016_1280.jpg")
    }

}