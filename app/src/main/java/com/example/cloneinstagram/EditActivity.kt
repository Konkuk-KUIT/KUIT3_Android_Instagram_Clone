package com.example.cloneinstagram

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.cloneinstagram.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)

        var name=intent.getStringExtra("Name")
        var content=intent.getStringExtra("Content")

        //이거 어떻게 처리할지 고민해야됨
        binding.tvEditCancelBtn.setOnClickListener {
            finish()
        }

        val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("postKey", PostData::class.java)
        } else {
            intent.getSerializableExtra("postKey")as PostData?
        }?: PostData(0,0,"잘못된 id","잘못된 content")
        binding.tvEditName.text=data.postId
        binding.tvEditPostContent.text=data.postContent
        binding.sivEditProfile.setImageResource(data.profileImgId)
        binding.ivEditPostImg.setImageResource(data.postImgId)

        setContentView(binding.root)
    }
}