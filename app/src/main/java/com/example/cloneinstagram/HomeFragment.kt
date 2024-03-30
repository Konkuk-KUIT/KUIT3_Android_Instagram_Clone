package com.example.cloneinstagram

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
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        binding.ibPostOptions.setOnClickListener {
            val intent = Intent(context, OptionActivity::class.java)
            intent.putExtra("idvalue", binding.tvHomePost.text)
            intent.putExtra("postcontent", binding.tvPostComment2.text)
            startActivity(intent)
        }
        binding.tvHomePost.setOnClickListener {
            parentFragmentManager.fragments[0].arguments = bundleOf(Pair<String, String>("idChange","kuit.official"))
            /*parentFragmentManager.fragments[0].onStart()*/

            val replace = parentFragmentManager.beginTransaction()
                .replace(R.id.container, IdFragment())
                .commit()
        }
        return binding.root
    }
}