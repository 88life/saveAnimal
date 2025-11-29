package com.ism.saveanimal

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ism.saveanimal.databinding.ActivityPostDetailCustomBinding

class PostDetailCustomActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostDetailCustomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostDetailCustomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 전달받은 데이터
        val postId = intent.getStringExtra("postId")
        val name = intent.getStringExtra("name")
        val age = intent.getIntExtra("age", 0)
        val gender = intent.getStringExtra("gender")
        val image = intent.getStringExtra("image")
        val breed = intent.getStringExtra("breed")
        val personality = intent.getStringExtra("personality")
        val fears = intent.getStringExtra("fears")
        val diseases = intent.getStringExtra("diseases")
        val shelter = intent.getStringExtra("shelter")

        // 화면에 출력
        binding.etName.setText(name)
        binding.etAge.setText("$age 살")
        binding.etGender.setText(gender)
        binding.etBreed.setText(breed)
        binding.etPersonality.setText(personality)
        binding.etFears.setText(fears)
        binding.etDiseases.setText(diseases)
        binding.etShelter.setText(shelter)
        // Glide 등을 사용하여 이미지 표시 가능

        // 메뉴 버튼 클릭
        binding.btnMenu.setOnClickListener {
            Toast.makeText(this, "메뉴 열기", Toast.LENGTH_SHORT).show()
        }

        // 사진 변경 클릭
        binding.imgDog.setOnClickListener {
            Toast.makeText(this, "사진 변경 기능", Toast.LENGTH_SHORT).show()
        }

        // 1. 입양 신청하기 버튼
        binding.btnAdopt.setOnClickListener {
            val name = binding.etName.text.toString()
            // 입력된 성별 가져오기 (EditText)
            val gender = binding.etGender.text.toString()

            if (name.isEmpty()) {
                Toast.makeText(this, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "[$name] 입양 신청을 진행합니다.", Toast.LENGTH_SHORT).show()
            // 입양 신청 화면으로 이동하는 Intent 코드 추가 가능
        }

        // 2. 임보 신청하기 버튼
        binding.btnFoster.setOnClickListener {
            val name = binding.etName.text.toString()

            if (name.isEmpty()) {
                Toast.makeText(this, "이름을 먼저 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "[$name] 임시보호 신청을 진행합니다.", Toast.LENGTH_SHORT).show()
            // 임보 신청 화면으로 이동하는 Intent 코드 추가 가능
        }
    }
}