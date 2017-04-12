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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "student")
public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5890878254374709122L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;

	@Column(name = "Name")
	private String Name;

	@Column(name = "Email" ,  unique = true)
	private String Email;

	@Column(name = "Password")
	private String Password;

	@Column(name = "Age")
	private int Age;

	@Column(name = "Gender")
	private String Gender;

	@Column(name = "Username",  unique = true)
	private String Username;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "studentcourse", joinColumns = @JoinColumn(name = "StudentId", referencedColumnName = "Id"), inverseJoinColumns = @JoinColumn(name = "CourseId", referencedColumnName = "Id"))
	private Set<Course> courses;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "studentgame", joinColumns = @JoinColumn(name = "StudentId", referencedColumnName = "Id"), inverseJoinColumns = @JoinColumn(name = "GameId", referencedColumnName = "GameId"))
	private Set<Game> games;

	public Student() {

	}

	public Student(String name, String email, String password, int age, String gender, String userName) {
		Name = name;
		Email = email;
		Password = password;
		Age = age;
		Gender = gender;
		Username = userName;
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
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
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
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	@JsonIgnore
	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@JsonIgnore
	public Set<Game> getGames() {
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}

}
