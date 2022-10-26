package com.example.exampleroomcaching.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.exampleroomcaching.R
import com.example.exampleroomcaching.data.entity.Pizza
import kotlinx.android.synthetic.main.pizza_item.view.*

class MainAdapter: ListAdapter<Pizza, MainAdapter.MainViewHolder>(MainDiffUtil()) {
     inner class MainViewHolder(view: View): RecyclerView.ViewHolder(view)

     class MainDiffUtil: DiffUtil.ItemCallback<Pizza>(){
        override fun areItemsTheSame(oldItem: Pizza, newItem: Pizza): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: Pizza, newItem: Pizza): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.pizza_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.itemView.apply {
            item_title.text = currentList[position].title
            item_description.text = currentList[position].description
            item_price.text = currentList[position].price
            Glide.with(this)
                .load(currentList[position].image)
                .into(item_img)
        }
    }

}