package com.example.clonecodinginstagram

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.Fragment
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
        itembinding = ItemPostBinding.inflate(inflater,binding.rcPost,false)
        itembinding.icMenu.setOnClickListener{
            val intent = Intent(this.activity, MenuActivity::class.java)
            intent.putExtra("id",itembinding.textId.text)
            intent.putExtra("writing", itembinding.textWriting.text)
            startActivity(intent)
        }

        val strid = itembinding.textId.text.toString()
        val strname = "쿠잇"

        parentFragmentManager.beginTransaction()
            .replace(R.id.ic_circle,ProfileFragment())
            .commit()

        parentFragmentManager.beginTransaction()
            .replace(R.id.profile5,ProfileFragment2().apply {
                arguments = Bundle().apply { putString("id",strid)
                    putString("name", strname)}
            })
            .commit()

        initData()
        initRecyclerView()
        return binding.root
    }

    private fun initRecyclerView() {
        postadapter = PostAdapter(items)
        binding.rcPost.adapter = postadapter
        binding.rcPost.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.VERTICAL,false)
    }

    private fun initData() {
        items.addAll(
            arrayListOf(PostData(R.drawable.img_sample.toDrawable(), "kuit_official", "content"),
                    PostData(R.drawable.img_sample.toDrawable(), "kuit_official", "content2"))
        )
    }

}