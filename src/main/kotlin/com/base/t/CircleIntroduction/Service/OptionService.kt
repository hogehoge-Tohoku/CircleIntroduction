package com.base.t.CircleIntroduction.Service

import com.base.t.CircleIntroduction.Domain.Circle
import com.base.t.CircleIntroduction.Repository.Jdbc.CircleDaoJdbcImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class OptionService{
    @Autowired
    lateinit var dao: CircleDaoJdbcImpl

    fun conditionalSelect(classification: List<String?>?, organization: MutableList<String?>?): List<Circle> {
        return dao.conditionalSelect(classification, organization)
    }

    fun conditionalCount(classification: List<String?>?, organization: MutableList<String?>?): Int {
        return dao.conditionalSelect(classification, organization).size
    }
}