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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "type")
public class Type implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7151214259447799698L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long TypeId;

	@Column(name = "TypeName",  unique = true)
	private String TypeName;

	
	@OneToMany(mappedBy = "type" , cascade = CascadeType.ALL)
	private Set<Game> games;

	
	public Type(String typeName) {

		TypeName = typeName;
	}

	public Type() {

	}

	public long getTypeId() {
		return TypeId;
	}

	public void setTypeId(long typeId) {
		TypeId = typeId;
	}

	public String getTypeName() {
		return TypeName;
	}

	public void setTypeName(String typeName) {
		TypeName = typeName;
	}
	@JsonIgnore
	public Set<Game> getGames() {
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}
	
	
	
	

}
