package com.fury.flickerapp.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fury.flickerapp.BR

/**
 * Created By Amir Fury on 3 jan 2020
 */
abstract class BaseListAdapter<T>(diffItemCallback: DiffUtil.ItemCallback<T>) : ListAdapter<T,BaseListAdapter<T>.BaseViewHolder>(diffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder{
        val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), viewType, parent, false)
        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) = holder.bind(getItem(position))

    inner class BaseViewHolder(val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: T) {
            binding.setVariable(BR.model,item)
            binding.executePendingBindings()
        }
    }
}