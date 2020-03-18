package com.example.demo.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.demo.model.StudyGroup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudyGroupJdbc {
    private final JdbcTemplate jdbcTemplate;

    public StudyGroupJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public StudyGroup get(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM STUDY_GROUP WHERE id = ?", this::mapStudyGroup, id);
    }

    public List<StudyGroup> getAll() {
        return jdbcTemplate.query("SELECT * FROM STUDY_GROUP", this::mapStudyGroup);
    }

    public int create(StudyGroup studyGroup) {
        return jdbcTemplate.update("INSERT INTO STUDY_GROUP (id, name) VALUES (?, ?)",
                studyGroup.getId(),
                studyGroup.getName());
    }

    public int update(StudyGroup studyGroup) {
        return jdbcTemplate.update("UPDATE STUDY_GROUP SET name = ? WHERE id = ?",
                studyGroup.getName(),
                studyGroup.getId());
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM STUDY_GROUP WHERE id = ?", id);
    }

    private StudyGroup mapStudyGroup(ResultSet resultSet, int i) throws SQLException {
        return new StudyGroup(
                resultSet.getInt("id"),
                resultSet.getString("name")
        );
    }
}