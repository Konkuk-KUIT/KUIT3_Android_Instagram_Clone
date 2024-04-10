package com.example.cloneinstagram

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cloneinstagram.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        val bundle = arguments
        if (bundle != null && bundle.containsKey("key")) {
            val postData = bundle.getSerializable("key") as PostData

            binding.tvProfileId.text = postData.userId
            binding.sivProfileImg.setImageResource(postData.profileImg)
        }

        return binding.root
    }
}