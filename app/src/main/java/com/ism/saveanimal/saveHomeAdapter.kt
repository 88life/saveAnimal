package com.ism.saveanimal

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ism.saveanimal.databinding.SaveRepeatRecyclerBinding

class saveHomeAdapter(
    private var items: List<SaveDataItem>,
    private val onItemClick: (SaveDataItem) -> Unit
) : RecyclerView.Adapter<saveHomeAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: SaveRepeatRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
        val itName: TextView = itemView.findViewById(R.id.itName)
        val itAge: TextView = itemView.findViewById(R.id.itAge)
        val itGender: TextView = itemView.findViewById(R.id.itGender)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SaveRepeatRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.itName.text = item.aniName
        holder.binding.itAge.text = item.aniAge
        holder.binding.itGender.text = item.gender
        holder.binding.itSpecies.text = item.species
        holder.binding.itScared.text = item.scared
        holder.binding.itDisease.text = item.disease
    }

    override fun getItemCount(): Int = items.size

    fun updateData(newList: List<SaveDataItem>) {
        items = newList
        notifyDataSetChanged()
    }
}

