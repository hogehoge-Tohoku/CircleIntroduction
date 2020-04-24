package com.base.t.CircleIntroduction.Service

import com.base.t.CircleIntroduction.Domain.Circle
import com.base.t.CircleIntroduction.Repository.Jdbc.CircleDaoJdbcImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class OptionService{
    @Autowired
    lateinit var dao: CircleDaoJdbcImpl

    fun conditionalSelect(classification: MutableList<String?>?, organization: MutableList<String?>?): List<Circle> {
        //全く選択していないまたはどちらも少なくとも一つ以上選択している場合
        return if (classification!!.size < 1 && organization!!.size < 1 ||
                classification.size > 0 && organization!!.size > 0) {
            dao.conditionalSelect(classification, organization)
        }//classificationを選択していなくかつorganizationは選択している場合
        else if(classification.size < 1) {
            dao.organizationSelect(organization)
        }//organizationを選択していなくかつclassificationは選択している場合
        else {
            dao.classificationSelect(classification)
        }
    }

    fun conditionalCount(classification: MutableList<String?>?, organization: MutableList<String?>?): Int {
        return if (classification!!.size < 1 && organization!!.size < 1 ||
                classification.size > 0 && organization!!.size > 0) {
            dao.conditionalSelect(classification, organization).size
        }//classificationを選択していなくかつorganizationは選択している場合
        else if(classification.size < 1) {
            dao.organizationSelect(organization).size
        }//organizationを選択していなくかつclassificationは選択している場合
        else {
            dao.classificationSelect(classification).size
        }
    }
}