package com.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.Student;
import com.api.service.StudentService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path = "/v1/students")
public class StudentController {

	private StudentService service;
	
	private PasswordEncoder encoder;
	
	@Autowired
	public StudentController(StudentService service, PasswordEncoder encoder) {
		this.service = service;
		this.encoder = encoder;
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudent() {
		return new ResponseEntity<List<Student>>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<Student> getStudent(@PathVariable(value = "username") String studentName) {
		return new ResponseEntity<Student>(service.getOne(studentName), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> saveStudent(@Valid @RequestBody Student student) {
		student.setPassword(encoder.encode(student.getPassword()));
		service.save(student);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
		service.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
