package com.ism.saveanimal

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.ism.saveanimal.databinding.SaveMemberInformEditBinding

class SaveMemberInformEditActivity : AppCompatActivity() {

    private lateinit var binding: SaveMemberInformEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SaveMemberInformEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 드롭다운 뷰 찾기
//        val regionInput = findViewById<MaterialAutoCompleteTextView>(R.id.spinnerRegion)

        // string-array 가져오기
//        val items = resources.getStringArray(R.array.region_list)

        // 어댑터 연결
//        val adapter = ArrayAdapter(
//            this,
//            android.R.layout.simple_list_item_1,
//            items
//        )

//        regionInput.setAdapter(adapter)
//
//        regionInput.setOnItemClickListener { parent, view, position, id ->
//            val selected = items[position]
//            // TODO: 지역 선택 처리
//        }
    }

}

