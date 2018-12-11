/**
 * 
 */
package com.api.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Phuc Tran
 *
 */

@Embeddable
public class MarkKey implements Serializable {

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
	
	public MarkKey() {}
	
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
