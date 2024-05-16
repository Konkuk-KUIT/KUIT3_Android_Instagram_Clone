package com.example.cloneinstagram

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneinstagram.databinding.ItemFollowingBinding
import com.example.cloneinstagram.databinding.ItemSubBinding

class SubscribeAdapter (val items: ArrayList<SubscribeData>) : RecyclerView.Adapter<SubscribeAdapter.ViewHolder>(){

    inner class ViewHolder(val binding: ItemSubBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item:SubscribeData){
            binding.sivFollowingEllipse.setImageResource(item.subImage)
            binding.tvFollowingId.text = item.subID
            binding.tvFollowingName.text = item.subName
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscribeAdapter.ViewHolder {
        val binding = ItemSubBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubscribeAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int =items.size
}