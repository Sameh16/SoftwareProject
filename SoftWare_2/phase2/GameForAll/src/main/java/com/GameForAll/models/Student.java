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

	@Column(name = "Email")
	private String Email;

	@Column(name = "Password")
	private String Password;

	@Column(name = "Age")
	private int Age;

	@Column(name = "Gender")
	private String Gender;

	@Column(name = "Username")
	private String Username;
	
	/*@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "studentcourse", joinColumns = @JoinColumn(name = "StudentId", referencedColumnName = "StudentId"), 
    inverseJoinColumns = @JoinColumn(name = "CourseId", referencedColumnName = "CourseId"))
    private Set<Course> courses;*/

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

}
