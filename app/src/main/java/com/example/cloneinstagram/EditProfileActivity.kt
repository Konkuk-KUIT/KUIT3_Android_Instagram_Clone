package com.example.cloneinstagram

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cloneinstagram.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {
    lateinit var binding : ActivityEditProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imgSRC = intent.getIntExtra("IMG",0)
        binding.tvEditId.text = intent.getStringExtra("ID")
        binding.tvEditName.text = intent.getStringExtra("NAME")
        binding.sivEditImgGray.setImageResource(imgSRC)
    }
}