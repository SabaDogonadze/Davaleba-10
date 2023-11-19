package com.example.davaleba10

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.davaleba10.databinding.ActivityMainBinding
import com.example.davaleba10.databinding.AdditionalItemsRecyclerview2Binding
import com.example.davaleba10.databinding.AdditionalItemsRecyclerviewBinding
import com.example.davaleba10.databinding.ItemsRecyclerviewsBinding

class NavigationRecyclerAdapter:
    ListAdapter<Data, RecyclerView.ViewHolder>(object :
        DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }

    }) {

    companion object{
        const val NORMAL = 1
        const val ADDITIONAL = 2
        const val ADDITIONAL2 = 3
    }


    fun setData(items: MutableList<Data>) {
        submitList(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == NORMAL) {
            return NavigationViewHolder(
                ItemsRecyclerviewsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }else if(viewType == ADDITIONAL){
            return AdditionalNavigationViewHolder(
                AdditionalItemsRecyclerviewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }else {
            return AdditionalNavigationViewHolder2(
                AdditionalItemsRecyclerview2Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is NavigationViewHolder) {
            holder.bind()
        }else if ( holder is AdditionalNavigationViewHolder){
            holder.bind()

        }else if ( holder is AdditionalNavigationViewHolder2){
            holder.bind()
        }
    }

    override fun getItemViewType(position: Int): Int {
         if (currentList[position].itemType == ItemType.NORMAL) {
           return NORMAL
        } else if(currentList[position].itemType == ItemType.ADDITIONAL){
            return ADDITIONAL
        }else{
            return ADDITIONAL2
        }

    }

    inner class NavigationViewHolder(private val binding: ItemsRecyclerviewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(){
                val item = currentList[adapterPosition]
                if (item.id == 10){
                    binding.tvText.setTextColor(Color.parseColor("#FF0000"))
                    binding.ivUserLogo.setColorFilter(Color.parseColor("#FF0000"))
                }
                binding.ivUserLogo.setImageResource(item.icon)
                binding.tvText.text = item.text
                binding.btnNext.setImageResource(item.button)
            }
    }

    inner class AdditionalNavigationViewHolder(private val binding: AdditionalItemsRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            val item = currentList[adapterPosition]
            binding.tvLanguage.text = item.language
            binding.ivUserLogo.setImageResource(item.icon)
            binding.tvText.text = item.text
            binding.btnNext.setImageResource(item.button)
        }

    }

    inner class AdditionalNavigationViewHolder2(private val binding: AdditionalItemsRecyclerview2Binding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            val item = currentList[adapterPosition]
            binding.tvLanguage.text = item.language
            binding.ivUserLogo.setImageResource(item.icon)
            binding.tvText.text = item.text
            binding.btnNext.isEnabled
        }

    }
}


