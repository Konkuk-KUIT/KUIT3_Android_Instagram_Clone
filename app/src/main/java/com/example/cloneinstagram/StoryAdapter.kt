package com.example.cloneinstagram

import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cloneinstagram.databinding.ItemStoryBinding

class StoryAdapter(val items: ArrayList<StoryData>) :
    RecyclerView.Adapter<StoryAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemStoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: StoryData) {
            binding.tvHomeStoryId.text = item.userId

            binding.sivHomeStory.setImageResource(item.userImg)

            binding.ivStoryVisibility.setOnClickListener {
                if (!item.isSeen) {
                    binding.ivStoryVisibility.setImageResource(R.drawable.ic_story_gray)
                    item.isSeen = true
                } else {
                    binding.ivStoryVisibility.setImageResource(R.drawable.ic_story_gray)
                }
            }

            if (!item.isMyStory) {
                binding.ivAddStory.visibility = View.GONE
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

}