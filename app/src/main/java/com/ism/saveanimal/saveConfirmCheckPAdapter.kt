package com.ism.saveanimal

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ism.saveanimal.databinding.SaveApplyCheckRecyclerPBinding

class saveConfirmCheckPAdapter(
    private var items: List<SaveDataItem>
) : RecyclerView.Adapter<saveConfirmCheckPAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: SaveApplyCheckRecyclerPBinding) : RecyclerView.ViewHolder(binding.root) {
        val name: TextView = itemView.findViewById(R.id.itemName)
        val title: TextView = itemView.findViewById(R.id.itemAge)
        val phone: TextView = itemView.findViewById(R.id.itemGender)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SaveApplyCheckRecyclerPBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.name.text = item.pName
        holder.binding.phone.text = item.pPhone
        holder.binding.title.text = item.pTitle
    }

    override fun getItemCount(): Int = items.size

    fun updateData(newList: List<SaveDataItem>) {
        items = newList
        notifyDataSetChanged()
    }
}
