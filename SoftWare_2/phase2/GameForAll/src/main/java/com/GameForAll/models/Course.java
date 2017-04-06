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

@Entity
@Table(name = "course")
public class Course implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6720185840479776582L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@Column(name = "Name")
	private String CourseName;
	
	@Column(name = "Age")
	private int MinimunAge;
	
	@ManyToOne
	@JoinColumn(name = "CategoryId")
	private Category category;
	
	
	@ManyToOne
	@JoinColumn(name = "TeacherId")
	private Teacher teacher;
	

	
	public Course(String courseName, int minimunAge, Category category, Teacher teacher) {

		CourseName = courseName;
		MinimunAge = minimunAge;
		this.category = category;
		this.teacher = teacher;
	}


	public Course()
	{
		
	}


	public String getCourseName() {
		return CourseName;
	}


	public void setCourseName(String courseName) {
		CourseName = courseName;
	}


	public int getMinimunAge() {
		return MinimunAge;
	}


	public void setMinimunAge(int minimunAge) {
		MinimunAge = minimunAge;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public Teacher getTeacher() {
		return teacher;
	}


	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	@Override
	public String toString() {
		return "Course [Id=" + Id + ", CourseName=" + CourseName + ", MinimunAge=" + MinimunAge + ", category="
				+ category + ", teacher=" + teacher + "]";
	}
	
	
}
