package com.example.cloneinstagram

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneinstagram.databinding.ItemHomeStoryBinding

class HomeStoryAdapter(val items : ArrayList<HomeStoryData>): RecyclerView.Adapter<HomeStoryAdapter.ViewHolder>() {

    var isPressed : Boolean = false

    inner class ViewHolder(val binding: ItemHomeStoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : HomeStoryData){
            binding.tvHomeStoryID.text = item.InstagramID
            binding.sivHomeStory.setImageResource(item.ProfileImage)

            binding.flHomeStory.setOnClickListener {
                if(!isPressed) {
                    binding.ivHomeStoryGray.visibility = View.GONE
                    binding.ivHomeStoryColor.visibility = View.VISIBLE
                    isPressed = true
                } else {
                    binding.ivHomeStoryGray.visibility = View.VISIBLE
                    binding.ivHomeStoryColor.visibility = View.GONE
                }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeStoryAdapter.ViewHolder {
        val binding = ItemHomeStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeStoryAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}