package com.example.cloneinstagram

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneinstagram.databinding.ItemHomeBinding

class PostAdapter(val postData : ArrayList<PostData>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private lateinit var itemClickListener : OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(itemData : PostData)
    }

    fun setOnItemClickListener(onItemClickListener : OnItemClickListener){
        itemClickListener = onItemClickListener
    }
    inner class ViewHolder(val binding : ItemHomeBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : PostData){
            binding.sivHomeProfile2.setImageResource(item.profileImage)
            binding.tvHomeName2.text = item.profileName
            binding.ivHomePostImg2.setImageResource(item.postImage)
            binding.tvHomePostContent2.text = item.postText
            binding.tvHomeName2.setOnClickListener {
                itemClickListener.onItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = postData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(postData[position])
    }
}