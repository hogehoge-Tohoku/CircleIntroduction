package com.base.t.CircleIntroduction.Repository.Jdbc

import com.base.t.CircleIntroduction.Domain.Circle
import com.base.t.CircleIntroduction.Repository.CircleDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.core.namedparam.SqlParameterSource
import org.springframework.stereotype.Repository

@Suppress("SqlResolve")
@Repository
class CircleDaoJdbcImpl: CircleDao {

    @Autowired
    lateinit var jdbc: NamedParameterJdbcTemplate

    private val rowMapper = RowMapper<Circle> {rs, _ ->
        Circle(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("classification"),
                rs.getString("organization"),
                rs.getString("atmosphere"),
                rs.getString("introduction"),
                rs.getString("welcome_party_inf"),
                rs.getString("email"),
                rs.getString("twitter"),
                rs.getString("instagram"),
                rs.getString("picture_name"),
                rs.getInt("picture_num")
        )
    }

    override fun count(): Int {
        val circle = jdbc.query("SELECT * FROM circle", rowMapper)
        return circle.size
    }

    override fun selectOne(id: Int): Circle {
        val sql = "SELECT * FROM circle WHERE id = :id"
        val param: SqlParameterSource = MapSqlParameterSource()
                .addValue("id", id)
        val map = jdbc.queryForMap(sql, param)

        return Circle(
                map["id"] as Int?,
                map["name"] as String?,
                map["classification"] as String,
                map["organization"] as String?,
                map["atmosphere"] as String?,
                map["introduction"] as String?,
                map["welcome_party_inf"] as String?,
                map["email"] as String?,
                map["twitter"] as String?,
                map["instagram"] as String?,
                map["picture_name"] as String?,
                map["picture_num"] as Int?
        )
    }

    override fun selectAll():List<Circle> {
        val sql = "SELECT * FROM circle"
        return jdbc.query(sql, rowMapper)
    }

    override fun conditionalSelect(classification: MutableList<String?>?, organization: MutableList<String?>?): List<Circle> {

        val sql = "SELECT * FROM circle WHERE classification IN (:classification) AND organization IN (:organization)"
        val param: SqlParameterSource = MapSqlParameterSource()
                .addValue("classification", classification)
                .addValue("organization", organization)
        return jdbc.query(sql, param, rowMapper)
    }

    override fun classificationSelect(classification: MutableList<String?>?):List<Circle> {

        val sql = "SELECT * FROM circle WHERE classification IN (:classification)"
        val param: SqlParameterSource = MapSqlParameterSource()
                .addValue("classification", classification)

        return jdbc.query(sql, param, rowMapper)
    }

    override fun organizationSelect(organization: MutableList<String?>?):List<Circle> {
        val sql = "SELECT * FROM circle WHERE organization IN (:organization)"
        val param: SqlParameterSource = MapSqlParameterSource()
                .addValue("organization", organization)

        return jdbc.query(sql, param, rowMapper)
    }
}
