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

        binding.ivHomePostOption.setOnClickListener {
            // 데이터 전달을 위한 Bundle 생성
            val bundle = Bundle()
            bundle.putString("NameChange", binding.tvHomePost.text.toString()) // 데이터를 Bundle에 담음
            bundle.putString("ContentChange", binding.tvHomeComment1.text.toString()) //데이터를 또 담음

            // EditActivityFragment로 전환하면서 데이터 전달
            val editActivityFragment = EditActivityFragment()
            editActivityFragment.arguments = bundle

            parentFragmentManager.beginTransaction().replace(R.id.main_frm, editActivityFragment).commit()
        }

        binding.tvHomePost.setOnClickListener {

            val bundle = Bundle()
            bundle.putString("NameChange", binding.tvHomePost.text.toString()) // 데이터를 Bundle에 담음

            // EditActivityFragment로 전환하면서 데이터 전달
            val ProfileFragment = ProfileFragment()
            ProfileFragment.arguments = bundle

            parentFragmentManager.beginTransaction().replace(R.id.main_frm, ProfileFragment).commit()
        }

        binding.tvPostCommentPlus.setOnClickListener {
            binding.tvPostCommentPlus.visibility = View.GONE
            binding.tvHomeComment1.ellipsize = null
            binding.tvHomeComment1.maxLines = Int.MAX_VALUE
        }

        return binding.root
    }
}