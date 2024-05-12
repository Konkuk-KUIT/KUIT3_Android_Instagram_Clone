package com.example.cloneinstagram

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
import androidx.room.Room
import com.example.cloneinstagram.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private var StoryitemList : ArrayList<HomeStoryData> = arrayListOf()
    private var PostitemList : ArrayList<HomePostData> = arrayListOf()
    private var HomePostAdapter : HomePostAdapter ?= null
    private var HomeStoryAdapter : HomeStoryAdapter ?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        //데이터 생성
        initData()
        //RecyclerView 생성
        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        HomePostAdapter = HomePostAdapter(PostitemList)
        HomeStoryAdapter = HomeStoryAdapter(StoryitemList)
        binding.rvStory.adapter = HomeStoryAdapter
        binding.rvStory.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvPost.adapter = HomePostAdapter
        binding.rvPost.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)

        HomePostAdapter!!.setOnItemClickListener(object : HomePostAdapter.OnItemClickListener{

            //포스트의 이름 부분을 눌렀을 때 profile 프래그먼트에 String을 보내고 프래그먼트의 화면으로 교체
            override fun onNameButtonClick(homePostData: HomePostData) {
                val bundle = Bundle()
                //직렬화 객체 전송
                bundle.putSerializable("key", homePostData)

                val ProfileFragment = ProfileFragment()
                ProfileFragment.arguments = bundle
                
                //번들로 데이터를 전달하는 다른 방법
                /*val profileFragment = ProfileFragment().apply {
                    arguments = bundleOf("key" to homePostData)
                }*/

                parentFragmentManager.beginTransaction().replace(R.id.main_frm, ProfileFragment).addToBackStack(null).commit()
            }

            //포스트 옵션 버튼을 눌렀을 때 수정 엑티비티에 String들을 보내고 엑티비티 실행
            override fun onOptionButtonClick(homePostData: HomePostData) {
                val intent = Intent(requireActivity(), EditActivity::class.java)
                //직렬화 객체 전송
                intent.putExtra("key", homePostData)
                startActivity(intent)
            }
        })


    }

    private fun initData() {
        val spf_homePost: SharedPreferences = requireContext().getSharedPreferences("home_post5", Context.MODE_PRIVATE)
        val spf_homeStory: SharedPreferences = requireContext().getSharedPreferences("home_story5", Context.MODE_PRIVATE)

        //1번 바로 가져와서 쓰기 (싱클톤 패턴 x)
        /*val homePostDB = Room.databaseBuilder(
            requireContext(),
            HomePostDB::class.java,
            "homepost-database"
        ).allowMainThreadQueries().build()*/
        
        //2번 싱글톤 패턴 이용
        val homePostDB = HomePostDB.getInstance(requireContext())
        Log.d("test", spf_homePost.getBoolean("isInit", false).toString())

        if(!spf_homePost.getBoolean("isInit", false)){
            /*with(spf_homePost.edit()){
                putBoolean("isInit", true)
                apply()
            }

            with(homePostDB!!.HomePostDao()){
                insert(HomePostData("gyu_beanie111", R.drawable.profile_img, R.drawable.post_sample, "유럽 여행은 역사와 문화가 공존하는 거리를 거닐며 느낄 수 있는 특별한 경험이었어요. 건물 하나하나가 살아 숨쉬는 듯한 느낌이 들어 마음이 풍요로워졌어요. #유럽여행 #역사와문화 #거리풍경"))
                insert(HomePostData("gyu_beanie222", R.drawable.profile_img1, R.drawable.post_smaple1, "아름다운 바닷가 풍경을 배경으로 일출을 맞이하는 특별한 순간을 함께했어요. 해가 떠오르는 그 순간은 마치 세상 모든 걱정이 사라진 듯한 기분이 들었어요. #여행 #일출 #바다풍경"))
                insert(HomePostData("gyu_beanie333", R.drawable.profile_img2, R.drawable.post_smaple3, "자연 속으로 떠나는 여행은 마음의 평화를 찾을 수 있는 소중한 시간이었어요. 숲 속 산책으로 자연과의 소통을 느끼며 일상의 소란을 잊을 수 있었어요. #자연 #산책 #힐링"))
                insert(HomePostData("gyu_beanie444", R.drawable.profile_img3, R.drawable.post_smaple2, "호캉스를 즐기며 휴식을 취했던 추억들이 마음 한 구석에 따뜻한 기억으로 남아요. 루프탑 수영장에서의 여유로운 시간은 일상의 스트레스를 모두 잊게 해주었어요. #호캉스 #루프탑수영장 #여유"))
                insert(HomePostData("gyu_beanie555", R.drawable.img_sample, R.drawable.img_sample2, "더보기 버튼 없는 거"))
            }*/

            CoroutineScope(Dispatchers.IO).launch {
                with(spf_homePost.edit()) {
                    putBoolean("isInit", true)
                    apply()
                }

                with(homePostDB!!.HomePostDao()) {
                    insert(
                        HomePostData(
                            "gyu_beanie111",
                            R.drawable.profile_img,
                            R.drawable.post_sample,
                            "유럽 여행은 역사와 문화가 공존하는 거리를 거닐며 느낄 수 있는 특별한 경험이었어요. 건물 하나하나가 살아 숨쉬는 듯한 느낌이 들어 마음이 풍요로워졌어요. #유럽여행 #역사와문화 #거리풍경"
                        )
                    )
                    insert(
                        HomePostData(
                            "gyu_beanie222",
                            R.drawable.profile_img1,
                            R.drawable.post_smaple1,
                            "아름다운 바닷가 풍경을 배경으로 일출을 맞이하는 특별한 순간을 함께했어요. 해가 떠오르는 그 순간은 마치 세상 모든 걱정이 사라진 듯한 기분이 들었어요. #여행 #일출 #바다풍경"
                        )
                    )
                    insert(
                        HomePostData(
                            "gyu_beanie333",
                            R.drawable.profile_img2,
                            R.drawable.post_smaple3,
                            "자연 속으로 떠나는 여행은 마음의 평화를 찾을 수 있는 소중한 시간이었어요. 숲 속 산책으로 자연과의 소통을 느끼며 일상의 소란을 잊을 수 있었어요. #자연 #산책 #힐링"
                        )
                    )
                    insert(
                        HomePostData(
                            "gyu_beanie444",
                            R.drawable.profile_img3,
                            R.drawable.post_smaple2,
                            "호캉스를 즐기며 휴식을 취했던 추억들이 마음 한 구석에 따뜻한 기억으로 남아요. 루프탑 수영장에서의 여유로운 시간은 일상의 스트레스를 모두 잊게 해주었어요. #호캉스 #루프탑수영장 #여유"
                        )
                    )
                    insert(
                        HomePostData(
                            "gyu_beanie555",
                            R.drawable.img_sample,
                            R.drawable.img_sample2,
                            "더보기 버튼 없는 거"
                        )
                    )
                }
            }
        }

        //싱글톤 패턴 이용
        val homeStoryDB = HomeStoryDB.getInstance(requireContext())
        Log.d("test1", spf_homeStory.getBoolean("isInit", false).toString())

        if(!spf_homeStory.getBoolean("isInit", false)){

            CoroutineScope(Dispatchers.IO).launch {
                with(spf_homeStory.edit()) {
                    putBoolean("isInit", true)
                    apply()
                }
                with(homeStoryDB!!.HomeStoryDao()) {
                    insert(HomeStoryData("gyu_beanie111", R.drawable.profile_img))
                    insert(HomeStoryData("gyu_beanie222", R.drawable.profile_img1))
                    insert(HomeStoryData("gyu_beanie333", R.drawable.profile_img2))
                    insert(HomeStoryData("gyu_beanie444", R.drawable.profile_img3))
                    insert(HomeStoryData("gyu_beanie555", R.drawable.img_sample))
                }
            }
        }


        CoroutineScope(Dispatchers.IO).launch {
            PostitemList.addAll(
                homePostDB!!.HomePostDao().getALL()
            )
        }

        CoroutineScope(Dispatchers.IO).launch {
            StoryitemList.addAll(
                homeStoryDB!!.HomeStoryDao().getALL()
            )
        }


    }
}