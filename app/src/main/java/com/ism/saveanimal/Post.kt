package com.ism.saveanimal

data class Post(
    val documentId: String = "",  // 문서 ID
    val aName: String = "",       // 동물 이름
    val aAge: Int = 0,            // 나이 (숫자)
    val aGender: String = "",     // 성별
    val mainImageUrl: String = "", // 이미지 URL
    val aBreed: String ="", //품종
    val aPersonality: String = "", //성격
    val aFears : String = "", // 무서워하는 것
    val aDiseases: String = "", // 질병
    val aShelter: String = "", // 보호소 정보
)