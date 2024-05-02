package com.example.cloneinstagram.profile.profile_main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cloneinstagram.R
import com.example.cloneinstagram.databinding.FragmentProfileBinding
import com.example.cloneinstagram.databinding.FragmentProfilePostBinding
import com.example.cloneinstagram.home.HomeFragment
import com.example.cloneinstagram.home.PostData
import java.io.Serializable

class ProfilePostFragment : Fragment() {
    lateinit var binding : FragmentProfilePostBinding
    lateinit var profileBinding: FragmentProfileBinding
    private val urlList = arrayListOf<String>()
    private val itemList = arrayListOf<PostData>()
    private lateinit var profilePostAdapter: ProfilePostAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfilePostBinding.inflate(inflater, container, false)
        profileBinding = FragmentProfileBinding.inflate(inflater, container, false)
        initList()
        initData()
        initAdapter()

//        initGlide()
//        initListener()

        return binding.root
    }

    private fun initData() {
        for (i in 0..13) {
            val profileUserId : String = profileBinding.tvProfileUserId.text.toString()
            itemList.add(
                PostData.Builder()
                    .setProfileImageView(profileBinding.sivProfileProfileImage)
                    .setProfileUserId(profileUserId)
                    .setPostImageURL(urlList[i])
                    .setPostContent("쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요.")
                    .build()
            )
        }
    }

    private fun initAdapter() {
        profilePostAdapter = ProfilePostAdapter(this, itemList)
        binding.rvProfilePost.adapter = profilePostAdapter
        binding.rvProfilePost.layoutManager = GridLayoutManager(context, 3)
        profilePostAdapter.setOnItemClickListener(object : ProfilePostAdapter.OnItemClickListener{
            override fun setOnItemClickListener(postData: PostData) {
                val profileDetailPostFragment = ProfileDetailPostFragment()
                profileDetailPostFragment.arguments = bundleOf("data" to postData)
                parentFragment?.parentFragmentManager?.beginTransaction()
                    ?.replace(R.id.main_frm, profileDetailPostFragment)
                    ?.addToBackStack(null)
                    ?.commit()

            }

        })
    }

    private fun initList() {
        urlList.add("https://cdn.pixabay.com/photo/2019/08/07/14/11/dog-4390885_1280.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2019/07/23/13/51/shepherd-dog-4357790_1280.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2018/05/11/08/11/dog-3389729_1280.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2018/05/26/18/06/dog-3431913_1280.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2021/01/26/17/18/cavalier-king-charles-spaniel-5952324_640.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2014/11/30/14/11/cat-551554_1280.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2017/07/25/01/22/cat-2536662_960_720.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2014/04/13/20/49/cat-323262_960_720.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2013/05/30/18/21/cat-114782_1280.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2023/03/19/20/59/rabbit-7863312_1280.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2020/02/29/18/59/rabbit-4890861_1280.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2023/03/21/20/01/otter-7868090_1280.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2020/03/01/15/30/fox-4893199_1280.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2023/10/17/05/25/fox-squirrel-8320423_960_720.jpg")
    }

