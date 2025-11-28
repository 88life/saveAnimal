package com.ism.saveanimal.ui.slideshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ism.saveanimal.AnimalAdapter
import com.ism.saveanimal.AnimalItem
import com.ism.saveanimal.GenMemberInformEdit
import com.ism.saveanimal.R
import com.ism.saveanimal.databinding.ActivityProfileBinding
import com.ism.saveanimal.databinding.ActivitySheleterProfileBinding
import com.ism.saveanimal.databinding.FragmentSlideshowBinding


class SlideshowFragment : Fragment() {

        private var _binding: ActivityProfileBinding? = null
        private val binding get() = _binding!!

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            _binding = ActivityProfileBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            // 1. 더미 데이터 생성
            val dummyList1 = listOf(
                AnimalItem("바둑이", R.drawable.ic_menu_gallery),
                AnimalItem("나비", R.drawable.ic_menu_gallery),
                AnimalItem("초코", R.drawable.ic_menu_gallery),
                AnimalItem("흰둥이", R.drawable.ic_menu_gallery)
            )

            val dummyList2 = listOf(
                AnimalItem("멍멍이", R.drawable.ic_menu_camera),
                AnimalItem("야옹이", R.drawable.ic_menu_camera)
            )

            // 2. 찜한 공고 RecyclerView
            binding.rvFavorites.apply {
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                adapter = AnimalAdapter(dummyList1)
            }

            // 3. 신청한 입양/임보 RecyclerView
            binding.rvApplications.apply {
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                adapter = AnimalAdapter(dummyList2)
            }

            // 4. 회원정보 수정 버튼 클릭 시 → GenMemberInformEdit Activity로 이동
            binding.btnEditInfo.setOnClickListener {
                val intent = Intent(requireContext(), GenMemberInformEdit::class.java)
                startActivity(intent)
            }

            // 5. 메뉴 버튼 클릭 (상단 햄버거 아이콘)
            binding.btnMenu.setOnClickListener {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
        }


        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }
