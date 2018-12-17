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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "subject")
public class Subject implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private String name;
	
	@NotNull
	private Integer credit;
	
	@JsonIgnore
	@OneToMany(mappedBy="subject", cascade=CascadeType.MERGE, orphanRemoval=true)
	private Set<Mark> marks = new HashSet<>();
	
	public Subject() {	}
	
	public Subject(Integer id, String name, Integer credit) {
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

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public Set<Mark> getMarks() {
		return marks;
	}

	public void setMarks(Set<Mark> marks) {
		this.marks = marks;
	}
	
}
