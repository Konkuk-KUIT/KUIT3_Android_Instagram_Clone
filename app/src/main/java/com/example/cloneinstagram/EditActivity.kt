package com.example.cloneinstagram

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cloneinstagram.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("key", HomePostData::class.java)
        } else {
            intent.getSerializableExtra("key") as HomePostData?
        } ?: HomePostData("잘못된 데이터 ", R.drawable.post_gray, R.drawable.post_gray, "잘못된 데이터")

        //HomeFragment로부터 받은 String들을 텍스트 뷰의 내용으로 설정
        binding.tvEditName.text = data.InstagramID
        binding.tvEditPostContent.text = data.PostComment
        binding.sivEditProfile.setImageResource(data.ProfileImage)
        binding.ivEditPostImg.setImageResource(data.PostImage)
        
        //취소 버튼을 눌렀을 때 원래의 엑티비티로 돌아감
        binding.tvEditCancelBtn.setOnClickListener {
            finish()
        }

    }
}