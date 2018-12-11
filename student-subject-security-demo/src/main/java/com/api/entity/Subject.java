package com.api.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "subject")
public class Subject implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Size(min = 2, max = 50, message="Tên môn học từ 2-50 ký tự")
	private String name;
	
	private Short credit;
	
	@JsonIgnoreProperties({"studentId","subjectId"})
	@OneToMany(mappedBy="subject", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Mark> marks = new ArrayList<>();

	@JsonIgnoreProperties("subjects")
	@ManyToMany(cascade=CascadeType.MERGE, fetch=FetchType.LAZY)
	@JoinTable(name="subjects_teachers", joinColumns = {@JoinColumn(name ="subject_id")},
								  inverseJoinColumns = {@JoinColumn(name="teacher_id")})
	private List<Teacher> teachers = new ArrayList<>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getCredit() {
		return credit;
	}

	public void setCredit(Short credit) {
		this.credit = credit;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
}
