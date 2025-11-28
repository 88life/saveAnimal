package com.ism.saveanimal

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity

class SaveMemberInformEditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.save_member_inform_edit)

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
