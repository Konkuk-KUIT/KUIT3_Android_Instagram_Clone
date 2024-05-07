package com.example.cloneinstagram

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cloneinstagram.databinding.FragmentGridBinding

class GridFragment : Fragment() {
    lateinit var binding: FragmentGridBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentGridBinding.inflate(inflater,container,false)

        glide()

        binding.ivGrid1.setOnClickListener {
            val intent= Intent(requireContext(),HomeDetailActivity::class.java)
            intent.putExtra("imagekey","https://cdn.pixabay.com/photo/2024/02/28/07/42/european-shorthair-8601492_1280.jpg")
            startActivity(intent)
        }

        binding.ivGrid2.setOnClickListener {
            val intent= Intent(requireContext(),HomeDetailActivity::class.java)
            intent.putExtra("imagekey","https://cdn.pixabay.com/photo/2014/11/30/14/11/cat-551554_640.jpg")
            startActivity(intent)
        }

        binding.ivGrid3.setOnClickListener {
            val intent= Intent(requireContext(),HomeDetailActivity::class.java)
            intent.putExtra("imagekey","https://cdn.pixabay.com/photo/2023/06/14/06/22/cat-8062388_640.jpg")
            startActivity(intent)
        }

        binding.ivGrid4.setOnClickListener {
            val intent= Intent(requireContext(),HomeDetailActivity::class.java)
            intent.putExtra("imagekey","https://cdn.pixabay.com/photo/2023/07/16/09/31/cat-8130334_1280.jpg")
            startActivity(intent)
        }

        binding.ivGrid5.setOnClickListener {
            val intent= Intent(requireContext(),HomeDetailActivity::class.java)
            intent.putExtra("imagekey","https://cdn.pixabay.com/photo/2023/04/05/13/01/animal-7901464_1280.jpg")
            startActivity(intent)
        }

        binding.ivGrid6.setOnClickListener {
            val intent= Intent(requireContext(),HomeDetailActivity::class.java)
            intent.putExtra("imagekey","https://cdn.pixabay.com/photo/2023/07/04/08/31/cats-8105667_1280.jpg")
            startActivity(intent)

        }



        return binding.root
    }

    private fun glide() {
        Glide.with(this).load("https://cdn.pixabay.com/photo/2024/02/28/07/42/european-shorthair-8601492_1280.jpg").centerCrop().into(binding.ivGrid1)

        Glide.with(this).load("https://cdn.pixabay.com/photo/2014/11/30/14/11/cat-551554_640.jpg").centerCrop().into(binding.ivGrid2)

        Glide.with(this).load("https://cdn.pixabay.com/photo/2023/06/14/06/22/cat-8062388_640.jpg").centerCrop().into(binding.ivGrid3)

        Glide.with(this).load("https://cdn.pixabay.com/photo/2023/07/16/09/31/cat-8130334_1280.jpg").centerCrop().into(binding.ivGrid4)

        Glide.with(this).load("https://cdn.pixabay.com/photo/2023/04/05/13/01/animal-7901464_1280.jpg").centerCrop().into(binding.ivGrid5)

        Glide.with(this).load("https://cdn.pixabay.com/photo/2023/07/04/08/31/cats-8105667_1280.jpg").centerCrop().into(binding.ivGrid6)
    }


}
