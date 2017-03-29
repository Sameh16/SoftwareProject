package com.GameForAll.models;

public class Game {


	private String GameName;
	private String GameDescription;
	private int GameId;
	private int TypeId;
	private int CourseId;
	private  int NumOfLevel;
	
	
	public int getTypeId() {
		return TypeId;
	}
	public void setTypeId(int typeId) {
		TypeId = typeId;
	}
	public int getCourseId() {
		return CourseId;
	}
	public void setCourseId(int courseId) {
		CourseId = courseId;
	}
	public String getGameName() {
		return GameName;
	}
	public void setGameName(String gameName) {
		GameName = gameName;
	}
	public int getGameId() {
		return GameId;
	}
	public void setGameId(int gameId) {
		GameId = gameId;
	}
	public String getGameDescription() {
		return GameDescription;
	}
	public void setGameDescription(String gameDescription) {
		GameDescription = gameDescription;
	}
	public int getNumOfLevel() {
		return NumOfLevel;
	}
	public void setNumOfLevel(int numOfLevel) {
		NumOfLevel = numOfLevel;
	} 
	
	
	
}
