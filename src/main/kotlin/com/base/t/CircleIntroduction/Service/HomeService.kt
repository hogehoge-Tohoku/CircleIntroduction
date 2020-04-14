package com.base.t.CircleIntroduction.Service

import com.base.t.CircleIntroduction.Entity.Circle
import com.base.t.CircleIntroduction.Repository.Jdbc.CircleDaoJdbcImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HomeService {
    @Autowired
    lateinit var dao : CircleDaoJdbcImpl

    fun count(): Int{
        return dao.count()
    }

    fun selectOne(id: Int): Circle {
        return dao.selectOne(id)
    }

    fun selectAll(): List<Circle> {
        return dao.selectAll()
    }
}