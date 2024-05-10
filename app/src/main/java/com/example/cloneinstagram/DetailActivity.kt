package com.example.cloneinstagram

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.cloneinstagram.databinding.ActivityDetailBinding
import com.example.cloneinstagram.databinding.ActivityDetailBinding.*
import com.example.cloneinstagram.databinding.ItemImageBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.net.ssl.HandshakeCompletedEvent

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    private val imgList = mutableListOf<String>()
    private var currentPage = 0
    lateinit var job: Job

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
        
       /* val thread = Thread(PagerRunnable())
        thread.start()*/

        //coroutine 구현
        job = Job()
        CoroutineScope(Dispatchers.IO).launch {
            while(isActive){
                delay(3000)
                withContext(Dispatchers.Main){
                    setPage()
                }
            }
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


    //페이지 변경하는 함수 setPage. thread, coroutine 구현에 사용됨
    fun setPage(){
        if(currentPage==3)
            currentPage=0
        binding.vpImage.setCurrentItem(currentPage,true)
        currentPage+=1
    }


/*
    //핸들러 구현
    val handler = Handler(Looper.getMainLooper()){
        setPage()
        true
    }
    //3초마다 페이지 넘김
    inner class PagerRunnable : Runnable{
        override fun run() {
            while(true){
                Thread.sleep(3000)
                handler.sendEmptyMessage(0)
            }
        }

    }*/
   

}