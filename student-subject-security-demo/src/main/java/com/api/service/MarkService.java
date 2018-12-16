package com.api.service;

import java.util.List;

import com.api.entity.Mark;

public interface MarkService {
	
	void save(Mark mark);
	
	List<Mark> getAll(Integer student);
	
	Double avgMark(Integer student);
	
}
