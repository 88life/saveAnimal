package com.ism.saveanimal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ism.saveanimal.databinding.SaveRepeatRecyclerBinding

class SaveHome(
    private val items: List<save_DataItem>,
    private val onItemLongClick: (save_DataItem) -> Unit
) : RecyclerView.Adapter<SaveHome.ViewHolder>() {

    inner class ViewHolder(val binding: SaveRepeatRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: save_DataItem) {

            // 롱클릭 이벤트
            binding.root.setOnLongClickListener {
                onItemLongClick(item)
                true
            }

            // TODO: 데이터 바인딩 (예시)
            // binding.textViewTitle.text = item.title
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
