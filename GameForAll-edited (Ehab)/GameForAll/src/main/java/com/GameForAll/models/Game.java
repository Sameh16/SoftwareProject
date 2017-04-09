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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 353170622331771686L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long GameId;
	
	
	@Column(name = "GameName")
	private String GameName;
	
	@Column(name = "NumberOfLevel")
	private  int NumOfLevel;
	
	@Column(name = "Description")
	private String Description;
	
	
	@ManyToOne
	@JoinColumn(name = "TypeId")
	private Type type;
	
	@ManyToOne
	@JoinColumn(name = "CourseId")
	private Course course;
	
	
	@OneToMany(mappedBy = "game" , cascade = CascadeType.ALL)
	private Set<Question> questions;
	
	@ManyToMany(mappedBy = "games")
    private Set<Teacher> teachers;
	
	@ManyToMany(mappedBy = "games")
    private Set<Student> students;

	
	
	

	
	
	
}
