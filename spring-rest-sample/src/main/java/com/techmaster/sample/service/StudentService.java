package com.techmaster.sample.service;

import java.util.List;

import com.techmaster.sample.model.Student;

public interface StudentService {

	List<Student> getAll();

	void save(Student student);

	Student getById(Long id);
	
	void delete(Long id);
}
