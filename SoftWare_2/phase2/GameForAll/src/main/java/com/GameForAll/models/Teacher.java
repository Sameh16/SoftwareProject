package com.GameForAll.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "teacher")
public class Teacher implements User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	
	@Column(name = "Name")
	private String Name;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Age")
	private int Age;
	
	@Column(name = "Gender")
	private String Gender;
	
	@Column(name = "Username",  unique = true)
	private String username;

	@Column(name = "Email",  unique = true)
	private String acadmicMail;
	
	@OneToMany(mappedBy = "teacher" , cascade = CascadeType.ALL)
	private Set<Course> courses;
	
	@OneToMany (mappedBy = "teacher" , cascade = CascadeType.ALL)
	private Set<Contributor> contributors;
	
	

	public Teacher()
	{
		
	}


	public Teacher(String name, String password, int age, String gender, String username, String acadmicMail) {
		Name = name;
		this.password = password;
		Age = age;
		Gender = gender;
		this.username = username;
		this.acadmicMail = acadmicMail;
	}


	public long getId() {
		return Id;
	}

	

	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
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
	
	

	@JsonIgnore
	public Set<Contributor> getContributors() {
		return contributors;
	}


	public void setContributors(Set<Contributor> contributors) {
		this.contributors = contributors;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getAcadmicMail() {
		return acadmicMail;
	}


	public void setAcadmicMail(String acadmicMail) {
		this.acadmicMail = acadmicMail;
	}

	@JsonIgnore
	public Set<Course> getCourses() {
		return courses;
	}

	
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	


	public void setId(long id) {
		Id = id;
	}
	
	


	@Override
	public String toString() {
		return "Teacher [Id=" + Id + ", Name=" + Name + ", Password=" + password + ", Age=" + Age + ", Gender=" + Gender
				+ ", Username=" + username + ", AcadmicMail=" + acadmicMail + ", courses=" + courses + "]";
	}
	
	
	
	
	
	
}
