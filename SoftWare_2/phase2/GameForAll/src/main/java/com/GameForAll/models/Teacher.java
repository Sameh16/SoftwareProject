package com.GameForAll.models;




public class Teacher implements User {

	private String Name;
	private String Password ;
	private int Age;
	private String Gender;
	private String UserName ;
	private String AcadmicMail;
	private int TeacherId;
	
	public Teacher() {
		Name = "Mariam";
		Password = "12345";
		Age = 10;
		Gender = "Female";
		UserName = "Mariam";
		AcadmicMail = "Mariam";
		TeacherId = 1;
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
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getAcadmicMail() {
		return AcadmicMail;
	}
	public void setAcadmicMail(String acadmicMail) {
		AcadmicMail = acadmicMail;
	}
	public int getTeacherId() {
		return TeacherId;
	}
	@Override
	public boolean AddUser(User user)
	{
		
		return true;
		//if the name is not valid or the a missing field is it will return false;
	}
	@Override
	public boolean SearchUser(User user) 
	{
		return true;
	}
	@Override
	public User LoadUser(String UserName,String Password)
	{
		User user=new Teacher();
		return user;
		
	}
	
}
