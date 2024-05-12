package com.example.cloneinstagram

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cloneinstagram.databinding.ItemPostDetailPicturesBinding

class PostDetailVPIndicatorAdapter (val context: Context, val items: MutableList<String>) : RecyclerView.Adapter<PostDetailVPIndicatorAdapter.ViewHolder>(){

    inner class ViewHolder(val binding: ItemPostDetailPicturesBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(image : String) {
            Glide.with(context)
                .load(image)
                .into(binding.ivPicutres)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostDetailVPIndicatorAdapter.ViewHolder {
        val binding = ItemPostDetailPicturesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostDetailVPIndicatorAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
