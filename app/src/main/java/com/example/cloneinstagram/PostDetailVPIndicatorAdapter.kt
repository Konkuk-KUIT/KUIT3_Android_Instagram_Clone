package com.example.cloneinstagram

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cloneinstagram.databinding.ItemPostDetailImageBinding

class PostDetailVPIndicatorAdapter(val context: Context, val items: MutableList<String>) : RecyclerView.Adapter<PostDetailVPIndicatorAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemPostDetailImageBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(image: String){
            Glide.with(context)
                .load(image)
                .into(binding.ivImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPostDetailImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}