package com.GameForAll.models;

import java.io.Serializable;
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
@Table(name = "game")
public class Game implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 353170622331771686L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long GameId;
	
	@Column(name = "GameName",  unique = true)
	private String GameName;
	
	@Column(name = "NumberOfLevels")
	private  int NumOfLevels;
	
	@Column(name = "Description")
	private String Description;
	
	
	@ManyToOne
	@JoinColumn(name = "TypeId")
	private Type type;
	
	@ManyToOne
	@JoinColumn(name = "CourseId")
	private Course course;
	
	
	@OneToMany(mappedBy = "game" , cascade = CascadeType.ALL)
	private Set<Question> questions;
	
	@ManyToMany(mappedBy = "games")
    private Set<Teacher> teachers;
	
	@ManyToMany(mappedBy = "games")
    private Set<Student> students;

	public long getGameId() {
		return GameId;
	}

	public void setGameId(long gameId) {
		GameId = gameId;
	}

	public String getGameName() {
		return GameName;
	}

	public void setGameName(String gameName) {
		GameName = gameName;
	}

	public int getNumOfLevels() {
		return NumOfLevels;
	}

	public void setNumOfLevels(int numOfLevels) {
		NumOfLevels = numOfLevels;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	@JsonIgnore
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	@JsonIgnore
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	@JsonIgnore
	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	@JsonIgnore
	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	@JsonIgnore
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	
	
	

	
	
	
}
