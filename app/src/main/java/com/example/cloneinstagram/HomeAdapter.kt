package com.example.cloneinstagram

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneinstagram.databinding.ItemHomePostBinding

class HomeAdapter(val items: ArrayList<ItemHomePostData>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private lateinit var itemClickListener : OnItemClickListener

    interface OnItemClickListener{
        fun onItemCLick(item: ItemHomePostData)
    }

    inner class ViewHolder(val binding : ItemHomePostBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item : ItemHomePostData){
            binding.sivHomePostingProfile.setImageResource(item.imageId)
            binding.tvHomePostingProfileName.text = item.instagramId
            binding.ivHomePostingImage.setImageResource(item.postingImageId)
            binding.tvHomePostingContent.text = item.content
            binding.tvHomePostingProfileName.setOnClickListener{
                itemClickListener.onItemCLick(item)
            }
        }
    }

    fun setOnItemClickListener(onItemClickListener : OnItemClickListener){
        itemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomePostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }


}