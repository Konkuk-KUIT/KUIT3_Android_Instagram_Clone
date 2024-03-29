package com.example.clonecodinginstagram

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.clonecodinginstagram.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.icMenu.setOnClickListener{
            val intent = Intent(this.activity, MenuActivity::class.java)
            intent.putExtra("id",binding.textId.text)
            intent.putExtra("writing", binding.textWriting.text)
            startActivity(intent)
        }

        parentFragmentManager.beginTransaction()
            .replace(R.id.ic_circle,ProfileFragment())
            .commit()

        parentFragmentManager.beginTransaction()
            .replace(R.id.profile5,ProfileFragment2())
            .commit()

        return binding.root
    }

}