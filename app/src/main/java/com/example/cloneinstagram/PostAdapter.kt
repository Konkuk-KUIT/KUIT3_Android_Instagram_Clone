package com.example.cloneinstagram

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneinstagram.PostAdapter.ViewHolder
import com.example.cloneinstagram.databinding.ItemHomePostBinding

class PostAdapter(val items: ArrayList<PostData>) : RecyclerView.Adapter<ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener
    interface OnItemClickListener{
        fun onMoreClick(postData: PostData)
        fun onNameClick(postData: PostData)
    }
     inner class ViewHolder(val binding: ItemHomePostBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PostData){
            binding.tvPostName.text=item.postId
            binding.tvCommentAccount.text=item.postId
            binding.tvPostContent.text=item.postContent
            binding.sivPostStory.setImageResource(item.profileImgId)
            binding.ivPostPic.setImageResource(item.postImgId)

            binding.tvDetail.setOnClickListener {
                binding.tvPostContent.apply {
                    ellipsize=null
                    maxLines=Int.MAX_VALUE
                    binding.tvDetail.isVisible=false
                }
            }

            binding.postMore.setOnClickListener {
                itemClickListener.onMoreClick(item)

            }
            binding.tvPostName.setOnClickListener {
                itemClickListener.onNameClick(item)
            }
        }
    }

    fun setOnItemClickListener(onItemClickListener: Any){
        itemClickListener= onItemClickListener as OnItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=ItemHomePostBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])

    }
    override fun getItemCount(): Int = items.size

}

