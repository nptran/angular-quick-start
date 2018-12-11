package com.api.service;

import java.util.List;

import com.api.entity.Student;

public interface StudentService {
	
	void save(Student student);
	
	void delete(Integer id);
	
	List<Student> getAll();
	
	Student getOne(Integer id);
	
	Student getOne(String name);

}
