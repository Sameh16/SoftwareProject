package com.GameForAll.models;

import java.io.Serializable;

public class StudentGameID implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 92584856823727288L;

	private long student;
	
	private long game;


	
	
	
	public StudentGameID() {
		super();
	}

	public StudentGameID(long student, long game) {
		super();
		this.student = student;
		this.game = game;
	}


	public long getStudent() {
		return student;
	}

	public void setStudent(long student) {
		this.student = student;
	}

	public long getGame() {
		return game;
	}

	public void setGame(long game) {
		this.game = game;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
	
	
	
	
	

}
