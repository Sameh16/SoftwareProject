package com.GameForAll.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher implements Serializable,User {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -663508675179779791L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@Column(name = "Name")
	private String Name;
	
	@Column(name = "Password")
	private String Password;
	
	@Column(name = "Age")
	private int Age;
	
	@Column(name = "Gender")
	private String Gender;
	
	@Column(name = "Username")
	private String Username;
	
	@Column(name = "Email")
	private String AcadmicMail;
	
	@OneToMany(mappedBy = "teacher" , cascade = CascadeType.ALL)
	private Set<Course> courses;

	public Teacher()
	{
		Id=0;
		Name = "";
		Password = "";
		Age = 0;
		Gender = "";
		Username ="";
		AcadmicMail = "";
	}


	public Teacher(int id,String name, String password, int age, String gender, String username, String acadmicMail) {
		Id=id;
		Name = name;
		Password = password;
		Age = age;
		Gender = gender;
		Username = username;
		AcadmicMail = acadmicMail;
	}
	
	
	
}
