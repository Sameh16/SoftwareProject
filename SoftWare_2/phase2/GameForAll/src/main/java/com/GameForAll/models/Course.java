package com.GameForAll.models;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "course")
public class Course{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	
	@Column(name = "Name",  unique = true)
	private String courseName;
	
	@Column(name = "Age")
	private int MinimunAge;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "CategoryId")
	private Category category;
	
	
	@ManyToOne
	@JoinColumn(name = "TeacherId")
	private Teacher teacher;
	
	
	@OneToMany(mappedBy = "course" , cascade = CascadeType.ALL)
	private Set<Game> games;
	

	@ManyToMany(mappedBy = "courses")
    private Set<Student> students;
	
	public Course(String courseName, int minimunAge) 
	{
		this.courseName = courseName;
		MinimunAge = minimunAge;
	    
	}



	public Course() 
	{
	
	}



	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public int getMinimunAge() {
		return MinimunAge;
	}


	public void setMinimunAge(int minimunAge) {
		MinimunAge = minimunAge;
	}

	@JsonIgnore
	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}

	@JsonIgnore
	public Teacher getTeacher() {
		return teacher;
	}


	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


	public long getId() {
		return Id;
	}


	public void setId(long id) {
		Id = id;
	}


	@JsonIgnore
	public Set<Game> getGames() {
		return games;
	}



	public void setGames(Set<Game> games) {
		this.games = games;
	}


	@JsonIgnore
	public Set<Student> getStudents() {
		return students;
	}



	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	


	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public String toString() {
		return "Course [Id=" + Id + ", courseName=" + courseName + ", MinimunAge=" + MinimunAge + ", description="
				+ description + ", category=" + category + ", teacher=" + teacher + ", games=" + games + ", students="
				+ students + "]";
	}




	
}
