package com.example.cloneinstagram

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cloneinstagram.databinding.FragmentImageBinding

class DetailPostAdapter(val context : Context, private val items : MutableList<String>) : RecyclerView.Adapter<DetailPostAdapter.ViewHolder>(){


    inner class ViewHolder(val binding : FragmentImageBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(url : String){
            Glide.with(context)
                .load(url)
                .into(binding.ivImage)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailPostAdapter.ViewHolder {
        val binding = FragmentImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailPostAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

}