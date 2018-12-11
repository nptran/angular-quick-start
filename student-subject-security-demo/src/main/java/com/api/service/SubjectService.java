package com.api.service;

import java.util.List;

import com.api.entity.Subject;

public interface SubjectService {

	void save(Subject subject);
	
	void delete(Integer id);
	
	List<Subject> getAll();
	
	Subject getOne(Integer id);
	
}
