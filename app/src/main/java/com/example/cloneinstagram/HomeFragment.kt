package com.example.cloneinstagram

import android.app.ActionBar.LayoutParams
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
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

        binding.tvHomeFeed1ShowMore.setOnClickListener {
            binding.tvHomeFeed1Contents.maxLines = Int.MAX_VALUE
            binding.tvHomeFeed1Contents.layoutParams.width = 260//
            binding.tvHomeFeed1ShowMore.visibility = View.GONE
        }

        binding.ivHomeFeed1Options.setOnClickListener {
            val intent = Intent(activity, EditActivity::class.java)
            intent.putExtra("id", binding.tvHomeFeed1Id.text)
            intent.putExtra("content", binding.tvHomeFeed1Contents.text)
            startActivity(intent)
        }

        binding.tvHomeFeed1Id.setOnClickListener {
            val profileFragment = ProfileFragment()
            val data = binding.tvHomeFeed1Id.text.toString()
            profileFragment.arguments = bundleOf(Pair<String, String>("userID", data))
            profileFragment.onStart()

            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm, profileFragment)
                .commit()
        }

        return binding.root
    }
}