package com.GameForAll.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "notification")
public class Notification implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 222770348397870442L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;

	@Column(name = "gameName")
	private String gameName;

	@ManyToOne
	@JoinColumn(name = "studentId")
	private Student student;

	private String teacherName;

	private String CourseName;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	@JsonIgnore
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
