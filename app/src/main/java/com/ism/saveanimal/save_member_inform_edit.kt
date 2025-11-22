package com.ism.saveanimal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.MaterialAutoCompleteTextView

class save_member_inform_edit : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // 1. 프래그먼트 레이아웃 inflate
        val view = inflater.inflate(
            R.layout.fragment_save_member_inform_edit,
            container,
            false
        )

        // 2. 레이아웃 안에 있는 드롭다운 뷰 찾기
        val regionInput =
            view.findViewById<MaterialAutoCompleteTextView>(R.id.spinnerRegion)

        // 3. string-array 불러오기
        val items = resources.getStringArray(R.array.region_list)

        // 4. 어댑터 생성
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            items
        )

        // 5. 드롭다운에 어댑터 연결
        regionInput.setAdapter(adapter)

        // 6. 선택 이벤트
        regionInput.setOnItemClickListener { parent, v, position, id ->
            val selected = items[position]
            // TODO: 선택한 지역 처리
        }

        return view
    }
}
