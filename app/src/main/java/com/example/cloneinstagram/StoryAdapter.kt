package com.example.cloneinstagram

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneinstagram.databinding.ItemPostBinding
import com.example.cloneinstagram.databinding.ItemStoryBinding

class StoryAdapter(val items : ArrayList<StoryData>):RecyclerView.Adapter<StoryAdapter.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(storyData: StoryData)
    }
    inner class ViewHolder(val binding: ItemStoryBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: StoryData,position: Int){
            binding.sivHomeStory.setImageResource(item.storyProfile)
            binding.tvHomeStory.text=item.storyId

            if(position==0){
                binding.ivStoryPlus.visibility=View.VISIBLE
                binding.tvHomeStory.text = "내 스토리"
            }else{
                binding.ivStoryPlus.visibility=View.GONE
            }

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryAdapter.ViewHolder {
        val binding = ItemStoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        binding.sivHomeStory.setOnClickListener{
            binding.ivHomeStoryGray.visibility = View.VISIBLE
            binding.ivHomeStoryColor.visibility = View.GONE
        }

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryAdapter.ViewHolder, position: Int) {
        holder.bind(items[position],position)
    }

    override fun getItemCount(): Int =items.size

}