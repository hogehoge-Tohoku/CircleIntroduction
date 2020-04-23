package com.base.t.CircleIntroduction.Repository

import com.base.t.CircleIntroduction.Domain.Circle

interface CircleDao {

    //サークルの件数を取得
    fun count(): Int

    //サークルidで一件取得
    fun selectOne(id: Int): Circle

    //サークル全件取得
    fun selectAll(): List<Circle>

    //組織と所属でサークルを取得
    fun conditionalSelect(classification: List<String?>? ,organization: List<String?>?): List<Circle>
}