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
@Table(name = "teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	
	@Column(name = "Name")
	private String Name;
	
	@Column(name = "Password")
	private String Password;
	
	@Column(name = "Age")
	private int Age;
	
	@Column(name = "Gender")
	private String Gender;
	
	@Column(name = "Username",  unique = true)
	private String Username;

	
	@Column(name = "Email",  unique = true)
	private String AcadmicMail;
	
	@OneToMany(mappedBy = "teacher" , cascade = CascadeType.ALL)
	private Set<Course> courses;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "teachergame", joinColumns = @JoinColumn(name = "TeacherId", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "GameId", referencedColumnName = "GameId"))
    private Set<Game> games;

	public Teacher()
	{
		
	}


	public Teacher(String name, String password, int age, String gender, String username, String acadmicMail) {
		Name = name;
		Password = password;
		Age = age;
		Gender = gender;
		Username = username;
		AcadmicMail = acadmicMail;
	}


	public long getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
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


	public String getAcadmicMail() {
		return AcadmicMail;
	}


	public void setAcadmicMail(String acadmicMail) {
		AcadmicMail = acadmicMail;
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


	public void setId(long id) {
		Id = id;
	}


	@Override
	public String toString() {
		return "Teacher [Id=" + Id + ", Name=" + Name + ", Password=" + Password + ", Age=" + Age + ", Gender=" + Gender
				+ ", Username=" + Username + ", AcadmicMail=" + AcadmicMail + ", courses=" + courses + "]";
	}
	
	
	
	
	
	
}
