package com.example.cloneinstagram

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
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

        val moreText = binding.tvHomePostingContentMore
        val text = binding.tvHomePostingContent
        val option = binding.ivHomePostingOption

        option.setOnClickListener{
            val intent = Intent(activity, EditActivity::class.java)
            intent.putExtra("id", binding.tvHomePostingProfileName.text)
            intent.putExtra("content", binding.tvHomePostingContent.text)
            startActivity(intent)
        }

        moreText.setOnClickListener {
            text.width = WindowManager.LayoutParams.WRAP_CONTENT
            text.maxLines = 100
            moreText.visibility = View.GONE
        }

        return binding.root
    }
}