package com.mq.xn.paging3

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mq.xn.databinding.ItemDataBinding
import com.mx.tool.database.CacheEntry

class DataPagingAdapter : PagingDataAdapter<UserData, DataPagingAdapter.ViewHolder>(DataDiffCallback()) {
    class ViewHolder(val binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("TAG","====>position=$position")
        holder.binding.tvTitle.text = getItem(position)?.id
        holder.binding.tvContent.text = getItem(position)?.name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
}