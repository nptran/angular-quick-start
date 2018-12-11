package com.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.entity.Teacher;
import com.api.repository.TeacherRepository;
import com.api.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private TeacherRepository repository;

	public void save(Teacher teacher) {
		repository.save(teacher);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public List<Teacher> getAll() {
		return repository.findAll();
	}

	public Teacher getOne(Integer id) {
		return repository.getOne(id);
	}
	
}
