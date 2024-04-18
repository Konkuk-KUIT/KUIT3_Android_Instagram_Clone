package com.example.clonecodinginstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clonecodinginstagram.databinding.FragmentProfileListMainBinding
import com.example.clonecodinginstagram.databinding.FragmentProfileScreenBinding

class ProfileListMainFragment : Fragment() {
    lateinit var binding:FragmentProfileListMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileListMainBinding.inflate(inflater,container,false)

        binding.ivBackLeft.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm, ProfileScreenFragment())
                .commit()
        }

        return binding.root

    }
}