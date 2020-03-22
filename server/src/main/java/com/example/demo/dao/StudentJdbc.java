package com.example.demo.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Student;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentJdbc {
    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public StudentJdbc(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("student")
                .usingGeneratedKeyColumns("id");
    }

    public Student get(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM student WHERE id = ?", this::mapStudent, id);
    }

    public List<Student> getStudyGroupId(int study_group_id) {
        return jdbcTemplate.query("SELECT * FROM STUDENT WHERE study_group_id = ?", this::mapStudent, study_group_id);
    }

    public List<Student> getAll() {
        return jdbcTemplate.query("SELECT * FROM STUDENT", this::mapStudent);
    }

    public int create(Student student) {
        Map<String, Object> parameters = new HashMap<>();

        parameters.put("surname", student.getSurname());
        parameters.put("name", student.getName());
        parameters.put("second_name", student.getSecondName());
        parameters.put("study_group_id", student.getStudyGroupId());

        return simpleJdbcInsert.executeAndReturnKey(parameters).intValue();
    }

    public int update(Student student) {
        return jdbcTemplate.update("UPDATE STUDENT SET surname = ?, name = ?, second_name = ?, study_group_id = ? WHERE id = ?",
                student.getSurname(),
                student.getName(),
                student.getSecondName(),
                student.getStudyGroupId(),
                student.getId());
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM STUDENT WHERE id = ?", id);
    }

    public List<Student> getAllLocal() {
        return jdbcTemplate.query(
                "SELECT * FROM student_local",
                this::mapStudent
        );
    }

    private Student mapStudent(ResultSet resultSet, int i) throws SQLException {
        return new Student(
                resultSet.getInt("id"),
                resultSet.getString("surname"),
                resultSet.getString("name"),
                resultSet.getString("second_name"),
                resultSet.getInt("study_group_id")
        );
    }
}