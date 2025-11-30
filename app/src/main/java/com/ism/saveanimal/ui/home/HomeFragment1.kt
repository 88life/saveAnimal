package com.ism.saveanimal.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ism.saveanimal.AnimalAdapter1
import com.ism.saveanimal.PostDetailCustomActivity
import com.ism.saveanimal.ResultMainActivity
import com.ism.saveanimal.SaveDataItem
import com.ism.saveanimal.SaveHome
import com.ism.saveanimal.databinding.GenHomeBinding
class HomeFragment1 : Fragment() {

    private var _binding: GenHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val homefragment = ViewModelProvider(this).get(HomeViewModel1::class.java)

        _binding = GenHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // 예시 데이터
        val dummyList1 = listOf(
            SaveDataItem("", "닉1", "시바", "여", "시바", "활발", "소음", "없음"),
            SaveDataItem("", "닉1", "시바", "여", "시바", "활발", "소음", "없음"),
            SaveDataItem("", "닉1", "시바", "여", "시바", "활발", "소음", "없음")
        )

        val dummyList2 = listOf(
            SaveDataItem("", "닉1", "시바", "여", "시바", "활발", "소음", "없음"),
            SaveDataItem("", "닉1", "시바", "여", "시바", "활발", "소음", "없음"),
            SaveDataItem("", "닉1", "시바", "여", "시바", "활발", "소음", "없음")
        )

        val name = arguments?.getString("name")
        binding.nickname.text = "$name 입양자님"




        // 테스트 버튼
        binding.testBtn.setOnClickListener {
            val intent = Intent(requireContext(), ResultMainActivity::class.java)
            startActivity(intent)
        }
    }





    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
