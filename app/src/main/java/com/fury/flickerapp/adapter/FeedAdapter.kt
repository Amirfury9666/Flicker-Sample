package com.fury.flickerapp.adapter

import androidx.recyclerview.widget.DiffUtil
import com.fury.flickerapp.R
import com.fury.flickerapp.base.BaseListAdapter
import com.fury.flickerapp.data.response.Item

class FeedAdapter : BaseListAdapter<Item>(DiffCallback()){

    override fun getItemViewType(position: Int): Int {
        return R.layout.feed_item
    }

     class DiffCallback : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.equals(newItem)
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.equals(newItem)
        }
    }
}