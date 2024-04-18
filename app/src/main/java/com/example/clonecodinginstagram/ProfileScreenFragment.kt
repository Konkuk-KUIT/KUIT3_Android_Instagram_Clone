package com.example.clonecodinginstagram

import android.content.Intent
import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clonecodinginstagram.databinding.FragmentProfileScreenBinding
import com.example.clonecodinginstagram.databinding.ItemPostBinding
import com.google.android.material.tabs.TabLayoutMediator

class ProfileScreenFragment : Fragment() {
    lateinit var binding : FragmentProfileScreenBinding
    lateinit var itembinding : ItemPostBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileScreenBinding.inflate(inflater,container,false)
        binding.tvUserid.text = this.arguments?.getString("id")
        binding.username.text = this.arguments?.getString("name")
        itembinding = ItemPostBinding.inflate(inflater,container,false)

        initTabLayout()

        val strid = itembinding.textId.text.toString()
        val strname = "쿠잇"

        binding.tvReturn.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm, HomeFragment())
                .commit()
        }

        binding.tvFollower.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm, ProfileListMainFragment())
                .commit()
        }

        binding.tvFollowing.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm, ProfileListMainFragment())
                .commit()
        }

        return binding.root
    }

    private fun initTabLayout(){
        binding.vpProfileTab.adapter = TabLayoutVPAdapter(this)
        TabLayoutMediator(binding.tlProfileTab, binding.vpProfileTab) { tab, position ->
        }.attach()
        binding.tlProfileTab.getTabAt(0)?.setIcon(R.drawable.ic_grid)
        binding.tlProfileTab.getTabAt(1)?.setIcon(R.drawable.ic_tag)
    }
}