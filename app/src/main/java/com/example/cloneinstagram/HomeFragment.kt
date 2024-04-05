package com.example.cloneinstagram

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.cloneinstagram.databinding.FragmentHomeBinding
import com.example.cloneinstagram.databinding.ItemPostHomeBinding

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
        val CLICK_USERID = 1 // user id 클릭
        val CLICK_SHOWMORE = 2 // 더보기 클릭
        val CLICK_OPTIONS = 3 // 게시글 수정 클릭
        postAdapter = PostAdapter(itemList)
        binding.rvHomePostList.adapter = postAdapter

//        binding.tvItemUserId.setOnClickListener {
//            itemClickListener.onItemClick(item, CLICK_USERID)
//        }
//        binding.tvItemPostShowMore.setOnClickListener {
//            itemClickListener.onItemClick(item, CLICK_SHOWMORE)
//        }
//        binding.ivItemPostImageOptions.setOnClickListener {
//            itemClickListener.onItemClick(item, CLICK_OPTIONS)
//        }
        binding.rvHomePostList.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        postAdapter.setOnItemClickListener(object :PostAdapter.OnItemClickListener{
            override fun onItemClick(postData: PostData, type: Int, itemPostHomeBinding: ItemPostHomeBinding) {
                when(type) {
                    CLICK_USERID -> {
                        val profileFragment = ProfileFragment()
                        profileFragment.arguments = bundleOf("data" to postData)

                        parentFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, profileFragment)
                            .addToBackStack(null)
                            .commit()
                    }
                    CLICK_SHOWMORE -> {
                        itemPostHomeBinding.tvItemPostContents.maxLines = 4
                        itemPostHomeBinding.tvItemPostContents.layoutParams.width = 260//
                        itemPostHomeBinding.tvItemPostShowMore.visibility = View.GONE
                    }
                    CLICK_OPTIONS -> {
                        val intent = Intent(activity, EditActivity::class.java)
                        intent.putExtra("data", postData)
                        startActivity(intent)
                    }
                }
            }
        })
    }

    private fun initData() {
        itemList.addAll(
            arrayListOf(
                PostData(R.drawable.img_sample, "kuit.official_1", R.drawable.img_sample2,
                    "첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 첫번째 게시물 "),
                PostData(R.drawable.img_sample2, "kuit.official_2", R.drawable.img_sample,
                    "두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 두번째 게시물 ")
            )
        )
    }
}