package com.GameForAll.models;


public interface User {
	
	boolean AddUser(User user);
	boolean SearchUser(User user);
	User LoadUser( String UserName,  String Password); 
}
