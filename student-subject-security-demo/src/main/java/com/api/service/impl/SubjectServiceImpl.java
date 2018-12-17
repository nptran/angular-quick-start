package com.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.entity.Subject;
import com.api.repository.SubjectRepository;
import com.api.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	private SubjectRepository repository;

	public void save(Subject subject) {
		repository.save(subject);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public List<Subject> getAll() {
		return repository.findAll();
	}

	public Subject getOne(Integer id) {
		return repository.findById(id).get();
	}
	
}
