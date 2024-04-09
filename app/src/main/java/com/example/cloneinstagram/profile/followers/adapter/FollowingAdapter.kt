package com.example.cloneinstagram.profile.followers.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneinstagram.databinding.ItemFollowersBinding
import com.example.cloneinstagram.profile.followers.FollowerData

class FollowingAdapter(val items: ArrayList<FollowerData>) : RecyclerView.Adapter<FollowingAdapter.ViewHolder>() {
    inner class ViewHolder(val binding : ItemFollowersBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : FollowerData){
            binding.sivItemFollowersImage.setImageResource(item.followerImage)
            binding.tvItemFollowersName.text = item.followerName
            binding.tvItemFollowersUserId.text = item.followerUserId
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFollowersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}