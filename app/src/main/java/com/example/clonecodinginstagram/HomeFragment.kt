package com.example.clonecodinginstagram

import android.content.Intent
import android.location.GnssAntennaInfo.Listener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clonecodinginstagram.databinding.FragmentHomeBinding
import com.example.clonecodinginstagram.databinding.ItemPostBinding


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
        items.addAll(
            arrayListOf(PostData(R.drawable.img_sample, "kuit_official", "content"),
                    PostData(R.drawable.img_sample2, "kuit_official", "content2"))
        )
    }
}