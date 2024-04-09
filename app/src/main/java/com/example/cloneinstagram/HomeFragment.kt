package com.example.cloneinstagram

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cloneinstagram.databinding.FragmentHomeBinding
import com.example.cloneinstagram.databinding.ItemHomePostBinding


class HomeFragment : Fragment() {

//    lateinit var binding:ItemHomePostBinding
    lateinit var binding2:FragmentHomeBinding
    private var itemList : ArrayList<ItemHomePostData> = arrayListOf()
    private var adapter : HomeAdapter ?= null

    @SuppressLint("CommitTransaction")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        binding = ItemHomePostBinding.inflate(inflater, container, false)
        binding2 = FragmentHomeBinding.inflate(inflater, container, false)

//        val moreText = binding.tvHomePostingContentMore
//        val text = binding.tvHomePostingContent
//        val option = binding.ivHomePostingOption
//        val profileName = binding.tvHomePostingProfileName

//        option.setOnClickListener{
//            val intent = Intent(activity, EditActivity::class.java)
//            intent.putExtra("id", binding.tvHomePostingProfileName.text)
//            intent.putExtra("content", binding.tvHomePostingContent.text)
//            startActivity(intent)
//        }
//
//        moreText.setOnClickListener {
//            text.width = WindowManager.LayoutParams.WRAP_CONTENT
//            text.maxLines = 100
//            moreText.visibility = View.GONE
//        }
//
//        profileName.setOnClickListener {
//            val bundle = Bundle()
//            val profileFragment = ProfileFragment()
//            bundle.putString("id", binding.tvHomePostingProfileName.text.toString())
//            profileFragment.setArguments(bundle)
//
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.main_frm, profileFragment)
//                .commit()
//
//        }

        //===========================================   3주차

        //작업순서
        // 1. recyclerView 배치 Layout 생성하기
        // 2. Item view 생성
        // 3. 데이터 클래스 생성
        // 4. Adapter 생성
        // 5. Activity 혹은 Fragment에 Adapter 생성 및 연결

        initializeDataSet()
        initialRecyclerView()

        return binding2.root
    }

    private fun initialRecyclerView(){
        adapter = HomeAdapter(itemList)
        binding2.rvHomePosting.adapter = adapter
        binding2.rvHomePosting.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        adapter!!.setOnItemClickListener(object : HomeAdapter.OnItemClickListener{
            override fun onItemCLick(item: ItemHomePostData) {
                //이 코드는 Profile 화면이 Fragment일 때 bundle arugument로 전달한다.
                val bundle = Bundle()
                val profileFragment = ProfileFragment()
                bundle.putString("id", item.instagramId)
                bundle.putInt("imageId", item.imageId)
                profileFragment.setArguments(bundle)

                parentFragmentManager.beginTransaction()
                    .replace(R.id.main_frm, profileFragment)
                    .commit()

            }

        })
    }

    private fun initializeDataSet(){
        itemList.addAll(
            arrayListOf(
                ItemHomePostData(R.drawable.img_sample3, "user1", R.drawable.img_sample3, "여러분 그거 아시나요? 벚꽃의 꽃말은 중간고사 랍니다. 하하하. 빨리 종강시켜줘. 공부는 좋지만 시험은 싫어."),
                ItemHomePostData(R.drawable.img_sample4, "user2", R.drawable.img_sample4, "안드로이드 너무 어려워요. 워크북 너무 오래 걸려요. 거의 체감상 서버랑 비슷한 느낌. 안드도 재밌지만 서버하고 싶어요"),
                ItemHomePostData(R.drawable.img_sample5, "user3", R.drawable.img_sample5, "새벽 3시 경에 건국대학교에서 이상한 일들이 많이 일어난다는 사실 알고 계셨나요? 도서관 앞 동상이 책장을 넘기기도 하고, 일감호 한가운 데서 누군가 물위흫 걸어다닌데요")
            )
        )
    }
}