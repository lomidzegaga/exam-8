package com.example.exam8.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exam8.common.extensions.loadImage
import com.example.exam8.databinding.CustomItemBinding
import com.example.exam8.domain.model.Items

class MainAdapter :
    ListAdapter<Items, MainAdapter.MainViewHolder>(
        ItemCallBack
    ) {

    var itemClick: ((Items) -> Unit)? = null

    inner class MainViewHolder(private val binding: CustomItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val items = getItem(adapterPosition)
            binding.apply {
                imageView.loadImage(items.cover)
                tvPrice.text = items.price
                tvTitle.text = items.title

                ivAdd.setOnClickListener {
                    itemClick!!.invoke(items)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            CustomItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind()
    }

}

object ItemCallBack : DiffUtil.ItemCallback<Items>() {
    override fun areItemsTheSame(
        oldItem: Items,
        newItem: Items
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: Items,
        newItem: Items
    ): Boolean {
        return oldItem == newItem
    }

}