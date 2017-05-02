package com.GameForAll.models;

import java.io.Serializable;

public class ContributorID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 327790091309430579L;
	
	private long teacher;
	
	private long game;

	public long getTeacher() {
		return teacher;
	}

	public void setTeacher(long teacher) {
		this.teacher = teacher;
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
