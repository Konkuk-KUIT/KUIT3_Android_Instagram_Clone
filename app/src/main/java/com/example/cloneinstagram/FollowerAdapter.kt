package com.example.cloneinstagram

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneinstagram.databinding.ItemFollowerListBinding

class FollowerAdapter (val items : ArrayList<FollowerData>) : RecyclerView.Adapter<FollowerAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemFollowerListBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : FollowerData) {
            binding.sivEditFollowerImage.setImageResource(item.FollowerImage)
            binding.tvEditFollowerId.text = item.FollowerID
            binding.tvEditFollowerName.text = item.FollowerName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFollowerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

}