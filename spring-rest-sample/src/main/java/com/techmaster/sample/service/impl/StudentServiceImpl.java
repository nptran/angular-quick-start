package com.techmaster.sample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techmaster.sample.model.Student;
import com.techmaster.sample.repository.StudentRepository;
import com.techmaster.sample.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository repository;

	@Autowired
	public StudentServiceImpl(StudentRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Student> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(Student student) {
		repository.save(student);
	}

	@Override
	public Student getById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
