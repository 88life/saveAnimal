package com.ism.saveanimal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ism.saveanimal.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {

    // ViewBinding 객체 선언
    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 바인딩 초기화 및 레이아웃 설정
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. 로그인 버튼 클릭 이벤트
        binding.button.setOnClickListener {
            // LoginActivity로 이동
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // 2. 회원가입 버튼 클릭 이벤트
        binding.button2.setOnClickListener {
            // 회원가입(역할 선택) 화면인 MainActivity로 이동
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}