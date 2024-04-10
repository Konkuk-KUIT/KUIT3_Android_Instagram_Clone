package com.example.cloneinstagram

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneinstagram.databinding.ItemHomePostBinding
class PostAdapter(val items: ArrayList<PostData>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onIdClick(postData: PostData)
        fun onOptionClick(postData: PostData)
    }

    inner class ViewHolder(val binding: ItemHomePostBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PostData) {
            binding.sivPostProfile.setImageResource(item.profileImg)
            binding.tvPostUseridBig.text = item.userId
            binding.ivPostImg.setImageResource(item.postImg)
            binding.tvPostUseridSmall.text = item.userId
            binding.tvPostContent.text = item.postContent

            binding.ivPostOption.setOnClickListener {
                itemClickListener.onOptionClick(item)
            }

            binding.tvPostUseridBig.setOnClickListener {
                itemClickListener.onIdClick(item)
            }

//            더보기 눌렀을 때 작업 해주기
        }
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        itemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        val binding = ItemHomePostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size


}