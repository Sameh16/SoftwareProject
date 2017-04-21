/*package com.GameForAll.RestCotrollers;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.GameForAll.models.Course;

public class CourseRestControllerTest {


	CourseRestController controller = new CourseRestController();
	
	@DataProvider(name = "AddCourse")
	public Object[][] AddCourseTest() {

		return new Object[][] { { new Course("Math1", 4), "Mathmatic", "sameh", true },
				{ new Course("Math1", 8), "Mathmatic", "sameh", false },
				{ new Course("Math2", 8), "Mathmatic", "tester", false },
				{ new Course("Math1", 8) ,"Math", "sameh", false },
				{ null ,"Mathmatic", "sameh", false }
		};
	}

	@Test(dataProvider="AddCourse")
	public void AddCourse(Course course, String categoryName, String username,boolean res) {
<<<<<<< HEAD
		
		assertEquals(res, (boolean)controller.AddCourse(course, categoryName, username));
=======

			assertEquals(res,controller.AddCourse(course, categoryName, username) );
>>>>>>> 8f353a3867d88964fd2099fed954f78a5acb07de
		
	}

	@Test
	public void GetCourses() {
		try {

			assertEquals(true, false);
		} catch (Exception e) {
			throw new RuntimeException("Test not implemented");
		}
	}

	@Test
	public void ShowCourse() {
		try {

		} catch (Exception e) {
			throw new RuntimeException("Test not implemented");
		}
	}

}
*/