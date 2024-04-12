package com.example.clonecodinginstagram

import android.location.GnssAntennaInfo.Listener
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clonecodinginstagram.databinding.ItemPostBinding
import com.google.android.material.imageview.ShapeableImageView

class PostAdapter(val items: ArrayList<PostData>, val onProfileClick1 : (View)->(Unit),val onProfileClick2 : (View)->(Unit)) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PostData) {
            binding.textId.text = item.user_id
            binding.textWriting.text = item.post_content
            binding.icProfile5.setImageResource(item.user_profile_image)
            binding.icProfile5.setOnClickListener {
                onProfileClick1(binding.icProfile5)
            }
            binding.icMenu.setOnClickListener(){
                onProfileClick2(binding.icMenu)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return this.items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    public interface OnProfileClickListener : OnClickListener {
        public fun onProfileClick1()
        public fun onProfileClick2()
    }

    private lateinit var profilelistener: OnProfileClickListener

    public fun setOnProfileClickListener(listener: OnProfileClickListener) {
        this.profilelistener = listener
    }
}