//    private fun initListener() {
//        val profileDetailPostFragment = ProfileDetailPostFragment()
//
//        binding.ivProfilePost1.setOnClickListener{
//            val dummyData = DummyData(
//                profileBinding.sivProfileProfileImage, profileBinding.tvProfileUserId, binding.ivProfilePost1,
//                "쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요.")
//            profileDetailPostFragment.arguments = bundleOf("data" to dummyData)
//            val profileListFragment = ProfileListFragment()
////            parentFragmentManager.beginTransaction()
////                .replace(R.id.main_frm, profileListFragment)
////                .addToBackStack(null)
////                .commit()
//
//            parentFragment?.parentFragmentManager?.beginTransaction()
//                ?.replace(R.id.main_frm, profileListFragment)
//                ?.commit()
//        }
//        binding.ivProfilePost2.setOnClickListener{
//            val dummyData = DummyData(
//                profileBinding.sivProfileProfileImage, profileBinding.tvProfileUserId, binding.ivProfilePost2,
//                "쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요.")
//            profileDetailPostFragment.arguments = bundleOf("data" to dummyData)
//
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.main_frm, profileDetailPostFragment)
//                .addToBackStack(null)
//                .commit()
//        }
//        binding.ivProfilePost3.setOnClickListener{
//            val dummyData = DummyData(
//                profileBinding.sivProfileProfileImage, profileBinding.tvProfileUserId, binding.ivProfilePost3,
//                "쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요.")
//            profileDetailPostFragment.arguments = bundleOf("data" to dummyData)
//
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.main_frm, profileDetailPostFragment)
//                .addToBackStack(null)
//                .commit()
//        }
//        binding.ivProfilePost4.setOnClickListener{
//            val dummyData = DummyData(
//                profileBinding.sivProfileProfileImage, profileBinding.tvProfileUserId, binding.ivProfilePost4,
//                "쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요.")
//            profileDetailPostFragment.arguments = bundleOf("data" to dummyData)
//
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.main_frm, profileDetailPostFragment)
//                .addToBackStack(null)
//                .commit()
//        }
//        binding.ivProfilePost5.setOnClickListener{
//            val dummyData = DummyData(
//                profileBinding.sivProfileProfileImage, profileBinding.tvProfileUserId, binding.ivProfilePost5,
//                "쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요.")
//            profileDetailPostFragment.arguments = bundleOf("data" to dummyData)
//
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.main_frm, profileDetailPostFragment)
//                .addToBackStack(null)
//                .commit()
//        }
//        binding.ivProfilePost6.setOnClickListener{
//            val dummyData = DummyData(
//                profileBinding.sivProfileProfileImage, profileBinding.tvProfileUserId, binding.ivProfilePost6,
//                "쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요.")
//            profileDetailPostFragment.arguments = bundleOf("data" to dummyData)
//
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.main_frm, profileDetailPostFragment)
//                .addToBackStack(null)
//                .commit()
//        }
//        binding.ivProfilePost7.setOnClickListener{
//            val dummyData = DummyData(
//                profileBinding.sivProfileProfileImage, profileBinding.tvProfileUserId, binding.ivProfilePost7,
//                "쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요.")
//            profileDetailPostFragment.arguments = bundleOf("data" to dummyData)
//
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.main_frm, profileDetailPostFragment)
//                .addToBackStack(null)
//                .commit()
//        }
//        binding.ivProfilePost8.setOnClickListener{
//            val dummyData = DummyData(
//                profileBinding.sivProfileProfileImage, profileBinding.tvProfileUserId, binding.ivProfilePost8,
//                "쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요.")
//            profileDetailPostFragment.arguments = bundleOf("data" to dummyData)
//
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.main_frm, profileDetailPostFragment)
//                .addToBackStack(null)
//                .commit()
//        }
//        binding.ivProfilePost9.setOnClickListener{
//            val dummyData = DummyData(
//                profileBinding.sivProfileProfileImage, profileBinding.tvProfileUserId, binding.ivProfilePost9,
//                "쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요.")
//            profileDetailPostFragment.arguments = bundleOf("data" to dummyData)
//
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.main_frm, profileDetailPostFragment)
//                .addToBackStack(null)
//                .commit()
//        }
//        binding.ivProfilePost10.setOnClickListener{
//            val dummyData = DummyData(
//                profileBinding.sivProfileProfileImage, profileBinding.tvProfileUserId, binding.ivProfilePost10,
//                "쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요.")
//            profileDetailPostFragment.arguments = bundleOf("data" to dummyData)
//
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.main_frm, profileDetailPostFragment)
//                .addToBackStack(null)
//                .commit()
//        }
//        binding.ivProfilePost11.setOnClickListener{
//            val dummyData = DummyData(
//                profileBinding.sivProfileProfileImage, profileBinding.tvProfileUserId, binding.ivProfilePost11,
//                "쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요.")
//            profileDetailPostFragment.arguments = bundleOf("data" to dummyData)
//
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.main_frm, profileDetailPostFragment)
//                .addToBackStack(null)
//                .commit()
//        }
//        binding.ivProfilePost12.setOnClickListener{
//            val dummyData = DummyData(
//                profileBinding.sivProfileProfileImage, profileBinding.tvProfileUserId, binding.ivProfilePost12,
//                "쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요.")
//            profileDetailPostFragment.arguments = bundleOf("data" to dummyData)
//
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.main_frm, profileDetailPostFragment)
//                .addToBackStack(null)
//                .commit()
//        }
//        binding.ivProfilePost13.setOnClickListener{
//            val dummyData = DummyData(
//                profileBinding.sivProfileProfileImage, profileBinding.tvProfileUserId, binding.ivProfilePost13,
//                "쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요.")
//            profileDetailPostFragment.arguments = bundleOf("data" to dummyData)
//
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.main_frm, profileDetailPostFragment)
//                .addToBackStack(null)
//                .commit()
//        }
//        binding.ivProfilePost14.setOnClickListener{
//            val dummyData = DummyData(
//                profileBinding.sivProfileProfileImage, profileBinding.tvProfileUserId, binding.ivProfilePost14,
//                "쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요.")
//            profileDetailPostFragment.arguments = bundleOf("data" to dummyData)
//
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.main_frm, profileDetailPostFragment)
//                .addToBackStack(null)
//                .commit()
//        }
//    }

//    private fun initGlide() {
//        Glide.with(this)
//            .load(urlList[0])
//            .into(binding.ivProfilePost1)
//        Glide.with(this)
//            .load(R.drawable.ic_create)
//            .into(binding.ivProfilePost2)
//        Glide.with(this)
//            .load(urlList[2])
//            .into(binding.ivProfilePost3)
//        Glide.with(this)
//            .load(urlList[3])
//            .into(binding.ivProfilePost4)
//        Glide.with(this)
//            .load(urlList[4])
//            .into(binding.ivProfilePost5)
//        Glide.with(this)
//            .load(urlList[5])
//            .into(binding.ivProfilePost6)
//        Glide.with(this)
//            .load(urlList[6])
//            .into(binding.ivProfilePost7)
//        Glide.with(this)
//            .load(urlList[7])
//            .into(binding.ivProfilePost8)
//        Glide.with(this)
//            .load(urlList[8])
//            .into(binding.ivProfilePost9)
//        Glide.with(this)
//            .load(urlList[9])
//            .into(binding.ivProfilePost10)
//        Glide.with(this)
//            .load(urlList[10])
//            .into(binding.ivProfilePost11)
//        Glide.with(this)
//            .load(urlList[11])
//            .into(binding.ivProfilePost12)
//        Glide.with(this)
//            .load(urlList[12])
//            .into(binding.ivProfilePost13)
//        Glide.with(this)
//            .load(urlList[13])
//            .into(binding.ivProfilePost14)
//
//    }

}