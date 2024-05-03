package com.example.cloneinstagram

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cloneinstagram.databinding.ItemImageBinding

class DetailVPIndicatorAdapter(val context: Context, val items: MutableList<String>):RecyclerView.Adapter<DetailVPIndicatorAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemImageBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(image: String){
            Glide.with(context)
                .load(image)
                .into(binding.ivPost)
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailVPIndicatorAdapter.ViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailVPIndicatorAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

}