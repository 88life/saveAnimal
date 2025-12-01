package com.ism.saveanimal

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ism.saveanimal.databinding.ActivitySignUpShelterBinding

class ShelterSignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpShelterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpShelterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 뒤로가기 버튼(btnBack)이 레이아웃에서 제거되었으므로 관련 코드 삭제됨

        // 1. 중복확인 버튼
        binding.btnCheckId.setOnClickListener {
            val id = binding.etId.text.toString()
            if (id.isEmpty()) {
                Toast.makeText(this, "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "사용 가능한 아이디입니다.", Toast.LENGTH_SHORT).show()
            }
        }

        // 2. 지역 선택 스피너 설정
        val regions = arrayOf("지역 선택", "서울", "경기", "인천", "강원", "충청", "전라", "경상", "제주")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, regions)
        binding.spRegion.adapter = adapter

        // 3. 회원가입 버튼
        binding.btnSignUp.setOnClickListener {
            val id = binding.etId.text.toString()
            val pw = binding.etPw.text.toString()
            val pwCheck = binding.etPwCheck.text.toString()
            val shelterName = binding.etShelterName.text.toString()
            val phone = binding.etPhone.text.toString()
            val region = binding.spRegion.selectedItem.toString()

            // 간단한 유효성 검사
            if (id.isEmpty() || pw.isEmpty() || shelterName.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "모든 정보를 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (pw != pwCheck) {
                Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (region == "지역 선택") {
                Toast.makeText(this, "지역을 선택해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // TODO: 여기서 실제 회원가입 로직 (서버 통신 또는 Firebase 연동) 수행

            Toast.makeText(this, "보호소 회원가입이 완료되었습니다!", Toast.LENGTH_LONG).show()
            val intent = Intent(this, SaveMainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}