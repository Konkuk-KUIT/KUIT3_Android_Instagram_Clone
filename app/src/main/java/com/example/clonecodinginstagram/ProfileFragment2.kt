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
        var str_id = arguments?.getString("id")
        var str_name = arguments?.getString("name")

        binding = FragmentProfile2Binding.inflate(inflater, container, false)

        binding.icProfile5.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm, ProfileScreenFragment().apply {
                    arguments = Bundle().apply {
                        putString("id", str_id)
                        putString("name", str_name)
                    }
                })
                .commit()
        }
        return binding.root
    }
}