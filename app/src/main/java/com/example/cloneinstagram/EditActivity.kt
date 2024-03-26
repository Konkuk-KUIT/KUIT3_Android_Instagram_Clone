package com.example.cloneinstagram

import android.os.Bundle
import android.view.LayoutInflater
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
        
        //HomeFragment로부터 받은 String들을 텍스트 뷰의 내용으로 설정
        binding.tvEditName.text = intent.getStringExtra("NameChange")
        binding.tvEditPostContent.text = intent.getStringExtra("ContentChange")
        
        //취소 버튼을 눌렀을 때 원래의 엑티비티로 돌아감
        binding.tvEditCancelBtn.setOnClickListener {
            finish()
        }

    }
}