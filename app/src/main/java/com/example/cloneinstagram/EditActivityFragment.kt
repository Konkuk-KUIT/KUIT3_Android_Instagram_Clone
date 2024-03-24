package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloneinstagram.databinding.FragmentEditActivityBinding

class EditActivityFragment : Fragment() {

    lateinit var binding: FragmentEditActivityBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditActivityBinding.inflate(inflater, container, false)

        binding.tvEditCancelBtn.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm, HomeFragment()).commit()
        }
        return binding.root
    }


}