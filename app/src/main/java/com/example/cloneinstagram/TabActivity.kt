package com.example.cloneinstagram

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cloneinstagram.databinding.ActivityTabBinding
import com.google.android.material.tabs.TabLayoutMediator

class TabActivity : AppCompatActivity() {

    lateinit var binding: ActivityTabBinding
    private val tabList = arrayListOf("100 팔로워", "100 팔로잉", "구독")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabBinding.inflate(layoutInflater)

        initView()

        binding.tvTabId.text = intent.getStringExtra("key")

        binding.ivPrevious.setOnClickListener {
            finish()
        }


        setContentView(binding.root)

    }

    private fun initView() {
        binding.vpContent.adapter = UsersTabLayoutVPAdapter(this)

        val fragmentIndex = intent.getIntExtra("fragment_index", 0)

        TabLayoutMediator(binding.tlTabs, binding.vpContent) { tab, position ->
            tab.text = tabList[position]
        }.attach()

//      viewPager에서 해당하는 fragment 보여주기
        binding.vpContent.setCurrentItem(fragmentIndex, false)
    }
}