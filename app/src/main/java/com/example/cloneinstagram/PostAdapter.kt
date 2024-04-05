package com.example.cloneinstagram

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneinstagram.databinding.ItemPostHomeBinding

class PostAdapter(val items : ArrayList<PostData>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener
    private val CLICK_USERID = 1 // user id 클릭
    private val CLICK_SHOWMORE = 2 // 더보기 클릭
    private val CLICK_OPTIONS = 3 // 게시글 수정 클릭

    interface OnItemClickListener{
        fun onItemClick(postData: PostData, type: Int, binding: ItemPostHomeBinding)
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
                itemClickListener.onItemClick(item, CLICK_USERID, binding)
            }
            binding.tvItemPostShowMore.setOnClickListener {
                itemClickListener.onItemClick(item, CLICK_SHOWMORE, binding)
            }
            binding.ivItemPostImageOptions.setOnClickListener {
                itemClickListener.onItemClick(item, CLICK_OPTIONS, binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        val binding = ItemPostHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

}