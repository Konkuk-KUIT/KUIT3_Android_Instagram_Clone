package com.example.cloneinstagram

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible
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

        binding.tvDetail.setOnClickListener {
            binding.tvPostContent.apply {
                ellipsize=null
                maxLines=Int.MAX_VALUE
                binding.tvDetail.isVisible=false
            }
        }
        binding.postMore.setOnClickListener {
            var intent=Intent(requireActivity(),EditActivity::class.java)
            intent.putExtra("Name",binding.tvPostName.text.toString())
            intent.putExtra("Content", binding.tvPostContent.text.toString())
            startActivity(intent)
        }

        binding.tvPostName.setOnClickListener {
            val fragment=ProfileFragment()
            val bundle=Bundle()
            bundle.putString("PostName",binding.tvPostName.text.toString())
            fragment.arguments=bundle

            parentFragmentManager.beginTransaction()
                .replace(com.example.cloneinstagram.R.id.main_frm,fragment)
                .commit()
        }

        return binding.root
    }


}