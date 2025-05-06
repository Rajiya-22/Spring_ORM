package com.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.models.Student;

@Repository
public class DAOImpl implements DAO{
	@Autowired
	JdbcTemplate template;
	
	String sql_findAll = "SELECT * FROM student";
	String sql_insert = "INSERT INTO student (id, name) VALUES (?, ?)";
	String sql_delete = "DELETE FROM student WHERE id = ?";
	String sql_update = "update student set name=? where id=?";
	
	@Override
	public void insert(Student student) {
		template.update(sql_insert,student.getId(),student.getName());
	}

	@Override
	public void update(Student student) {
		template.update(sql_update,student.getName(),student.getId());
	}

	@Override
	public void delete(int id) {
		template.update(sql_delete,id);
	}

	@Override
	public List<Student> findAll() {
		return template.query(sql_findAll, new RowMapper<Student>() {
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                System.out.println(s.toString());
                return s;
            }
        });
	}

}