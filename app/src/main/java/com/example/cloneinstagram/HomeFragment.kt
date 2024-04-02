package com.example.cloneinstagram

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cloneinstagram.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private var itemList : ArrayList<HomePostData> = arrayListOf()
    private var HomePostAdapter : HomePostAdapter ?= null

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
        HomePostAdapter = HomePostAdapter(itemList)
        binding.rvPost.adapter = HomePostAdapter
        binding.rvPost.layoutManager = LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false)

        HomePostAdapter!!.setOnItemClickListener(object : HomePostAdapter.OnItemClickListener{

            //포스트의 이름 부분을 눌렀을 때 profile 프래그먼트에 String을 보내고 프래그먼트의 화면으로 교체
            override fun onNameButtonClick(homePostData: HomePostData) {
                val bundle = Bundle()
                //직렬화 객체 전송
                bundle.putSerializable("key", homePostData)

                val ProfileFragment = ProfileFragment()
                ProfileFragment.arguments = bundle

                parentFragmentManager.beginTransaction().replace(R.id.main_frm, ProfileFragment).commit()
            }

            //포스트 옵션 버튼을 눌렀을 때 수정 엑티비티에 String들을 보내고 엑티비티 실행
            override fun onOptionButtonClick(homePostData: HomePostData) {
                val intent = Intent(activity, EditActivity::class.java)
                //직렬화 객체 전송
                intent.putExtra("key", homePostData)
                startActivity(intent)
            }
        })
    }

    private fun initData() {
        itemList.addAll(
            arrayListOf(
                HomePostData("gyu_beanie111", R.drawable.profile_img, R.drawable.post_sample, "유럽 여행은 역사와 문화가 공존하는 거리를 거닐며 느낄 수 있는 특별한 경험이었어요. 건물 하나하나가 살아 숨쉬는 듯한 느낌이 들어 마음이 풍요로워졌어요. #유럽여행 #역사와문화 #거리풍경"),
                HomePostData("gyu_beanie222", R.drawable.profile_img1, R.drawable.post_smaple1, "아름다운 바닷가 풍경을 배경으로 일출을 맞이하는 특별한 순간을 함께했어요. 해가 떠오르는 그 순간은 마치 세상 모든 걱정이 사라진 듯한 기분이 들었어요. #여행 #일출 #바다풍경"),
                HomePostData("gyu_beanie333", R.drawable.profile_img2, R.drawable.post_smaple3, "자연 속으로 떠나는 여행은 마음의 평화를 찾을 수 있는 소중한 시간이었어요. 숲 속 산책으로 자연과의 소통을 느끼며 일상의 소란을 잊을 수 있었어요. #자연 #산책 #힐링"),
                HomePostData("gyu_beanie444", R.drawable.profile_img3, R.drawable.post_smaple2, "호캉스를 즐기며 휴식을 취했던 추억들이 마음 한 구석에 따뜻한 기억으로 남아요. 루프탑 수영장에서의 여유로운 시간은 일상의 스트레스를 모두 잊게 해주었어요. #호캉스 #루프탑수영장 #여유")
            )
        )
    }
}