package com.example.clonecodinginstagram

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.clonecodinginstagram.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("id")or intent.hasExtra("writing")) {
            binding.tvEditName.text = intent.getStringExtra("id")
            binding.tvEditPostContent.text = intent.getStringExtra("writing")
        }
        binding.tvEditCancelBtn.setOnClickListener{
            finish()
        }
}
}