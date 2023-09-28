package com.example.innstantbook.presentation.adapters

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class CustomListAdapter<T : Any, VH : CustomBindingViewHolder<T>> :
    ListAdapter<T, VH>(
        object : DiffUtil.ItemCallback<T>() {
            override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
                return oldItem == newItem
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
                return oldItem == newItem
            }
        }
    ) {

    var contentList: List<T> = mutableListOf()
        set(value) {
            submitList(value)
            field = value
        }

    abstract fun getViewHolderInstance(parent: ViewGroup, viewType: Int): VH

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return getViewHolderInstance(parent, viewType)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        if (contentList.isEmpty()) return
        holder.bind(contentList[position], position)
    }
}