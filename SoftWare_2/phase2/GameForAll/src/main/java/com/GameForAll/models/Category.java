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

import net.minidev.json.annotate.JsonIgnore;

@Entity
@Table(name = "category")
public class Category  {


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long CategoryId;
	
	
	@Column(name = "CategoryName")
	private String categoryName;

	@OneToMany(mappedBy = "category" ,cascade = CascadeType.ALL )
	private  Set<Course> courses;

	protected Category() {
		
	}

	public Category(String categoryName)
	{
		this.categoryName = categoryName;
	}

	public long getCategoryId() {
		return CategoryId;
	}
	
	public void setCategoryId(long categoryId) {
		CategoryId = categoryId;
	}

	@JsonIgnore
	public String getCategoryName() {
		return categoryName;
	}
	
	@JsonIgnore
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@JsonIgnore
	public Set<Course> getCourses() {
		return courses;
	}
	
	@JsonIgnore
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Category [CategoryId=" + CategoryId + ", CategoryName=" + categoryName + ", courses=" + courses + "]";
	}

	
	
	

	

	

}
