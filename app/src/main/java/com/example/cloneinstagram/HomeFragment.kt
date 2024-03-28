package com.example.cloneinstagram

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.example.cloneinstagram.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    @SuppressLint("CommitTransaction")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val moreText = binding.tvHomePostingContentMore
        val text = binding.tvHomePostingContent
        val option = binding.ivHomePostingOption
        val profileName = binding.tvHomePostingProfileName

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

        profileName.setOnClickListener {
            val bundle = Bundle()
            val profileFragment = ProfileFragment()
            bundle.putString("id", binding.tvHomePostingProfileName.text.toString())
            profileFragment.setArguments(bundle)

            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm, profileFragment)
                .commit()

        }

        return binding.root
    }
}