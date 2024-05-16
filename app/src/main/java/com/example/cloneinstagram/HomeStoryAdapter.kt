package com.example.cloneinstagram

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneinstagram.databinding.FragmentStoryBinding

class HomeStoryAdapter (val items: ArrayList<HomeStoryData>): RecyclerView.Adapter<HomeStoryAdapter.ViewHolder>()  {

    inner class ViewHolder(val binding : FragmentStoryBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item : HomeStoryData, position: Int){
            binding.sivFragmentStoryProfile.setImageResource(item.imageId)
            binding.tvMyStory.text = item.instagramId
            if(position != 0){
                binding.ivHomeMyStoryPlus.visibility = View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeStoryAdapter.ViewHolder {
        val binding = FragmentStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int =items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], position)
    }

}