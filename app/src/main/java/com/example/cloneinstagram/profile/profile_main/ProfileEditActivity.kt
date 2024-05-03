package com.example.cloneinstagram.profile.profile_main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.cloneinstagram.databinding.ActivityProfileEditBinding
import com.example.cloneinstagram.home.UsersData

class ProfileEditActivity : AppCompatActivity() {
    lateinit var binding : ActivityProfileEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileEditBinding.inflate(layoutInflater)

        val data = intent.getSerializableExtra("data") as UsersData

        binding.tvProfileEditName.text = data.userName
        binding.tvProfileEditUserID.text = data.profileUserId
        if (data.profileImageUrl == "") {
            binding.sivProfileEditProfileImage.setImageResource(data.profileImage)
        } else {
            Glide.with(applicationContext)
                .load(data.profileImageUrl)
                .into(binding.sivProfileEditProfileImage)
        }

        binding.ivProfileEditLeft.setOnClickListener{
            finish()
        }

        setContentView(binding.root)
    }
}