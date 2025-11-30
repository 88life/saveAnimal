package com.ism.saveanimal

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SaveDataItem(
    //보호소
    //홈
    val aniImage: String = "",
    val name: String = "",
    val aniName: String = "",
    val aniAge: String = "",
    val gender: String = "",
    val species: String = "",
    val personal: String = "",
    val scared: String = "",
    val disease: String = "",

    //신청 확인  (입양자: p1, 임보자: p2)
    val pName: String = "",
    val pTitle: String = "",
    val pPhone: String = "",

    val p1Name: String = "",
    val p1Title: String = "",
    val p1Phone: String = "",

    //회원정보 수정
    val profileImg: String = "",
    val id: String = "",
    val pw: String = "",
    val shelter: String = "",
    val shelterPhone: String = ""

    ) : Parcelable
