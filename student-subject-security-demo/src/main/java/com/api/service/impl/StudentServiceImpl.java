package com.api.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.entity.Student;
import com.api.repository.StudentRepository;
import com.api.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService, UserDetailsService {

	@Autowired
	private StudentRepository repository;
	
	public void save(Student student) {
		repository.save(student);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public List<Student> getAll() {
		return repository.findAll();
	}

	public Student getOne(Integer id) {
		return repository.getOne(id);
	}

	/*	To set user details: user-name is student's name and password is student's date of birth 
	 * */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Student student = repository.findByName(username);

		if(student==null) throw new UsernameNotFoundException("STUDENT NOT FOUND");
		
		return new User(student.getName(), student.getPassword(), getAuthority());
	}
	
	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	public Student getOne(String name) {
		return repository.findByName(name);
	}

}
