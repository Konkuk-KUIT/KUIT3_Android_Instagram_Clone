package com.example.cloneinstagram

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cloneinstagram.databinding.FragmentHomeBinding
import com.example.cloneinstagram.databinding.ItemHomePostBinding


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var itemHomePostBinding: ItemHomePostBinding

    private var itemList: ArrayList<PostData> = arrayListOf()
    private var PostAdapter : PostAdapter ?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        itemHomePostBinding = ItemHomePostBinding.inflate(inflater, container, false)

        initData()
        initRecyclerView()

//        옵션 버튼 눌렀을 때
        itemHomePostBinding.ivPostOption.setOnClickListener {
            val intent = Intent(activity, EditActivity::class.java)

            intent.putExtra("nameValue", itemHomePostBinding.tvPostUseridBig.text)
            intent.putExtra("contentValue", itemHomePostBinding.tvPostContent.text)

            startActivity(intent)
        }

//        id 버튼 눌렀을 때
        itemHomePostBinding.tvPostUseridBig.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("nameValue", itemHomePostBinding.tvPostUseridBig.text.toString())

            val profileFragment = ProfileFragment()
            profileFragment.arguments = bundle

            parentFragmentManager.beginTransaction().replace(R.id.main_frm, profileFragment).commit()
        }


        return binding.root
    }

    private fun initRecyclerView() {
        PostAdapter = PostAdapter(itemList)

        binding.rvPost.adapter = PostAdapter
        binding.rvPost.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        PostAdapter!!.setOnItemClickListener(object : PostAdapter.OnItemClickListener{
            override fun onIdClick(postData: PostData) {
                val bundle = Bundle()

                bundle.putSerializable("key", postData)

                val ProfileFragment = ProfileFragment()
                ProfileFragment.arguments = bundle

                parentFragmentManager.beginTransaction().replace(R.id.main_frm, ProfileFragment).commit()
            }

            override fun onOptionClick(postData: PostData) {
                val intent = Intent(requireActivity(), EditActivity::class.java)

                intent.putExtra("key", postData)
                startActivity(intent)
            }
        })
    }

    private fun initData() {
        itemList.addAll(
            arrayListOf(
                PostData(R.drawable.img_sample, "better_1", R.drawable.img_sample2,""),
                PostData(R.drawable.img_sample, "better_2", R.drawable.img_sample2,""),
                PostData(R.drawable.img_sample, "better_3", R.drawable.img_sample2,""),
                PostData(R.drawable.img_sample, "better_4", R.drawable.img_sample2,"")
            )
        )
    }
}