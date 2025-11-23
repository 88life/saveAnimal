package com.ism.saveanimal

import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log.e
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import java.io.OutputStream

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultKey = intent.getStringExtra("RESULT_KEY") ?: "OOO"

        // 뷰 연결
        val tvTitle = findViewById<TextView>(R.id.tvResultTitle)
        val tvDesc = findViewById<TextView>(R.id.tvResultDesc)
        val ivImage = findViewById<ImageView>(R.id.ivResultImage)
        val resultCard = findViewById<CardView>(R.id.resultCard) // 캡처할 카드
        val btnSaveAndHome = findViewById<Button>(R.id.btnSaveAndHome) // 저장 버튼
        val btnRetry = findViewById<Button>(R.id.btnRetry)

        // 데이터 세팅 (이전과 동일)
        when (resultKey) {
            "OOO" -> {
                tvTitle.text = "골든 리트리버"
                tvDesc.text = "(활동적 + 털털함 + 애정가득)\n에너지가 넘치고, 털 뿜뿜이나 왕성한 사고조차 웃어넘길 수 있는 당신! 사랑 넘치는 대형견이 딱입니다."
                ivImage.setImageResource(R.drawable.golden_retriever)
            }
            "OOX" -> {
                tvTitle.text = "앵무새"
                tvDesc.text = "(활동적 + 시끄러움 OK + 지적 교류)\n적막한 건 질색! 끊임없이 말을 걸어주고 노래하며, 높은 지능으로 티키타카가 되는 특별한 파트너입니다."
                ivImage.setImageResource(R.drawable.parrot)
            }
            "OXO" -> {
                tvTitle.text = "말티즈"
                tvDesc.text = "(활동적 + 깔끔함 + 애정가득)\n산책은 좋지만 집은 깨끗했으면 하는 당신. 사람을 너무 좋아해 잠시도 떨어지기 싫어하는 국민 강아지입니다."
                ivImage.setImageResource(R.drawable.maltese)
            }
            "OXX" -> {
                tvTitle.text = "푸들"
                tvDesc.text = "(활동적 + 깔끔함 + 스마트)\n털 빠짐은 싫고 눈치 빠른 친구를 원하시나요? 똑똑해서 훈련도 척척, 센스 있는 반려 생활이 가능합니다."
                ivImage.setImageResource(R.drawable.pudel)
            }
            "XOO" -> {
                tvTitle.text = "코리안 숏헤어"
                tvDesc.text = "(실내 + 활기참 + 개냥이)\n집이 좋지만 지루한 건 싫어! 우다다 뛰어다니는 건강한 에너지와 애교를 겸비한 매력 덩어리입니다."
                ivImage.setImageResource(R.drawable.korean_shorthair)
            }
            "XOX" -> {
                tvTitle.text = "햄스터"
                tvDesc.text = "(실내 + 야행성/소음 + 독립적)\n밤새 쳇바퀴 도는 소리 쯤은 OK. 좁은 공간에서도 잘 지내며, 서로 간섭하지 않는 쿨한 관계입니다."
                ivImage.setImageResource(R.drawable.hamster)
            }
            "XXO" -> {
                tvTitle.text = "스코티쉬 폴드"
                tvDesc.text = "(실내 + 조용함 + 순둥이)\n움직임이 적고 얌전합니다. 조용히 옆자리를 지켜주며 따스한 온기를 나누는 힐링 파트너입니다."
                ivImage.setImageResource(R.drawable.scottish_fold)
            }
            "XXX" -> {
                tvTitle.text = "토끼"
                tvDesc.text = "(실내 + 예민/깔끔 + 거리두기)\n큰 소리에 예민하고 깔끔한 당신. 조용히 깡충거리며 자신만의 영역을 지키는 귀여운 친구와 잘 맞습니다."
                ivImage.setImageResource(R.drawable.rabbit)
            }
        }

        // 저장하고 홈으로 버튼 클릭
        btnSaveAndHome.setOnClickListener {
            // 카드뷰를 이미지으로 변환
            val bitmap = getBitmapFromView(resultCard)

            // 갤러리에 저장
            if (bitmap != null) {
                saveImageToGallery(bitmap)
                Toast.makeText(this, "갤러리에 저장되었습니다!", Toast.LENGTH_SHORT).show()

                // 홈으로 이동 (기존 액티비티들을 모두 지우고 새로 시작)
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish() // 현재 화면 종료
            } else {
                Toast.makeText(this, "이미지 생성 실패", Toast.LENGTH_SHORT).show()
            }
        }

        //  다시하기 버튼
        btnRetry.setOnClickListener {
            finish()
        }
    }

    // 뷰를 비트맵으로 변환하는 함수
    private fun getBitmapFromView(view: View): Bitmap? {
        // 뷰가 그려지지 않았으면 null 반환
        if (view.width == 0 || view.height == 0) return null

        val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)

        // 배경이 투명하면 흰색으로 칠해주기
        canvas.drawColor(android.graphics.Color.WHITE)

        view.draw(canvas)
        return bitmap
    }

    // 비트맵을 갤러리에 저장하는 함수
    private fun saveImageToGallery(bitmap: Bitmap) {
        val filename = "PetTest_${System.currentTimeMillis()}.jpg"
        var outputStream: OutputStream? = null

        try {
            val contentValues = ContentValues().apply {
                put(MediaStore.MediaColumns.DISPLAY_NAME, filename)
                put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES + "/SaveAnimal")
                    put(MediaStore.MediaColumns.IS_PENDING, 1)
                }
            }

            val resolver = contentResolver
            val imageUri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)

            if (imageUri != null) {
                // 스트림 열기
                outputStream = resolver.openOutputStream(imageUri)

                // ★ 여기가 수정된 부분입니다! ★
                // outputStream이 null이 아닐 때만 압축(저장)을 시도합니다.
                if (outputStream != null) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    contentValues.clear()
                    contentValues.put(MediaStore.MediaColumns.IS_PENDING, 0)
                    resolver.update(imageUri, contentValues, null, null)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "저장 중 오류가 발생했습니다.", Toast.LENGTH_SHORT).show()
        } finally {
            try {
                outputStream?.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
            }

