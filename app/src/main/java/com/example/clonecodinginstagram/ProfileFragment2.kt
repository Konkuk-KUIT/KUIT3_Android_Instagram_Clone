package com.example.clonecodinginstagram

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.clonecodinginstagram.databinding.FragmentProfile2Binding

class ProfileFragment2 : Fragment() {
    lateinit var binding: FragmentProfile2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfile2Binding.inflate(inflater, container, false)

        binding.icProfile5.setOnClickListener{
            val intent = Intent(this.activity, MenuActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }
}