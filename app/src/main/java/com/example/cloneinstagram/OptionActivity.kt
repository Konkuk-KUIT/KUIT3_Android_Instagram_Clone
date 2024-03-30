package com.example.cloneinstagram

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cloneinstagram.databinding.ActivityOptionBinding

class OptionActivity : AppCompatActivity() {
    lateinit var binding: ActivityOptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvEditName.text = intent.getStringExtra("idvalue")
        binding.tvEditPostContent.text = intent.getStringExtra("postcontent")

        binding.tvEditCancleBtn.setOnClickListener {
            finish()
        }
    }
}