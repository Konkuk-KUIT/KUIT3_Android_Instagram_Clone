package com.example.clonecodinginstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clonecodinginstagram.databinding.FragmentPostDetailBinding

class PostDetailFragment : Fragment() {
    lateinit var binding : FragmentPostDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostDetailBinding.inflate(inflater,container,false)
        binding.tvIdPost.text = this.arguments?.getString("id")
        binding.tvId.text = this.arguments?.getString("id")
        binding.tvEditName.text = this.arguments?.getString("id")

        binding.vpPostimage.adapter = PostVPAdapter(this.requireContext())
        binding.idPostimage.attachTo(binding.vpPostimage)

        binding.ivEditCancelBtn.setOnClickListener{
            parentFragmentManager.popBackStack()
        }

        binding.tvPostText.setOnClickListener{
            binding.tvPostText.maxLines = Int.MAX_VALUE
        }

        binding.ivLikeEmpty.setOnClickListener{
            binding.ivLikeFilled.visibility = View.VISIBLE
        }

        binding.ivLikeFilled.setOnClickListener{
            binding.ivLikeFilled.visibility = View.GONE
        }

        return binding.root
    }
}