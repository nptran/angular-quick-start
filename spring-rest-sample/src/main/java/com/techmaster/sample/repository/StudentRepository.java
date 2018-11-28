package com.techmaster.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techmaster.sample.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
