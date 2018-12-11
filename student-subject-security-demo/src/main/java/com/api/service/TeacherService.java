package com.api.service;

import java.util.List;

import com.api.entity.Teacher;

public interface TeacherService {
	
	void save(Teacher teacher);
	
	void delete(Integer id);
	
	List<Teacher> getAll();
	
	Teacher getOne(Integer id);

}
