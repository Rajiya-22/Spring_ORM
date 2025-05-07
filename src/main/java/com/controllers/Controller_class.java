package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.models.Student;
import com.repositories.DAO;

@RestController
public class Controller_class {
	@Autowired
	DAO dao;
	
	@RequestMapping("/")
	public void home() {
		System.out.println("home page");
	}
	@GetMapping("/getAll")
	public List<Student> getAll(){
		return dao.findAll();
	}
	@PostMapping("/insert")
	public void insert(@RequestBody Student s){
		dao.save(s);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		dao.deleteById(id);
	}
	@PutMapping("/update")
	public void update(@RequestBody Student s) {
		dao.save(s);
	}
}
