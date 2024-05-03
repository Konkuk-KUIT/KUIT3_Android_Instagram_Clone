package com.example.clonecodinginstagram

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bumptech.glide.Glide
import com.example.clonecodinginstagram.databinding.FragmentPostDetailBinding
import com.example.clonecodinginstagram.databinding.FragmentPostSingleImageBinding

class PostVPAdapter(val context: Context): RecyclerView.Adapter<PostVPAdapter.ViewHolder>() {
    inner class ViewHolder(val binding : FragmentPostSingleImageBinding) : RecyclerView.ViewHolder(binding.root){
        public fun bind(){
            binding.ivPost.setImageResource(R.drawable.img_sample)
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostVPAdapter.ViewHolder{
        val binding = FragmentPostSingleImageBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostVPAdapter.ViewHolder, position: Int) {
        holder.bind()
    }
    override fun getItemCount(): Int= 3

}
