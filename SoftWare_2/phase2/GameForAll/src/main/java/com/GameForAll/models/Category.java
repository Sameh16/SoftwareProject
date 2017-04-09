package com.GameForAll.models;

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
@Table(name = "category")
public class Category  {


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long CategoryId;
	
	
	@Column(name = "CategoryName")
	private String CategoryName;

	@OneToMany(mappedBy = "category" ,cascade = CascadeType.ALL )
	private  Set<Course> courses;

	protected Category() {
		
	}

	public Category(int categoryId,String categoryName)
	{
		CategoryId=categoryId;
		CategoryName = categoryName;
	}
	
	

	

}
