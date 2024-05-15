package com.example.cloneinstagram

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cloneinstagram.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvNameInput.text = intent.getStringExtra("name")
        binding.tvUserNameInput.text = intent.getStringExtra("ID")

        val profileImgResId = intent.getIntExtra("profile", 0)

        binding.sivEditProfileImg.setImageResource(profileImgResId)

        binding.ivPrevious.setOnClickListener {
            finish()
        }

    }
}