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

	public Category(String categoryName)
	{
		CategoryName = categoryName;
	}

	public long getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(long categoryId) {
		CategoryId = categoryId;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Category [CategoryId=" + CategoryId + ", CategoryName=" + CategoryName + ", courses=" + courses + "]";
	}
	
	
	
	

	

}
