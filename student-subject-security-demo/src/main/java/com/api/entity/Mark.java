/**
 * 
 */
package com.api.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Phuc Tran
 *
 */

@Entity
@Table(name="mark")
public class Mark {
	
	
	@EmbeddedId
	private MarkKey id;
	
	@ManyToOne(fetch=FetchType.EAGER)		//Must be EAGER when getting
	@MapsId("studentId")
	@JsonIgnoreProperties({"marks"})
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
	
	public Mark() { id = new MarkKey(); }
	 
    public Mark(Student student, Subject subject, Teacher teacher) {
    	this.id = new MarkKey(student.getId(), subject.getId(), teacher.getId());
        this.student = student;
        this.subject = subject;
        this.teacher = teacher;
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
	
	@Embeddable
	public static class MarkKey implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Column(name = "student_id")
		private Integer studentId;
		
		@Column(name = "subject_id")
		private Integer subjectId;
		
		@Column(name = "teacher_id")
		private Integer teacherId;
		
		public MarkKey() { }
		
		public MarkKey(Integer studentId, Integer subjectId, Integer teacherId) {
			this.studentId=studentId;
			this.subjectId=subjectId;
			this.teacherId=teacherId;
		}
		
		@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	 
	        if (o == null || getClass() != o.getClass()) 
	            return false;
	 
	        MarkKey that = (MarkKey) o;
	        return Objects.equals(studentId, that.studentId) && 
	               Objects.equals(subjectId, that.subjectId) &&
	               Objects.equals(teacherId, that.teacherId);
	    }
	 
	    @Override
	    public int hashCode() {
	        return Objects.hash(studentId, subjectId, teacherId);
	    }

		public Integer getStudentId() {
			return studentId;
		}

		public void setStudentId(Integer studentId) {
			this.studentId = studentId;
		}

		public Integer getSubjectId() {
			return subjectId;
		}

		public void setSubjectId(Integer subjectId) {
			this.subjectId = subjectId;
		}

		public Integer getTeacherId() {
			return teacherId;
		}

		public void setTeacherId(Integer teacherId) {
			this.teacherId = teacherId;
		}
		
	}


}
