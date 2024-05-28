package com.example.clonecodinginstagram

import android.content.Context
import android.content.Intent
import android.location.GnssAntennaInfo.Listener
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.clonecodinginstagram.databinding.FragmentHomeBinding
import com.example.clonecodinginstagram.databinding.ItemPostBinding
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var itembinding: ItemPostBinding
    private var items : ArrayList<PostData> = arrayListOf()
    private var postadapter : PostAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        itembinding = ItemPostBinding.inflate(inflater,container,false)
        initRecyclerView()
        parentFragmentManager.beginTransaction()
            .replace(R.id.ic_circle,ProfileFragment())
            .commit()

        initData()
        initRecyclerView()
        return binding.root
    }
    private fun initRecyclerView() {

        postadapter = PostAdapter(items,{
            itembinding.icMenu
            profileClick1()
        }) {
            itembinding.icProfile5
            profileClick2()
        }

        binding.rcPost.adapter = postadapter
        binding.rcPost.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.VERTICAL,false)
    }

    private fun profileClick1(){
        val strid = itembinding.textId.text.toString()
        val strname = "쿠잇"
        parentFragmentManager.beginTransaction()
            .replace(R.id.main_frm, ProfileScreenFragment().apply {
                arguments = Bundle().apply {
                    putString("id", strid)
                    putString("name", strname)
                }
            })
            .commit()
    }
    private fun profileClick2(){
        val strid = itembinding.textId.text.toString()
        val strname = "쿠잇"
        var intent = Intent(this.activity,MenuActivity::class.java)
        intent.putExtra("strid", strid)
        intent.putExtra("strname",strname)
        startActivity(intent)
    }

    private fun initData() {
        val spf_homePost = requireContext().getSharedPreferences("home_post", Context.MODE_PRIVATE)

        // 1번 바로 가져와서 쓰기 (싱글톤 제한 x)

        val homePostDB = Room.databaseBuilder(
            requireContext(),
            HomePostDB::class.java,
            "homepost-database"
        ).allowMainThreadQueries().build()

        Log.d("test", spf_homePost.getBoolean("isInit",false).toString())

        if ( !spf_homePost.getBoolean("isInit", false)){

            viewLifecycleOwner.lifecycleScope.launch {
                with(spf_homePost.edit()){
                    putBoolean("isInit",true)
                    commit()
                }
                with(homePostDB.HomePostDao()){
                insert(PostData(R.drawable.img_sample, "kuit_official", "content"))
                insert(PostData(R.drawable.img_sample2, "kuit_official", "content2"))
                }
                items.addAll(
                    homePostDB.HomePostDao().getAll()
                )
            }

        }

    }
}