package com.ism.saveanimal


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar


class SheleterProfileActivity : AppCompatActivity() {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. XML 레이아웃을 화면에 설정
        setContentView(R.layout.fragment_sheleter_profile)

        // 2. XML의 View들을 ID로 찾기
        val toolbar: MaterialToolbar = findViewById(R.id.toolbar)
        val btnEditProfile: Button = findViewById(R.id.btnEditProfile)
        val btnSettings: Button = findViewById(R.id.btnSettings)
        val btnLogout: Button = findViewById(R.id.btnLogout)
        val btnWithdraw: Button = findViewById(R.id.btnWithdraw)

        // 3. 툴바 설정 (햄버거 메뉴 아이콘 클릭 리스너)
        toolbar.setNavigationOnClickListener {

            Toast.makeText(this, "메뉴 클릭됨", Toast.LENGTH_SHORT).show()
        }

        // 4. 버튼 클릭 리스너 설정
        btnEditProfile.setOnClickListener {
            Toast.makeText(this, "프로필 수정", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SaveMemberInformEditActivity::class.java)
            startActivity(intent)
        }

        btnSettings.setOnClickListener {

            Toast.makeText(this, "설정", Toast.LENGTH_SHORT).show()
        }

        btnLogout.setOnClickListener {
            //로그인 화면으로 이동
            Toast.makeText(this, "로그아웃", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            // 예시: MainActivity로 이동하고 현재 화면(ProfileActivity)을 종료
            // val intent = Intent(this, MainActivity::class.java)
            // intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            // startActivity(intent)
            // finish()
        }

        btnWithdraw.setOnClickListener {

            Toast.makeText(this, "회원 탈퇴", Toast.LENGTH_SHORT).show()
        }
    }
}