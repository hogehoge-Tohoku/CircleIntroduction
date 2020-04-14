package com.base.t.CircleIntroduction.Repository.Jdbc

import com.base.t.CircleIntroduction.Entity.Circle
import com.base.t.CircleIntroduction.Repository.CircleDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.core.namedparam.SqlParameterSource
import org.springframework.stereotype.Repository

@Repository
class CircleDaoJdbcImpl: CircleDao {


    @Autowired
    lateinit var jdbc: NamedParameterJdbcTemplate

    private val rowMapper = RowMapper<Circle> {rs, _ ->
        Circle(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("organization"),
                rs.getString("introduction")
        )
    }

    override fun count(): Int {
        val circle = jdbc.query("SELECT * FROM circle", rowMapper)
        return circle.size
    }

    override fun selectOne(id: Int): Circle {
        var sql = "SELECT * FROM circle WHERE id = :id"
        val param: SqlParameterSource = MapSqlParameterSource()
                .addValue("id", id)
        val map = jdbc.queryForMap(sql, param)

        return Circle(
                map["id"] as Int?,
                map["name"] as String?,
                map["organization"] as String?,
                map["introduction"] as String?
        )
    }

    override fun selectAll():List<Circle> {
        val sql = "SELECT * FROM circle"
        return jdbc.query(sql, rowMapper)
    }

    override fun selectOrganization(organization: String):List<Circle> {
        TODO("Not yet implemented")
    }

}
