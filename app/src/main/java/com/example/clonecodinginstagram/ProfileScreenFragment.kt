package com.example.clonecodinginstagram

import android.content.Intent
import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clonecodinginstagram.databinding.FragmentProfileScreenBinding

class ProfileScreenFragment : Fragment() {
    lateinit var binding : FragmentProfileScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileScreenBinding.inflate(inflater,container,false)
        binding.tvUserid.text = this.arguments?.getString("id")
        binding.username.text = this.arguments?.getString("name")

        binding.tvReturn.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm, HomeFragment())
                .commit()
        }

        return binding.root
    }


}