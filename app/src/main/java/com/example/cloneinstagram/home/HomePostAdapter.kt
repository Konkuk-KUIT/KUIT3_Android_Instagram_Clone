package com.example.cloneinstagram.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneinstagram.data.PostData
import com.example.cloneinstagram.databinding.ItemPostHomeBinding

class HomePostAdapter(val items : ArrayList<PostData>) : RecyclerView.Adapter<HomePostAdapter.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener
    private val CLICK_USERID = 1 // user id 클릭
    private val CLICK_SHOWMORE = 2 // 더보기 클릭
    private val CLICK_OPTIONS = 3 // 게시글 수정 클릭

    interface OnItemClickListener{
        fun onIdClick(postData: PostData)
        fun onShowMoreClick(postData: PostData, itemBinding : ItemPostHomeBinding)
        fun onOptionClick(postData: PostData)
    }

    fun setOnItemClickListener(onItemClickListener : OnItemClickListener){
        itemClickListener = onItemClickListener
    }

    inner class ViewHolder(val binding: ItemPostHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PostData) {
            binding.sivItemProfileImage.setImageResource(item.profileImage)
            binding.tvItemUserId.text = item.profileUserId
            binding.ivItemPostImage.setImageResource(item.postImage)
            binding.tvItemPostContents.text = item.postContent

            binding.tvItemUserId.setOnClickListener {
                itemClickListener.onIdClick(item)
            }
            binding.tvItemPostShowMore.setOnClickListener {
                itemClickListener.onShowMoreClick(item, binding)
            }
            binding.ivItemPostImageOptions.setOnClickListener {
                itemClickListener.onOptionClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPostHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

}