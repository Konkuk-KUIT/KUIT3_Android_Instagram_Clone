package com.example.cloneinstagram

import android.os.Build
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

        val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("key", PostData::class.java)
        } else {
            intent.getSerializableExtra("key") as PostData?
        } ?: PostData(R.drawable.ic_no_profile,"잘못된 userId", R.drawable.img_no_post, "잘못된 content")

        binding.sivEditProfile.setImageResource(data.profileImg)
        binding.tvEditName.text = data.userId
        binding.ivEditPostImg.setImageResource(data.postImg)
        binding.tvEditPostContent.text = data.postContent

//        취소버튼 누르면 홈으로 돌아가기
        binding.tvEditCancelBtn.setOnClickListener {
            finish()
        }
    }
}