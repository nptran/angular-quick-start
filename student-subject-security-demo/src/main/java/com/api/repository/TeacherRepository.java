package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

}
