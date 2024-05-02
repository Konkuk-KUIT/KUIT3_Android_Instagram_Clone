package com.example.cloneinstagram.profile.profile_main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cloneinstagram.R
import com.example.cloneinstagram.databinding.ActivityProfileEditBinding
import com.example.cloneinstagram.home.PostData
import com.example.cloneinstagram.home.UserData

class ProfileEditActivity : AppCompatActivity() {
    lateinit var binding : ActivityProfileEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileEditBinding.inflate(layoutInflater)

        val data = intent.getSerializableExtra("data") as UserData

        binding.tvProfileEditName.text = data.userName
        binding.tvProfileEditUserID.text = data.profileUserId
        if (data.profileImageView == null) {
            binding.sivProfileEditProfileImage.setImageResource(data.profileImage)
        } else {
//            binding.sivProfileEditProfileImage.setImageResource(data.profileImageView.sourceLayoutResId)
        }

        binding.ivProfileEditLeft.setOnClickListener{
            finish()
        }

        setContentView(binding.root)
    }
}