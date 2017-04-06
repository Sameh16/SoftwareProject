package com.GameForAll.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "type")
public class Type implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7151214259447799698L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int TypeId;

	@Column(name = "TypeName")
	private String TypeName;

	
	public Type(String typeName) {

		TypeName = typeName;
	}

	public Type() {

	}

}
