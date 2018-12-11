package com.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.Teacher;
import com.api.service.TeacherService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path = "/v1/teachers")
public class TeacherController {
	
	@Autowired
	private TeacherService service;
	
	@GetMapping
	public ResponseEntity<List<Teacher>> getAllTeachers() {
		return new ResponseEntity<List<Teacher>>(service.getAll(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> saveTeacher(@RequestBody @Valid Teacher teacher) {
		service.save(teacher);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTeacher(@PathVariable Integer id) {
		service.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
