package com.ism.saveanimal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.ism.saveanimal.databinding.ItemAnimalBinding
import kotlin.text.isNotEmpty

class AnimalAdapter1(private var postList: List<Post>) : RecyclerView.Adapter<AnimalAdapter1.PostViewHolder>() {

    inner class PostViewHolder(val binding: ItemAnimalBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        with(holder.binding) {
            tvName.text = post.aName
            tvAge.text = "${post.aAge}살"
            tvGender.text = post.aGender

            // 이미지 로드 (Glide)
            if (post.mainImageUrl.isNotEmpty()) {
                Glide.with(root.context)
                    .load(post.mainImageUrl)
                    .transform(RoundedCorners(60)) // 테두리에 맞춰 둥글게
                    .into(ivAnimalProfile)
            }
        }
    }

    override fun getItemCount() = postList.size

    fun updateData(newList: List<Post>) {
        postList = newList
        notifyDataSetChanged()
    }
}