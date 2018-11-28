package com.techmaster.sample.controller;

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

import com.techmaster.sample.model.Student;
import com.techmaster.sample.service.StudentService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value = "/students")
public class StudentController {

	StudentService service;

	@Autowired
	public StudentController(StudentService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() {

		List<Student> students = service.getAll();

		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> insertStudent(@Valid @RequestBody Student student) {
		service.save(student);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> findStudent(@PathVariable Long id) {
		
		return new ResponseEntity<Student>(service.getById(id),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
		service.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
