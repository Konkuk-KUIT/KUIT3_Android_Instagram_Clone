package com.example.cloneinstagram

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

        var name=intent.getStringExtra("Name")
        var content=intent.getStringExtra("Content")

        binding.tvEditName.setText(name)
        binding.tvEditPostContent.setText(content)

        binding.tvEditCancelBtn.setOnClickListener {
            finish()
        }

        setContentView(binding.root)
    }
}