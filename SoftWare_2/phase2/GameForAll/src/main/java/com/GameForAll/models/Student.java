package com.GameForAll.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "student")
public class Student implements User{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	
	@Column(name = "Name")
	private String Name;

	@Column(name = "Email" ,  unique = true)
	private String email;

	@Column(name = "Password")
	private String password;

	@Column(name = "Age")
	private int Age;

	@Column(name = "Gender")
	private String Gender;

	@Column(name = "Username",  unique = true)
	private String username;

	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "studentcourse", joinColumns = @JoinColumn(name = "StudentId", referencedColumnName = "Id"), inverseJoinColumns = @JoinColumn(name = "CourseId", referencedColumnName = "Id"))
	private Set<Course> courses;

	@OneToMany (mappedBy = "student" , cascade = CascadeType.ALL)
	private Set<StudentGame> studentGames;



	public Student() {

	}

	public Student(String name, String email, String password, int age, String gender, String userName) {
		Name = name;
		this.email = email;
		this.password = password;
		Age = age;
		Gender = gender;
		this.username = userName;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonIgnore
	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@JsonIgnore
	public Set<StudentGame> getStudentGames() {
		return studentGames;
	}

	public void setStudentGames(Set<StudentGame> studentGames) {
		this.studentGames = studentGames;
	}

	
	
	
	

	
	

}
