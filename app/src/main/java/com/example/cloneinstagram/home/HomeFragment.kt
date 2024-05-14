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
import androidx.room.Room
import com.example.cloneinstagram.R
import com.example.cloneinstagram.databinding.FragmentHomeBinding
import com.example.cloneinstagram.databinding.ItemHomeStoryBinding
import com.example.cloneinstagram.databinding.ItemPostHomeBinding
import com.example.cloneinstagram.profile.profile_main.ProfileFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private var itemList : ArrayList<PostData> = arrayListOf()
    private lateinit var postAdapter: PostAdapter
    private lateinit var homeStoryListAdapter: HomeStoryListAdapter
    private lateinit var myData : UsersData

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        initMyData()
        initData()
        initPostRV()
        initStoryRV()

        return binding.root
    }

    private fun initMyData() {
        myData = UsersData.Builder()
            .setProfileImage(R.drawable.img_sample)
            .setProfileUserId("kuit.official")
            .setUserName("쿠잇")
            .build()
    }

    private fun initData() {
        val spf_homePost: SharedPreferences = requireContext().getSharedPreferences("home_post4", Context.MODE_PRIVATE)

        // 1번 바로 가져와서 쓰기 ( 싱글톤 패턴 x )

//        val homePostDB = Room.databaseBuilder(
//            requireContext(),
//            HomePostDB::class.java,
//            "homepost-database"
//        ).allowMainThreadQueries().build()

        // 2번 싱글톤 패턴
        val homePostDB = HomePostDB.getInstance(requireContext())

        if(!spf_homePost.getBoolean("isInit", false)){
//            with(spf_homePost.edit()) {
//                putBoolean("isInit", true)
//                apply()
//            }
//            with(homePostDB!!.HomePostDAO()) {
//                insert(PostData.Builder()
//                    .setProfileImage(R.drawable.img_sample)
//                    .setProfileUserId("kuit.official_1")
//                    .setProfileName("쿠잇1")
//                    .setPostImage(R.drawable.img_sample2)
//                    .setPostContent("첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 ")
//                    .build())
//                insert(PostData.Builder()
//                    .setProfileImage(R.drawable.img_sample2)
//                    .setProfileUserId("kuit.official_1")
//                    .setProfileName("쿠잇2")
//                    .setPostImage(R.drawable.img_sample)
//                    .setPostContent("두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 ")
//                    .build())
//            }
            CoroutineScope(Dispatchers.IO).launch {
                with(spf_homePost.edit()) {
                    putBoolean("isInit", true)
                    apply()
                }
                with(homePostDB!!.HomePostDAO()) {
                    insert(PostData.Builder()
                        .setProfileImage(R.drawable.img_sample)
                        .setProfileUserId("kuit.official_1")
                        .setProfileName("쿠잇1")
                        .setPostImage(R.drawable.img_sample2)
                        .setPostContent("첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 ")
                        .build())
                    insert(PostData.Builder()
                        .setProfileImage(R.drawable.img_sample2)
                        .setProfileUserId("kuit.official_1")
                        .setProfileName("쿠잇2")
                        .setPostImage(R.drawable.img_sample)
                        .setPostContent("두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 ")
                        .build())
                }
            }


        }
        CoroutineScope(Dispatchers.IO).launch {
            itemList.addAll(
                homePostDB!!.HomePostDAO().getAll()
            )
        }
    }

    private fun initStoryRV() {
        val urlList = arrayListOf<String>(
            "https://cdn.pixabay.com/photo/2017/02/20/18/03/cat-2083492_1280.jpg",
            "https://cdn.pixabay.com/photo/2015/04/23/21/59/tree-736877_1280.jpg",
            "https://cdn.pixabay.com/photo/2024/02/17/00/18/cat-8578562_1280.jpg",
            "https://cdn.pixabay.com/photo/2019/11/08/11/56/kitten-4611189_1280.jpg",
            "https://cdn.pixabay.com/photo/2024/03/08/09/55/cat-8620369_1280.png",
            "https://cdn.pixabay.com/photo/2019/11/08/11/56/kitten-4611189_1280.jpg"

        )
        homeStoryListAdapter = HomeStoryListAdapter(this, urlList, myData)

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
        postAdapter = PostAdapter(itemList)

        binding.rvHomePostList.adapter = postAdapter
        binding.rvHomePostList.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        postAdapter.setOnItemClickListener(object : PostAdapter.OnItemClickListener {
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