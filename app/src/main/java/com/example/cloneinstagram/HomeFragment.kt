package com.example.cloneinstagram

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cloneinstagram.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private var itemList:ArrayList<PostData> =arrayListOf()
    private var postAdapter:PostAdapter?=null

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
        postAdapter= PostAdapter(itemList)
        binding.rvHomePost.adapter=postAdapter
        binding.rvHomePost.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        postAdapter!!.setOnItemClickListener(object : PostAdapter.OnItemClickListener{
            override fun onMoreClick(postData: PostData) {
                val intent= Intent(requireActivity(), EditActivity::class.java)
                intent.putExtra("postKey", postData)
                startActivity(intent)
            }

            override fun onNameClick(postData: PostData) {
                val fragment=ProfileFragment()
                val bundle=Bundle()
                bundle.putSerializable("nameKey",postData)
                fragment.arguments=bundle
                parentFragmentManager.beginTransaction()
                    .replace(com.example.cloneinstagram.R.id.main_frm,fragment)
                    .commit()
            }

        })
    }

    private fun initData() {


        itemList.addAll(
            arrayListOf(
                PostData(R.drawable.img_sample_pamyo, R.drawable.img_sample_pamyo,"kimgoeun","미국 LA, 거액의 의뢰를 받은 무당 ‘화림’(김고은)과 ‘봉길’(이도현)은 기이한 병이 대물림되는 집안의 장손을 만난다. 조상의 묫자리가 화근임을 알아챈 ‘화림’은 이장을 권하고, 돈 냄새를 맡은 최고의 풍수사 ‘상덕’(최민식)과 장의사 ‘영근’(유해진)이 합류한다. “전부 잘 알 거야… 묘 하나 잘못 건들면 어떻게 되는지” 절대 사람이 묻힐 수 없는 악지에 자리한 기이한 묘. ‘상덕’은 불길한 기운을 느끼고 제안을 거절하지만, ‘화림’의 설득으로 결국 파묘가 시작되고… 나와서는 안될 것이 나왔다."),
                PostData(R.drawable.img_sample_dune, R.drawable.img_sample_dune,"dune2", "황제의 모략으로 멸문한 가문의 유일한 후계자 폴.(티모시 샬라메) 어머니 레이디 제시카(레베카 퍼거슨)와 간신히 목숨만 부지한 채 사막으로 도망친다. 그곳에서 만난 반란군들과 숨어 지내다 그들과 함께 황제의 모든 것을 파괴할 전투를 준비한다. 한편 반란군들의 기세가 높아질수록 불안해진 황제와 귀족 가문은 잔혹한 암살자 페이드 로타(오스틴 버틀러)를 보내 반란군을 몰살하려 하는데… 운명의 반격이 시작된다!"),
                PostData(R.drawable.img_sample_rainy, R.drawable.img_sample_rainy,"RainyDayInNewYork","상상해 봐요 막 떨어지기 시작한 빗방울 센트럴 파크 델라코트 시계 아래 누군가 당신을 기다리고 있다면... 재즈를 사랑하는 ‘개츠비’(티모시 샬라메) 영화에 푹 빠진 ‘애슐리’(엘르 패닝) 뉴욕이 좋은 ‘챈’(셀레나 고메즈) 매력적인 세 남녀가 선사하는 로맨틱 해프닝!"),
                PostData(R.drawable.img_sample_wonka, R.drawable.img_sample_wonka,"wonka", "세상에서 가장 달콤한 여정 좋은 일은 모두 꿈에서부터 시작된다! 마법사이자 초콜릿 메이커 ‘윌리 웡카’의 꿈은 디저트의 성지, ‘달콤 백화점’에 자신만의 초콜릿 가게를 여는 것. 가진 것이라고는 낡은 모자 가득한 꿈과 단돈 12소버린 뿐이지만 특별한 마법의 초콜릿으로 사람들을 사로잡을 자신이 있다. 하지만 먹을 것도, 잠잘 곳도, 의지할 사람도 없는 상황 속에서 낡은 여인숙에 머물게 된 ‘웡카’는 ‘스크러빗 부인’과 ‘블리처’의 계략에 빠져 눈더미처럼 불어난 숙박비로 인해 순식간에 빚더미에 오른다. 게다가 밤마다 초콜릿을 훔쳐가는 작은 도둑 ‘움파 룸파’의 등장과 ‘달콤 백화점’을 독점한 초콜릿 카르텔의 강력한 견제까지. 세계 최고의 초콜릿 메이커가 되는 길은 험난하기만 한데…" )
            )
        )
    }


}