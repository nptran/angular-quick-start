package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.Mark;
import com.api.service.MarkService;


@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path = "/v1/marks")
@RestController
public class MarkController {
	
	@Autowired
	private MarkService service;
	
	@GetMapping("/{studentId}")
	public ResponseEntity<List<Mark>> getAllMarks(@PathVariable Integer studentId) {
		
		return new ResponseEntity<List<Mark>>(service.getAll(studentId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> postMark(@RequestBody Mark mark) {
		
		service.save(mark);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("avg/{studentId}")
	public ResponseEntity<Double> getAvgMark(@PathVariable Integer studentId) {
		
		return new ResponseEntity<Double>(service.avgMark(studentId), HttpStatus.OK);
	}
}
