package com.GameForAll.models;

import java.util.ArrayList;

public class Course {
	private String CourseName;
	private int CategoryId;
	private int TeacherID;
	private int CourseId;
	private int MinimunAge;
	
	public Course()
	{
		CourseId=1;
		CourseName="Mariam";
		TeacherID = 5;
		MinimunAge = 10;
		
	}
	public String getCourseName() 
	{
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public int getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}
	public int getTeacherID() {
		return TeacherID;
	}
	public void setTeacherID(int teacherID) {
		TeacherID = teacherID;
	}
	public int getCourseId() {
		return CourseId;
	}
	public void setCourseId(int courseId) {
		CourseId = courseId;
	}
	public int getMinimunAge() {
		return MinimunAge;
	}
	public void setMinimunAge(int minimunAge) {
		MinimunAge = minimunAge;
	}
	public ArrayList<Course> SelectAll(int categoryId2)
	{
		ArrayList<Course> courses=new ArrayList<>();
		Course course = new Course();
		course.setCategoryId(categoryId2);
		courses.add(course);
		return courses;
	}
	public boolean SaveCourse(Course course)
	{
		return true;
	}
}
