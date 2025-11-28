package com.ism.saveanimal

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ism.saveanimal.databinding.SaveApplyCheckRecyclerP1Binding

class saveConfirmCheckP1Adapter(
    private var items: List<save_DataItem>
) : RecyclerView.Adapter<saveConfirmCheckP1Adapter.ViewHolder>() {

    inner class ViewHolder(val binding: SaveApplyCheckRecyclerP1Binding) : RecyclerView.ViewHolder(binding.root) {
        val name: TextView = itemView.findViewById(R.id.itemName)
        val title: TextView = itemView.findViewById(R.id.itemAge)
        val phone: TextView = itemView.findViewById(R.id.itemGender)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SaveApplyCheckRecyclerP1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val item = items[position]
        holder.binding.name.text = item.p1Name
        holder.binding.phone.text = item.p1Phone
        holder.binding.title.text = item.p1Title
    }



    override fun getItemCount(): Int = items.size

    fun updateData(newList: List<save_DataItem>) {
        items = newList
        notifyDataSetChanged()
    }
}
