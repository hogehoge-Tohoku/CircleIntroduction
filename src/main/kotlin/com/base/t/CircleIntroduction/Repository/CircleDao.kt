package com.base.t.CircleIntroduction.Repository

import com.base.t.CircleIntroduction.Entity.Circle

interface CircleDao {

    //サークルの件数を取得
    fun count(): Int

    //サークルidで一件取得
    fun selectOne(id: Int): Circle

    //サークル全件取得
    fun selectAll(): List<Circle>

    //組織別でサークルを取得
    fun selectOrganization(organization: String): List<Circle>
}