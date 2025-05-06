package com.repositories;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.models.Student;

public interface DAO {
	void insert(Student student);
    void update(Student student);
    void delete(int id);
    List<Student> findAll();
}
