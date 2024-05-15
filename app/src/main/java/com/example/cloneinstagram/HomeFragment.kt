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
    private var postAdapter : PostAdapter ?= null

    private var storyList: ArrayList<StoryData> = arrayListOf()
    private var storyAdapter: StoryAdapter ?= null

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
        postAdapter = PostAdapter(itemList)
        storyAdapter = StoryAdapter(storyList)

        binding.rvPost.adapter = postAdapter
        binding.rvPost.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)

        binding.rvStory.adapter = storyAdapter
        binding.rvStory.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)



        postAdapter!!.setOnItemClickListener(object : PostAdapter.OnItemClickListener{
            override fun onIdClick(postData: PostData) {
                val bundle = Bundle()

                bundle.putSerializable("key", postData)

                val profileFragment = ProfileFragment()
                profileFragment.arguments = bundle

                parentFragmentManager.beginTransaction().replace(R.id.main_frm, profileFragment).commit()
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
                PostData(R.drawable.harry, "harry_potter", R.drawable.harry_post,"영국의 작가 J. K. 롤링의 판타지 소설 해리 포터 시리즈의 주인공. 풀 네임은 해리 제임스 포터. MBTI는 ISFP, 에니어그램은 9w8로 추정하는 사람들이 많다."),
                PostData(R.drawable.ron, "ronald_weasley", R.drawable.ron_post,"로널드 빌리우스 위즐리 (Ronald Bilius Weasley). 해리 포터 시리즈의 등장인물 중 하나이자 또 다른 주인공. 위즐리 일가의 6남 1녀중 여섯째이자 막내아들이자 지니 위즐리의 오빠이다. 거의 언제나 쓰는 이름인 '론'(Ron)은 로널드(Ronald)의 애칭. 1980년 3월 1일생."),
                PostData(R.drawable.hermione, "hermione_granger", R.drawable.hermione_post,"해리 포터 시리즈의 등장인물. 정식 발매된 번역본의 풀네임은 헤르미온느 진 그레인저. 생일은 1979년 9월 19일이다. 해리 포터의 가장 친한 친구 중 한 명이자 시리즈 내내 사건을 해결해 나가는 삼총사의 일원이다."),
                PostData(R.drawable.snape, "severus_snape", R.drawable.snape_post,"해리 포터 시리즈의 등장인물. 호그와트의 마법약 과목 교수다.")
            )
        )

        storyList.addAll(
            arrayListOf(
                StoryData(R.drawable.img_sample, "내 스토리", true, true),
                StoryData(R.drawable.harry, "harry_potter", false, false),
                StoryData(R.drawable.ron, "ronald_weasley", false, false),
                StoryData(R.drawable.hermione, "hermione_granger", false, false),
                StoryData(R.drawable.snape, "severus_snape", false, false),
            )
        )
    }
}