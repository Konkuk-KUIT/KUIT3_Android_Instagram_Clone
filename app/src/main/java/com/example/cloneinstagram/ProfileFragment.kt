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
        
        //HomeFragment로부터 받은 String을 프로필의 이름으로 설정
        val bundle = arguments
        if (bundle != null && bundle.containsKey("key")) {
            // Bundle에서 Serializable 객체를 가져와서 캐스팅
            val homePostData = bundle.getSerializable("key") as HomePostData

            binding.tvEditProfileName.text = homePostData.InstagramID
            binding.sivProfileEdit.setImageResource(homePostData.ProfileImage)
        }

        return binding.root
    }
}