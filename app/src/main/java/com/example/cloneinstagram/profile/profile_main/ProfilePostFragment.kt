package com.example.cloneinstagram.profile.profile_main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cloneinstagram.R
import com.example.cloneinstagram.databinding.FragmentProfileBinding
import com.example.cloneinstagram.databinding.FragmentProfilePostBinding
import com.example.cloneinstagram.data.PostData
import com.example.cloneinstagram.data.UsersData

class ProfilePostFragment : Fragment() {
    lateinit var binding: FragmentProfilePostBinding
    lateinit var profileBinding: FragmentProfileBinding
    private val urlList = arrayListOf<String>()
    private val itemList = arrayListOf<PostData>()
    private lateinit var profilePostAdapter: ProfilePostAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfilePostBinding.inflate(inflater, container, false)
        profileBinding = FragmentProfileBinding.inflate(inflater, container, false)

        val data = arguments?.getSerializable("usersData") as UsersData

        initUrlList()
        initItemData(data)
        initRV()

        return binding.root
    }

    private fun initRV() {
        profilePostAdapter = ProfilePostAdapter(this, itemList)
        binding.rvProfilePost.adapter = profilePostAdapter
        binding.rvProfilePost.layoutManager = GridLayoutManager(context, 3)

        profilePostAdapter.setOnItemClickListener(object : ProfilePostAdapter.OnItemClickListener {

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
    private fun initItemData(data: UsersData) {
        for (i in 0..13) {
            itemList.add(
                PostData.Builder()
                    .setProfileImage(data.profileImage)
                    .setProfileUserId(data.profileUserId)
                    .setProfileName(data.userName)
                    .setPostImageURL(urlList[i])
                    .setPostContent("쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요. 쿠잇 3기 시작합니다!! 다들 열심히 한 학기 마무리해봐요.")
                    .build()
            )
        }
    }

    private fun initUrlList() {
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
}