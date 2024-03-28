package com.example.cloneinstagram

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cloneinstagram.databinding.ActivityEditBinding
import com.example.cloneinstagram.databinding.ActivityMainBinding

class EditActivity : AppCompatActivity() {

    lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        enableEdgeToEdge()
//        setContentView(R.layout.activity_edit)

        binding.tvEditName.text = intent.getStringExtra("id")
        binding.tvEditPostContent.text = intent.getStringExtra("content")

        binding.tvEditCancelBtn.setOnClickListener {
            finish()
        }

    }
}