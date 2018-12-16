package com.api.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@JsonIgnoreProperties({"student","studentmark","subject"})
	@OneToMany(mappedBy="subject", cascade=CascadeType.MERGE, orphanRemoval=true)
	private Set<Mark> marks = new HashSet<>();
	
	public Subject() { }
	
	public Subject(Integer id, String name, Short credit) {
		this.id = id;
		this.name = name;
		this.credit = credit;
	}
	
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

	public Set<Mark> getMarks() {
		return marks;
	}

	public void setMarks(Set<Mark> marks) {
		this.marks = marks;
	}
	
}
