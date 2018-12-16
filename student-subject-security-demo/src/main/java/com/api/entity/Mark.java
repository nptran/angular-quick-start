/**
 * 
 */
package com.api.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Phuc Tran
 *
 */

@Entity
@Table(name="Mark")
public class Mark {
	
	@JsonIgnore
	@EmbeddedId
	private MarkKey id;
	
	@ManyToOne(fetch=FetchType.EAGER)		//Must be EAGER when getting
	@MapsId("studentId")
	@JsonIgnoreProperties({"dob","marks"})
	private Student student;
	
	@ManyToOne(fetch=FetchType.EAGER)		//Must be EAGER when getting
	@MapsId("subjectId")
	@JsonIgnoreProperties("marks")
	private Subject subject;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@MapsId("teacherId")
	@JsonIgnoreProperties("marks")
	private Teacher teacher;
	
	@Column(name="studentmark", nullable=true)
	private Double studentmark ;
	
	public Mark() {	id = new MarkKey(); }
	 
    public Mark(Student student, Subject subject, Teacher teacher) {
        this.student = student;
        this.subject = subject;
        this.teacher = teacher;
        this.id = new MarkKey(student.getId(), subject.getId(), teacher.getId());
    }

	public MarkKey getId() {
		return id;
	}

	public void setId(MarkKey id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Double getStudentmark() {
		return studentmark;
	}

	public void setStudentmark(Double studentmark) {
		this.studentmark = studentmark;
	}

}
