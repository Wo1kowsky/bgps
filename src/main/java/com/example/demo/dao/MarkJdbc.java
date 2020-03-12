package com.example.demo.dao;


import com.example.demo.model.Mark;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class MarkJdbc {

    private final JdbcTemplate jdbcTemplate;

    public MarkJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Mark get(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM mark WHERE id = ?",
                this::mapMark,
                id
        );
    }

    private Mark mapMark(ResultSet rs, int i) throws SQLException {
        return new Mark(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("value")
        );
    }
}