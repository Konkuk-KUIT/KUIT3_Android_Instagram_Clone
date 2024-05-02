package com.example.cloneinstagram.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.cloneinstagram.R
import com.example.cloneinstagram.databinding.FragmentHomeBinding
import com.example.cloneinstagram.databinding.ItemHomeStoryBinding
import com.example.cloneinstagram.databinding.ItemPostHomeBinding
import com.example.cloneinstagram.profile.profile_main.ProfileFragment

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private var itemList : ArrayList<PostData> = arrayListOf()
    private lateinit var postAdapter: PostAdapter
    private lateinit var homeStoryAdapter: HomeStoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        initData()
        initStoryRecyclerView()
        initPostRecyclerView()

        return binding.root
    }

    private fun initStoryRecyclerView() {
        val urlList = arrayListOf<String>(
            "https://cdn.pixabay.com/photo/2017/02/20/18/03/cat-2083492_1280.jpg",
            "https://cdn.pixabay.com/photo/2015/04/23/21/59/tree-736877_1280.jpg",
            "https://cdn.pixabay.com/photo/2024/02/17/00/18/cat-8578562_1280.jpg",
            "https://cdn.pixabay.com/photo/2019/11/08/11/56/kitten-4611189_1280.jpg",
            "https://cdn.pixabay.com/photo/2024/03/08/09/55/cat-8620369_1280.png",
            "https://cdn.pixabay.com/photo/2019/11/08/11/56/kitten-4611189_1280.jpg"

        )
        homeStoryAdapter = HomeStoryAdapter(this, urlList)
        binding.rvHomeStoryList.adapter = homeStoryAdapter
        binding.rvHomeStoryList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        homeStoryAdapter.setOnItemClickListner(object : HomeStoryAdapter.OnItemClickListener {
            override fun onItemClick(itemHomeStorybinding: ItemHomeStoryBinding) {
                itemHomeStorybinding.ivItemHomeStoryColor.visibility = View.INVISIBLE
                itemHomeStorybinding.ivItemHomeStoryGray.visibility = View.VISIBLE
            }

        })
    }

    private fun initPostRecyclerView() {
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
                PostData.Builder()
                    .setProfileImage(R.drawable.img_sample)
                    .setProfileUserId("kuit.official_1")
                    .setPostImage(R.drawable.img_sample2)
                    .setPostContent("첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 ")
                    .build(),
                PostData.Builder()
                    .setProfileImage(R.drawable.img_sample2)
                    .setProfileUserId("kuit.official_1")
                    .setPostImage(R.drawable.img_sample)
                    .setPostContent("두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 ")
                    .build()
            )
        )
    }
}