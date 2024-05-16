package com.example.cloneinstagram

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneinstagram.databinding.ItemFollowerBinding

class FollowerAdapter(val items: ArrayList<FollowerData>) : RecyclerView.Adapter<FollowerAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemFollowerBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item:FollowerData){
            binding.sivFollowerEllipse.setImageResource(item.followerImage)
            binding.tvFollowerId.text = item.followerID
            binding.tvFollowerName.text = item.followerName
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerAdapter.ViewHolder {
        val binding = ItemFollowerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int =items.size

}