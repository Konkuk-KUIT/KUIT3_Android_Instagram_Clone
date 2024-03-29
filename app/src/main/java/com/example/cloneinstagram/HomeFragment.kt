package com.example.cloneinstagram

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cloneinstagram.databinding.FragmentHomeBinding
import com.example.cloneinstagram.databinding.FragmentProfileBinding


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.ivMenu1.setOnClickListener{

            val intent = Intent(context, EditActivity::class.java)
            intent.putExtra("nameValue", binding.kuitHome.text)
            intent.putExtra("ContentValue",binding.tvHome1.text)
            startActivity(intent)
            }

        return binding.root
    }
}