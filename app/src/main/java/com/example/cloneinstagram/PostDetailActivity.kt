package com.example.cloneinstagram

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.cloneinstagram.databinding.ActivityPostDetailBinding

class PostDetailActivity : AppCompatActivity() {
    lateinit var post_detail_binding: ActivityPostDetailBinding
//    lateinit var


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        post_detail_binding = ActivityPostDetailBinding.inflate(layoutInflater)
        setContentView(post_detail_binding.root)

        // 이미지 URL 받아오기
        val imageUrl = intent.getStringExtra("image_url") ?: ""

        // 상세 이미지 로드
        Glide.with(this).load(imageUrl).into(post_detail_binding.ivPostDetailImg)

        // 좋아요 버튼 클릭 리스너 설정
        post_detail_binding.ivPostDetailLike.setOnClickListener {
            toggleLike()
        }
    }

    private fun toggleLike() {
        // 현재 리소스 ID를 확인하고 상태를 토글
        if (post_detail_binding.ivPostDetailLike.tag == null || post_detail_binding.ivPostDetailLike.tag == "unliked") {
            post_detail_binding.ivPostDetailLike.setImageResource(R.drawable.ic_like_filled)
            post_detail_binding.ivPostDetailLike.tag = "liked"
        } else {
            post_detail_binding.ivPostDetailLike.setImageResource(R.drawable.ic_like)
            post_detail_binding.ivPostDetailLike.tag = "unliked"
        }
    }
}