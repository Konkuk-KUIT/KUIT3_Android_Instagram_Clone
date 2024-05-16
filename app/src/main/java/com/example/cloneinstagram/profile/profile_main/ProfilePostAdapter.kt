package com.example.cloneinstagram.profile.profile_main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cloneinstagram.databinding.ItemProfilePostBinding
import com.example.cloneinstagram.data.PostData

class ProfilePostAdapter(val fragment: Fragment, val items: ArrayList<PostData>) : RecyclerView.Adapter<ProfilePostAdapter.ViewHolder>() {
    private lateinit var itemClickListener : OnItemClickListener

    interface OnItemClickListener {
        fun setOnItemClickListener(postData: PostData)
    }
    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        itemClickListener = onItemClickListener
    }
    inner class ViewHolder(val binding : ItemProfilePostBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: PostData) {
            Glide.with(fragment)
                .load(item.postImageURL)
                .into(binding.ivItemProfilePostImage)
            binding.ivItemProfilePostImage.setOnClickListener{
                itemClickListener.setOnItemClickListener(item)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProfilePostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfilePostAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}



