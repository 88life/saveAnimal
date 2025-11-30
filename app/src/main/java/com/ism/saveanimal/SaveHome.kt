package com.ism.saveanimal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ism.saveanimal.databinding.SaveRepeatRecyclerBinding

class SaveHome(
    private val items: List<SaveDataItem>,
    private val onItemLongClick: (SaveDataItem) -> Unit,
    private val onItemClick: (SaveDataItem) -> Unit
) : RecyclerView.Adapter<SaveHome.ViewHolder>() {

    inner class ViewHolder(val binding: SaveRepeatRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SaveDataItem) {

            binding.root.setOnClickListener {
                onItemClick(item)
            }

            binding.root.setOnLongClickListener {
                onItemLongClick(item)
                true
            }

//            binding.textTitle.text = item.title
//            binding.textContent.text = item.content
            // 이미지 넣으려면 Glide 사용 가능
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SaveRepeatRecyclerBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
