package com.example.cloneinstagram

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cloneinstagram.databinding.ActivityProfileEditBinding

class ProfileEditActivity : AppCompatActivity() {

    lateinit var binding: ActivityProfileEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvNickNameInput.text = intent.getStringExtra("ID")
        binding.tvNameInput.text = intent.getStringExtra("name")

        val profileImageResId = intent.getIntExtra("Profile", 0)
        binding.sivEditProfileImage.setImageResource(profileImageResId)

        binding.ivPrevious.setOnClickListener {
            finish()
        }

    }
}