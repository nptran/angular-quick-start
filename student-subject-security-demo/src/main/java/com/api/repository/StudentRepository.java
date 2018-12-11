package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByName(String name);
	
}
