package com.example.cloneinstagram

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cloneinstagram.databinding.FragmentProfileEditBinding

class ProfileEditFragment:Fragment() {
    lateinit var binding:FragmentProfileEditBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        binding=FragmentProfileEditBinding.inflate(inflater,container,false)

        val dataofprofile=arguments?.getSerializable("profileData") as PostData

        binding.tvPeUserNameInput.text=dataofprofile.postId
        binding.sivPeProfileImg.setImageResource(dataofprofile.profileImgId)

        return binding.root
    }
}