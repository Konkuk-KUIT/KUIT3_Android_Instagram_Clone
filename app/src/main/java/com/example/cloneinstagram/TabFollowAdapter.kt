package com.example.cloneinstagram

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneinstagram.databinding.ItemTabFollowBinding

class TabFollowAdapter:RecyclerView.Adapter<TabFollowAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemTabFollowBinding):RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TabFollowAdapter.ViewHolder {
        val binding= ItemTabFollowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: TabFollowAdapter.ViewHolder, position: Int) {
    }
}

