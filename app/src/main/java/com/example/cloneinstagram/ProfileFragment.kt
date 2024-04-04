package com.example.cloneinstagram

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.cloneinstagram.R
import com.example.cloneinstagram.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        val imageView: ImageView = binding.ivProfileImg
        imageView.setImageResource(R.drawable.img_sample)


        val profileData=arguments?.getSerializable("nameKey") as? PostData
        binding.tvProfileId.text=profileData?.postId
        binding.ivProfileImg.setImageResource(profileData!!.profileImgId)

        return binding.root
    }
}