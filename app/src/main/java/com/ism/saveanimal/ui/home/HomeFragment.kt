package com.ism.saveanimal.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ism.saveanimal.SaveAnnouncementEdit
import com.ism.saveanimal.SaveHome
import com.ism.saveanimal.databinding.SaveHomeBinding
import android.content.Intent
import com.ism.saveanimal.SaveDataItem


class HomeFragment : Fragment() {

    private var _binding: SaveHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: SaveHome

    // 예시 데이터
    private val items = listOf(
        SaveDataItem("", "닉1", "시바", "여", "시바", "활발", "소음", "없음"),
        SaveDataItem("", "사람을 좋아합니다", "이미지URL2"),
        SaveDataItem("", "사람을 좋아합니다", "이미지URL2")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SaveHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val name = arguments?.getString("name")
        binding.nickname.text = "$name 보호소 담당자님,"

        adapter = SaveHome(
            items,
            onItemLongClick = { item ->
                // 클릭 시 Activity로 이동
                val intent = Intent(requireContext(), SaveAnnouncementEdit::class.java)
                intent.putExtra("item", item )   // Parcelable 객체 전달
                startActivity(intent)
            },
            onItemClick = { item ->
                // 클릭 기능
            }
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
