package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.entity.Mark;
import com.api.entity.Mark.MarkKey;

public interface MarkRepository extends JpaRepository<Mark, MarkKey>{

}
