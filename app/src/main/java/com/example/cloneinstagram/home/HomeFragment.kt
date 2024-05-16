package com.example.cloneinstagram.home

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.cloneinstagram.R
import com.example.cloneinstagram.data.PostData
import com.example.cloneinstagram.data.UsersData
import com.example.cloneinstagram.databinding.FragmentHomeBinding
import com.example.cloneinstagram.databinding.ItemHomeStoryBinding
import com.example.cloneinstagram.databinding.ItemPostHomeBinding
import com.example.cloneinstagram.profile.profile_main.ProfileFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private var postList : ArrayList<PostData> = arrayListOf()
    private var storyList : ArrayList<UsersData> = arrayListOf()
    private lateinit var homePostAdapter: HomePostAdapter
    private lateinit var homeStoryListAdapter: HomeStoryListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        initStoryData()
        initPostData()
        initStoryRV()
        initPostRV()

        return binding.root
    }

    private fun initStoryData() {
        storyList.add(
            UsersData.Builder()
            .setProfileImage(R.drawable.img_sample)
            .setProfileUserId("my.kuit.official")
            .setUserName("마이 쿠잇")
            .build()
        )

        val spfHomeStory: SharedPreferences = requireContext().getSharedPreferences("home_story", Context.MODE_PRIVATE)
        val homeStoryDB = HomeStoryDB.getInstance(requireContext())

        if(!spfHomeStory.getBoolean("isInit", false)) {
            CoroutineScope(Dispatchers.IO).launch {
                with(spfHomeStory.edit()) {
                    putBoolean("isInit", true)
                    apply()
                }
                with(homeStoryDB!!.HomeStoryDAO()) {
                    insert(
                        UsersData.Builder()
                            .setProfileImageUrl("https://cdn.pixabay.com/photo/2017/02/20/18/03/cat-2083492_1280.jpg")
                            .setProfileUserId("kuit.official1")
                            .setUserName("쿠잇1")
                            .build()
                    )
                    insert(
                        UsersData.Builder()
                            .setProfileImageUrl("https://cdn.pixabay.com/photo/2015/04/23/21/59/tree-736877_1280.jpg")
                            .setProfileUserId("kuit.official2")
                            .setUserName("쿠잇2")
                            .build()
                    )
                    insert(
                        UsersData.Builder()
                            .setProfileImageUrl("https://cdn.pixabay.com/photo/2024/02/17/00/18/cat-8578562_1280.jpg")
                            .setProfileUserId("kuit.official3")
                            .setUserName("쿠잇3")
                            .build()
                    )
                    insert(
                        UsersData.Builder()
                            .setProfileImageUrl("https://cdn.pixabay.com/photo/2024/03/08/09/55/cat-8620369_1280.png")
                            .setProfileUserId("kuit.official4")
                            .setUserName("쿠잇4")
                            .build()
                    )
                    insert(
                        UsersData.Builder()
                            .setProfileImageUrl("https://cdn.pixabay.com/photo/2019/11/08/11/56/kitten-4611189_1280.jpg")
                            .setProfileUserId("kuit.official5")
                            .setUserName("쿠잇5")
                            .build()
                    )

                }
                storyList.addAll(
                    homeStoryDB.HomeStoryDAO().getAll()
                )
            }
        } else {
            CoroutineScope(Dispatchers.IO).launch {
                storyList.addAll(
                    homeStoryDB!!.HomeStoryDAO().getAll()
                )
            }
        }

    }

    private fun initPostData() {
        val spfHomePost: SharedPreferences = requireContext().getSharedPreferences("home_post6", Context.MODE_PRIVATE)

        val homePostDB = HomePostDB.getInstance(requireContext())

        if(!spfHomePost.getBoolean("isInit", false)) { // 처음실행
            CoroutineScope(Dispatchers.IO).launch {
                with(spfHomePost.edit()) {
                    putBoolean("isInit", true)
                    apply()
                }
                with(homePostDB!!.HomePostDAO()) {
                    insert(
                        PostData.Builder()
                            .setProfileImage(R.drawable.img_sample)
                            .setProfileUserId("kuit.official_1")
                            .setProfileName("쿠잇1")
                            .setPostImage(R.drawable.img_sample2)
                            .setPostContent("첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 ")
                            .build()
                    )
                    insert(
                        PostData.Builder()
                            .setProfileImage(R.drawable.img_sample2)
                            .setProfileUserId("kuit.official_1")
                            .setProfileName("쿠잇2")
                            .setPostImage(R.drawable.img_sample)
                            .setPostContent("두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 ")
                            .build()
                    )
                }
                postList.addAll(
                    homePostDB.HomePostDAO().getAll()
                )
            }
        } else {
            CoroutineScope(Dispatchers.IO).launch {
                postList.addAll(
                    homePostDB!!.HomePostDAO().getAll()
                )
            }
        }
    }

    private fun initStoryRV() {
        homeStoryListAdapter = HomeStoryListAdapter(this, storyList)

        binding.rvHomeStoryList.adapter = homeStoryListAdapter
        binding.rvHomeStoryList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        homeStoryListAdapter.setOnItemClickListner(object : HomeStoryListAdapter.OnItemClickListener {
            override fun onItemClick(itemHomeStorybinding: ItemHomeStoryBinding) {
                itemHomeStorybinding.ivItemHomeStoryColor.visibility = View.INVISIBLE
                itemHomeStorybinding.ivItemHomeStoryGray.visibility = View.VISIBLE
            }
        })
    }

    private fun initPostRV() {
        homePostAdapter = HomePostAdapter(postList)

        binding.rvHomePostList.adapter = homePostAdapter
        binding.rvHomePostList.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        homePostAdapter.setOnItemClickListener(object : HomePostAdapter.OnItemClickListener {
            // userID click -> move to profileFragment
            override fun onIdClick(postData: PostData) {
                val profileFragment = ProfileFragment()
                profileFragment.arguments = bundleOf("data" to postData)

                parentFragmentManager.beginTransaction()
                    .replace(R.id.main_frm, profileFragment)
                    .addToBackStack(null)
                    .commit()
            }
            // option click -> move to editactivity
            override fun onOptionClick(postData: PostData) {
                val intent = Intent(activity, EditActivity::class.java)
                intent.putExtra("data", postData)
                startActivity(intent)
            }
            // showmore click -> contents line => max
            override fun onShowMoreClick(postData: PostData, itemBinding : ItemPostHomeBinding) {
                itemBinding.tvItemPostContents.maxLines = Int.MAX_VALUE
                itemBinding.tvItemPostContents.layoutParams.width = 270//
                itemBinding.tvItemPostShowMore.visibility = View.GONE
            }
        })
    }

}