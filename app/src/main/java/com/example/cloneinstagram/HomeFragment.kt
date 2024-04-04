package com.example.cloneinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.cloneinstagram.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private var posts : ArrayList<PostData> = arrayListOf()
    private var postAdapter : PostAdapter ?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        initData()
        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        postAdapter = PostAdapter(posts)
        binding.rvPost.adapter = postAdapter
        binding.rvPost.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)

        postAdapter!!.setOnItemClickListener ( object :  PostAdapter.OnItemClickListener{
            override fun onItemClick(itemData: PostData) {
                val profileFragment = ProfileFragment().apply {
                    arguments = bundleOf("key" to itemData)
                }
                parentFragmentManager.beginTransaction()
                    .replace(R.id.main_frm, profileFragment)
                    .addToBackStack(null)
                    .commit()
            }
        })
    }

    private fun initData() {
        posts.addAll(
            arrayListOf(
                PostData(R.drawable.img_sample2, "meojung",R.drawable.img_sample2, "쿠잇 3기"),
                PostData(R.drawable.img_sample, "meojung2",R.drawable.img_sample, "쿠잇 4기"),
                PostData(R.drawable.img_sample2, "meojung3",R.drawable.img_sample2, "쿠잇 5기"),

                )

        )
    }
}