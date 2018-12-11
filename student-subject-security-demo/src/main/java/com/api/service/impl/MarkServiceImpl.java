package com.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.entity.Mark;
import com.api.repository.MarkRepository;
import com.api.service.MarkService;

@Service
public class MarkServiceImpl implements MarkService {

	@Autowired
	private MarkRepository repo;
	
	@Override
	public List<Mark> getAll(Integer studentId) {
		List<Mark> marks = new ArrayList<>();
		for(Mark m : repo.findAll()) {
			if (m.getId().getStudentId() == studentId) {
				marks.add(m);
			}
		}
		return marks;
	}

	@Override
	public void save(Mark mark) {
		repo.save(mark);
	}

	@Override
	public Double avgMark(Integer studentId) {
		int counter = 0;
		double avg = 0;
		for(Mark m : this.getAll(studentId)) {
			avg += m.getStudentmark();
			counter++;
		}
		
		avg = avg/counter;
		
		return ((double) Math.round(avg*100)/100);
	}

	
}
