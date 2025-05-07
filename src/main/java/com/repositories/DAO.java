package com.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.models.Student;

@Repository
public interface DAO extends JpaRepository<Student,Integer>{
//	void insert(Student student);
//    void update(Student student);
//    void delete(int id);
//    List<Student> findAll();
}
