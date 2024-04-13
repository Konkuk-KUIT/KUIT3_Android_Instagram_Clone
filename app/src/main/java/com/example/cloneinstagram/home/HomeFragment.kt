package com.example.cloneinstagram.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.cloneinstagram.R
import com.example.cloneinstagram.databinding.FragmentHomeBinding
import com.example.cloneinstagram.databinding.ItemPostHomeBinding
import com.example.cloneinstagram.profile.profile_main.ProfileFragment

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private var itemList : ArrayList<PostData> = arrayListOf()
    private lateinit var postAdapter: PostAdapter

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
        postAdapter = PostAdapter(itemList)
        binding.rvHomePostList.adapter = postAdapter

        binding.rvHomePostList.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        postAdapter.setOnItemClickListener(object : PostAdapter.OnItemClickListener {
            override fun onIdClick(postData: PostData) {
                val profileFragment = ProfileFragment()
                profileFragment.arguments = bundleOf("data" to postData)

                parentFragmentManager.beginTransaction()
                    .replace(R.id.main_frm, profileFragment)
                    .addToBackStack(null)
                    .commit()

            }
            override fun onOptionClick(postData: PostData) {
                val intent = Intent(activity, EditActivity::class.java)
                intent.putExtra("data", postData)
                startActivity(intent)
            }
            override fun onShowMoreClick(postData: PostData, itemBinding : ItemPostHomeBinding) {
                itemBinding.tvItemPostContents.maxLines = Int.MAX_VALUE
                itemBinding.tvItemPostContents.layoutParams.width = 700//
                itemBinding.tvItemPostShowMore.visibility = View.GONE
            }
        })
    }

    private fun initData() {
        itemList.addAll(
            arrayListOf(
                PostData(
                    R.drawable.img_sample, "kuit.official_1", R.drawable.img_sample2,
                    "첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 "),
                PostData(
                    R.drawable.img_sample2, "kuit.official_2", R.drawable.img_sample,
                    "두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 ")
            )
        )
    }
}