package com.example.cloneinstagram

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneinstagram.databinding.ItemFollowUserBinding

class FollowAdapter : RecyclerView.Adapter<FollowAdapter.ViewHolder>(){

    inner class ViewHolder(val binding : ItemFollowUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowAdapter.ViewHolder {
        val binding = ItemFollowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = 10

    override fun onBindViewHolder(holder: FollowAdapter.ViewHolder, position: Int) {

    }
}