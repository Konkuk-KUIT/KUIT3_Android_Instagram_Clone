package com.example.cloneinstagram

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.example.cloneinstagram.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireArguments().getSerializable("key", PostData::class.java)
        } else {
            requireArguments().getSerializable("key") as PostData?
        } ?: PostData(R.drawable.img_sample, "잘못된 데이터", R.drawable.img_sample, "잘못된 데이터")

        data.let {
            binding.ivImage.setImageResource(data.postImage)
            binding.tvName.text = data.postText
        }

        binding.btnBefore.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.main_frm, HomeFragment())
                .commit()
        }

        return binding.root
    }
}