package com.example.cloneinstagram

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cloneinstagram.databinding.ItemStoryBinding

class StoryAdapter(val storyList: List<StoryData>): RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {
    class StoryViewHolder(val binding: ItemStoryBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val binding = ItemStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StoryViewHolder(binding)
    }

    override fun getItemCount(): Int = storyList.size

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val story = storyList[position]
        with(holder.binding) {
            Glide.with(sivHomeStory.context).load(story.userImg).into(sivHomeStory)
            tvHomeStoryId.text = story.userId

            flHomeStory.setOnClickListener {
                val isSeen = story.isSeen
                ivHomeStoryGray.visibility = if (isSeen) View.GONE else View.VISIBLE
                ivHomeStoryColor.visibility = if (isSeen) View.VISIBLE else View.GONE
                story.isSeen = !isSeen
            }
        }
    }


}