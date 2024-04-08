package com.example.clonecodinginstagram

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clonecodinginstagram.databinding.ItemPostBinding

class PostAdapter(val items : ArrayList<PostData>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    inner class ViewHolder(val binding:ItemPostBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : PostData){
            binding.icProfile5.setImageDrawable(item.user_profile_image)
            binding.textId.text = item.user_id
            binding.textWriting.text = item.post_content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return this.items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}