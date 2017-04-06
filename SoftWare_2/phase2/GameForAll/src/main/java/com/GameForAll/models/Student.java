package com.GameForAll.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student implements Serializable,User {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5890878254374709122L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;

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
