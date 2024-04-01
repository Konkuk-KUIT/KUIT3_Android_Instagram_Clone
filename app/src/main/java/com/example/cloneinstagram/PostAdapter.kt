package com.example.cloneinstagram

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.accessibility.AccessibilityManager.AccessibilityServicesStateChangeListener
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneinstagram.PostAdapter.ViewHolder
import com.example.cloneinstagram.databinding.ActivityEditBinding
import com.example.cloneinstagram.databinding.ItemHomePostBinding

class PostAdapter(val items: ArrayList<PostData>) : RecyclerView.Adapter<ViewHolder>() {
     inner class ViewHolder(val binding: ItemHomePostBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PostData){
            binding.tvPostName.text=item.postId
            binding.tvPostContent.text=item.postContent
            binding.sivPostStory.setImageResource(R.drawable.img_sample2)
            binding.ivPostPic.setImageResource(R.drawable.img_sample)
                //click event 넣을자리, 그리고 아래에 clicklistener fun 정의
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=ItemHomePostBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])

    }
    override fun getItemCount(): Int = items.size

}