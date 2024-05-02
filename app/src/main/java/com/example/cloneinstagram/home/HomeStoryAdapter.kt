package com.example.cloneinstagram.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cloneinstagram.databinding.ItemHomeStoryBinding

class HomeStoryAdapter(val fragment: Fragment, val items :ArrayList<String>): RecyclerView.Adapter<HomeStoryAdapter.ViewHolder>() {

    private lateinit var itemClickListener : OnItemClickListener
    interface OnItemClickListener {
        fun onItemClick(itemHomeStorybinding: ItemHomeStoryBinding)
    }
    fun setOnItemClickListner(onItemClickListener: OnItemClickListener) {
        itemClickListener = onItemClickListener
    }


    inner class ViewHolder(val binding: ItemHomeStoryBinding) : RecyclerView.ViewHolder(binding.root){
        var isClicked = false
        fun bind(item: String){
            Glide.with(fragment)
                .load(item)
                .into(binding.ivItemHomeStoryImage)
            if (isClicked == false) {
                binding.flItemHomeStory.setOnClickListener {
                    itemClickListener.onItemClick(binding)
                    this.isClicked = true
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomeStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}