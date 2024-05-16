package com.example.cloneinstagram.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cloneinstagram.data.UsersData
import com.example.cloneinstagram.databinding.ItemHomeStoryBinding

class HomeStoryListAdapter(val fragment: Fragment, val items :ArrayList<UsersData>): RecyclerView.Adapter<HomeStoryListAdapter.ViewHolder>() {
    private lateinit var itemClickListener : OnItemClickListener
    interface OnItemClickListener {
        fun onItemClick(itemHomeStorybinding: ItemHomeStoryBinding)
    }
    fun setOnItemClickListner(onItemClickListener: OnItemClickListener) {
        itemClickListener = onItemClickListener
    }

    inner class ViewHolder(val binding: ItemHomeStoryBinding) : RecyclerView.ViewHolder(binding.root){
        var isClicked = false
        fun bind(item: UsersData){
            Glide.with(fragment)
                .load(item.profileImageUrl)
                .into(binding.sivItemHomeStoryImage)
            binding.tvItemHomeStory.text = item.profileUserId
            if (isClicked == false) {
                binding.flItemHomeStory.setOnClickListener {
                    itemClickListener.onItemClick(binding)
                    this.isClicked = true
                }
            }
        }

        fun myStoryBind(item: UsersData){
            binding.ivItemHomePlus.visibility = View.VISIBLE
            binding.sivItemHomeStoryImage.setImageResource(item.profileImage)
            binding.tvItemHomeStory.text = item.profileUserId

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
        if (position == 0) { holder.myStoryBind(items[position]) } // myStory 만 특별 세팅
        else { holder.bind(items[position]) }
    }
}