package com.example.cloneinstagram.profile.profile_main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cloneinstagram.databinding.ItemDetailPostBinding

class ProfileDetailVPAdapter(val fragment: Fragment, val itemList : MutableList<String>): RecyclerView.Adapter<ProfileDetailVPAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemDetailPostBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(imgurl: String){
            Glide.with(fragment)
                .load(imgurl)
                .into(binding.ivItemDetailPost)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDetailPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int =itemList.size

}