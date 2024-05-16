package com.example.cloneinstagram

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneinstagram.databinding.ActivityMainBinding
import com.example.cloneinstagram.databinding.ItemPostBinding

class PostAdapter(val items: ArrayList<PostData>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(postData: PostData)
        fun onItemClick2(postData: PostData)
    }
    inner class ViewHolder(val binding: ItemPostBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item:PostData){
            binding.sivHomeMain.setImageResource(item.postProfile)
            binding.ivPost.setImageResource(item.postImage)
            binding.tvHomePost.text = item.postID
            binding.tvPostComment1.text = item.postID2
            binding.tvPostComment2.text = item.postComment
            binding.tvHomePost.setOnClickListener {
                itemClickListener.onItemClick(item)
            }
            binding.ivPostOptions.setOnClickListener{
                itemClickListener.onItemClick2(item)
            }
        }
    }

    //itemClickListener 초기화
    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        itemClickListener = onItemClickListener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int =items.size


}