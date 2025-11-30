package com.ism.saveanimal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ism.saveanimal.databinding.ItemAnimalCardBinding


//찜한 공고 리싸이클러뷰 어댑터
// 데이터 모델
data class AnimalItem(
    val name: String,
    val imageResId: Int // 실제 앱에서는 이미지 URL(String) 등을 사용하세요
)

// 어댑터
class AnimalAdapter(val items: List<AnimalItem>) : RecyclerView.Adapter<AnimalAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemAnimalCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAnimalCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.tvName.text = item.name
        // 이미지 설정 (예시: 로컬 리소스 사용)
        // Glide나 Picasso를 쓴다면: Glide.with(holder.itemView).load(item.imageResId).into(holder.binding.imgAnimal)
        holder.binding.imgAnimal.setImageResource(item.imageResId)
    }

    override fun getItemCount(): Int = items.size
}