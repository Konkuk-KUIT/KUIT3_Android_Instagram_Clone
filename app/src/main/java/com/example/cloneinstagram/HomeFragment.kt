package com.example.cloneinstagram

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cloneinstagram.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

//        옵션 버튼 눌렀을 때
        binding.ivHomeOption.setOnClickListener {
            val intent = Intent(activity, EditActivity::class.java)

            intent.putExtra("nameValue", binding.tvHomePostId.text)
            intent.putExtra("contentValue", binding.tvHomeContent.text)

            startActivity(intent)
        }

//        id 버튼 눌렀을 때
        binding.tvHomePostId.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("nameValue", binding.tvHomePostId.text.toString())

            val profileFragment = ProfileFragment()
            profileFragment.arguments = bundle

            parentFragmentManager.beginTransaction().replace(R.id.main_frm, profileFragment).commit()
        }


        return binding.root
    }
}