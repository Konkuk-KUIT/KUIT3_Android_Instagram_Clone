package com.example.cloneinstagram

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cloneinstagram.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        //포스트 옵션 버튼을 눌렀을 때 수정 엑티비티에 String들을 보내고 엑티비티 실행
        binding.ivHomePostOption.setOnClickListener {
            val intent = Intent(activity, EditActivity::class.java)
            intent.putExtra("NameChange", binding.tvHomePost.text)
            intent.putExtra("ContentChange", binding.tvHomeComment1.text)
            startActivity(intent)
        }

        //포스트의 이름 부분을 눌렀을 때 profile 프래그먼트에 String을 보내고 프래그먼트의 화면으로 교체
        binding.tvHomePost.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("NameChange", binding.tvHomePost.text.toString()) 
            
            val ProfileFragment = ProfileFragment()
            ProfileFragment.arguments = bundle

            parentFragmentManager.beginTransaction().replace(R.id.main_frm, ProfileFragment).commit()
        }
        
        //포스트 댓글의 더보기 버튼을 눌렀을 때 댓글의 나머지 부분 표시
        binding.tvPostCommentPlus.setOnClickListener {
            binding.tvPostCommentPlus.visibility = View.GONE
            binding.tvHomeComment1.ellipsize = null
            binding.tvHomeComment1.maxLines = Int.MAX_VALUE
        }

        return binding.root
    }
}