package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloneinstagram.databinding.FragmentIdBinding

class IdFragment : Fragment() {
    lateinit var binding : FragmentIdBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentIdBinding.inflate(layoutInflater, container, false)
        binding.tvProfileName.text = arguments?.getString("idChange")

        return binding.root
    }

}