package com.example.cloneinstagram

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cloneinstagram.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    lateinit var binding: ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvEditName.text = intent.getStringExtra("nameValue")
        binding.tvEditPostContent.text = intent.getStringExtra("contentValue")

//        취소버튼 누르면 홈으로 돌아가기
        binding.tvEditCancelBtn.setOnClickListener {
            finish()
        }
    }
}