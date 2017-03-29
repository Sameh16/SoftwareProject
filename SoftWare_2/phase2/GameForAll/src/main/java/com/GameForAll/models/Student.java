package com.GameForAll.models;


public class Student implements User {
	private int StudentId;
	private String Name;
	private String Email;
	private String Password;
	private int Age;
	private String Gender;
	private String UserName;

	public Student() {
		Name = "Mariam";
		Email = "Mariam";
		Password = "Mariam";
		Age = 12;
		Gender = "female";
		UserName = "Mariam";
		StudentId = 2;
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

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public int getStudentId() {
		return StudentId;
	}

	@Override
	public boolean AddUser(User user) {
		return true;
		// if the name is not valid or the a missing field is it will return
		// false;
	}

	@Override
	public boolean SearchUser(User user) {
		return true;
	}

	@Override
	public User LoadUser(String UserName, String Password) {
		User user = new Student();
		return user;

	}

}
