package com.example.cloneinstagram


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneinstagram.databinding.ItemHomeStoryBinding

class StoryAdapter(var list:ArrayList<StoryData>):RecyclerView.Adapter<StoryAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemHomeStoryBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: StoryData){
            binding.tvHomeMyStory3.text= item.userId.toString()
            binding.flHomeStory3.setOnClickListener {
                binding.ivHomeStoryColor3.isVisible=false
                binding.ivHomeStoryGray3.isVisible=true
            }
            binding.sivHomeStory3.setImageResource(item.storyImg)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=ItemHomeStoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name=list[position]
        holder.bind(name)
    }

    override fun getItemCount(): Int = list.size


}