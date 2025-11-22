package com.ism.saveanimal

data class Post(
    val documentId: String = "",  // 문서 ID
    val aName: String = "",       // 동물 이름
    val aAge: Int = 0,            // 나이 (숫자)
    val aGender: String = "",     // 성별
    val mainImageUrl: String = "" // 이미지 URL
)