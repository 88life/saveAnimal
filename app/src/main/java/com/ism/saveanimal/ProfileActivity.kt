package com.ism.saveanimal

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ism.saveanimal.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. 더미 데이터 생성 (테스트용)
        // R.drawable.ic_menu_gallery는 기본 리소스입니다. 실제 이미지가 있다면 교체하세요.
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

        // 2. '내가 찜한 공고' 리사이클러뷰 설정 (가로 스크롤)
        binding.rvFavorites.apply {
            layoutManager = LinearLayoutManager(this@ProfileActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = AnimalAdapter(dummyList1)
        }

        // 3. '내가 신청한 입양/임보' 리사이클러뷰 설정 (가로 스크롤)
        binding.rvApplications.apply {
            layoutManager = LinearLayoutManager(this@ProfileActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = AnimalAdapter(dummyList2)
        }

        // 4. 버튼 클릭 이벤트 (예시)
        binding.btnEditInfo.setOnClickListener {
            Toast.makeText(this, "회원정보 수정 클릭", Toast.LENGTH_SHORT).show()
            // 나중에 회원정보 수정 화면으로 이동하는 코드를 여기에 넣으면 됩니다.
            val intent = Intent(this, GenMemberInformEdit::class.java)
            startActivity(intent)
        }

        binding.btnMenu.setOnClickListener {
            finish() // 메뉴 버튼 누르면 현재 화면 닫기 (예시)
        }

    }
}