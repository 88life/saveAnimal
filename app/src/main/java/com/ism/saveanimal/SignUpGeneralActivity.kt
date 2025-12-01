package com.ism.saveanimal

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ism.saveanimal.databinding.ActivitySignUpGeneralBinding

class SignUpGeneralActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpGeneralBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpGeneralBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSpinner()
        setupListeners()
    }

    private fun setupSpinner() {
        // strings.xml에 있는 region_list 배열을 가져와서 스피너에 연결
        // (만약 strings.xml에 region_list가 없다면 임시 리스트를 사용하세요)
        val regions = resources.getStringArray(R.array.region_list)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, regions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spRegion.adapter = adapter
    }

    private fun setupListeners() {
        // 1. 아이디 중복 확인 버튼
        binding.btnCheckId.setOnClickListener {
            val id = binding.etId.text.toString()
            if (id.isEmpty()) {
                Toast.makeText(this, "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                // TODO: 실제 서버나 DB와 통신하여 중복 확인 로직 구현 필요
                Toast.makeText(this, "사용 가능한 아이디입니다.", Toast.LENGTH_SHORT).show()
            }
        }

        // 2. 회원가입 완료 버튼
        binding.btnSignUp.setOnClickListener {
            if (validateInput()) {
                // TODO: 여기에 실제 회원가입 처리 로직(Firebase 또는 서버 전송) 추가

                Toast.makeText(this, "일반 회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show()

                // 회원가입 성공 시 로그인 화면으로 이동하고 현재 액티비티 종료
                val intent = Intent(this, GenMainActivity::class.java)
                // 기존 스택을 비워 뒤로가기 시 다시 회원가입 화면이 안 나오게 설정
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }
        }
    }

    // 입력값 유효성 검사 함수
    private fun validateInput(): Boolean {
        val id = binding.etId.text.toString()
        val pw = binding.etPw.text.toString()
        val pwCheck = binding.etPwCheck.text.toString()
        val name = binding.etName.text.toString()
        val phone = binding.etPhone.text.toString()

        if (id.isEmpty() || pw.isEmpty() || pwCheck.isEmpty() || name.isEmpty() || phone.isEmpty()) {
            Toast.makeText(this, "모든 항목을 입력해주세요.", Toast.LENGTH_SHORT).show()
            return false
        }

        if (pw != pwCheck) {
            Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
            return false
        }

        if (pw.length < 8) {
            Toast.makeText(this, "비밀번호는 8자 이상이어야 합니다.", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}