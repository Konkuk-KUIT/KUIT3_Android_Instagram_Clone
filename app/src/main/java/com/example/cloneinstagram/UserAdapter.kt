package com.example.cloneinstagram

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneinstagram.databinding.ItemPeopleListBinding

class UserAdapter(val items: ArrayList<UserData>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemPeopleListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: UserData) {
            binding.ivPeopleProfile.setImageResource(item.UserImg)
            binding.tvPeopleId.text = item.UserId
            binding.tvPeopleName.text = item.UserName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemPeopleListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

}