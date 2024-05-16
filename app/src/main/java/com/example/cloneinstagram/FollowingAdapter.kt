package com.example.cloneinstagram

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneinstagram.databinding.ItemFollowingBinding

class FollowingAdapter(val items: ArrayList<FollowingData>) : RecyclerView.Adapter<FollowingAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemFollowingBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item:FollowingData){
            binding.sivFollowingEllipse.setImageResource(item.followingImage)
            binding.tvFollowingId.text = item.followingID
            binding.tvFollowingName.text = item.followingName
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingAdapter.ViewHolder {
        val binding = ItemFollowingBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

 

    override fun onBindViewHolder(holder: FollowingAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int =items.size

}