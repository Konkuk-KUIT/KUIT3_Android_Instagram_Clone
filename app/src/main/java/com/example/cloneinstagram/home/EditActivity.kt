package com.example.cloneinstagram.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cloneinstagram.data.PostData
import com.example.cloneinstagram.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        val data = intent.getSerializableExtra("data") as PostData

        binding.tvEditName.text = data.profileUserId
        binding.tvEditPostContent.text = data.postContent

        binding.tvEditCancelBtn.setOnClickListener {
            finish()
        }
    }
}