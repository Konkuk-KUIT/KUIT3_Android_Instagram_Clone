package com.example.cloneinstagram

import android.content.Intent
import android.os.Bundle
import android.util.Pair
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cloneinstagram.databinding.ActivityMainBinding
import com.example.cloneinstagram.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private var itemList : ArrayList<PostData> = arrayListOf()
    private var postAdapter : PostAdapter ?= null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        listOf(binding)
        initRecyclerView()
        initData()
        return binding.root
    }

    private fun initData() {
        itemList.addAll(
            arrayListOf(
                PostData(R.drawable.img_forky, R.drawable.img_cloud, "kuit.official","kuit.official","쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요."),
                PostData(R.drawable.img_gromit, R.drawable.img_cloud3, "jjuyaaaaaaa_4","jjuyaaaaaaa_4","안녕하세여. 저희 집 강아지 정구름 사진 보고 가세요."),
                PostData(R.drawable.img_sheep, R.drawable.img_cloud4, "jeongjuyeon","jeongjuyeon","반갑습니다. 반갑습니다. 반갑습니다. 반갑습니다. 반갑습니다. 반갑습니다.")
                )
        )
    }

    private fun initRecyclerView() {
        var postAdapter = PostAdapter(itemList)
        binding.rvPost.adapter = postAdapter
        binding.rvPost.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)


        postAdapter!!.setOnItemClickListener(object : PostAdapter.OnItemClickListener{
            override fun onItemClick(postData: PostData) {
                val idFragment = IdFragment().apply {
                    arguments = bundleOf("key" to postData)
                }
                parentFragmentManager.beginTransaction()
                    .replace(R.id.main_frm, idFragment)
                    .addToBackStack(null)
                    .commit()
            }

            //옵션액티비티 데이터 전달 수정-> 수정 전임
            override fun onItemClick2(postData: PostData) {
                val intent = Intent(context, OptionActivity::class.java)
                startActivity(intent)

                /*intent.putExtra("idvalue", binding.tvHomePost.text)
                intent.putExtra("postcontent", binding.tvPostComment2.text)*/
            }
        })
    }
}

