package com.ism.saveanimal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.ism.saveanimal.databinding.ItemAnimalBinding
import kotlin.text.isNotEmpty

class AnimalAdapter1(
    private var postList: List<Post>,
    private val onItemClick: (Post) -> Unit,
    private val onButtonClick: (Post) -> Unit
) : RecyclerView.Adapter<AnimalAdapter1.PostViewHolder>() {

    inner class PostViewHolder(val binding: ItemAnimalBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Post) = with(binding) {

            tvName.text = item.aName
            tvAge.text = "${item.aAge}살"
            tvGender.text = item.aGender

            // 클릭 이벤트
            root.setOnClickListener {
                onItemClick(item)
            }

            btnDetail.setOnClickListener {
                onButtonClick(item)
            }

            // 이미지 로드
            if (item.mainImageUrl.isNotEmpty()) {
                Glide.with(root.context)
                    .load(item.mainImageUrl)
                    .transform(RoundedCorners(60))
                    .into(ivAnimalProfile)
            }

            binding.root.setOnClickListener {
                onItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postList[position])
    }

    override fun getItemCount() = postList.size

    fun updateData(newList: List<Post>) {
        postList = newList
        notifyDataSetChanged()
    }
}
