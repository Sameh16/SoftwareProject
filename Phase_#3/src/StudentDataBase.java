import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDataBase extends DataBaseConnection {

	public boolean SaveStudentData(Student student) {

		String query = "INSERT INTO `software`.`student`(`NAME`,`USERNAME`,`AGE`,`GENDER`,`EMAIL`,`PASSWORD`)VALUES ( '"
				+ "" + student.getName() + "' ,'" + student.getUserName() + "' ,'" + student.getAge() + "' ,'"
				+ student.getGender() + "' ,'" + "" + student.getEmail() + "','" + student.getPassword() + "');";

		PreparedStatement st;
		try {
			st = (java.sql.PreparedStatement) ((java.sql.Connection) connection).prepareStatement(query);
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean UpdateStudentData(Student student) {

		String query = "UPDATE `software`.`student` SET `NAME` = '" + student.getName() + "',`AGE` = '"
				+ student.getAge() + "'," + "`GENDER` = '" + student.getGender() + "',`EMAIL` = '" + student.getEmail()
				+ "', `PASSWORD` = '" + student.getPassword() + "' " + " WHERE `USERNAME` = '" + student.getUserName()
				+ "';";
		System.out.println(query);

		PreparedStatement st;
		try {
			st = (java.sql.PreparedStatement) ((java.sql.Connection) connection).prepareStatement(query);
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public Student LoadStudentData(String User_name, String password) {

		Student student = new Student();
		String query = "select * from software.student where USERNAME='" + User_name + "'and password='" + password
				+ "';";
		ResultSet res;
		PreparedStatement st;
		try {
			st = (java.sql.PreparedStatement) ((java.sql.Connection) connection).prepareStatement(query);
			res = st.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();

			return null;
		}
		boolean hasStudent = false;

		try {
			if (res.next()) {
				hasStudent = true;
				student.setName(res.getString("NAME"));
				student.setUserName(res.getString("USERNAME"));
				student.setAge(res.getInt("AGE"));
				student.setGender(res.getString("GENDER").charAt(0));
				student.setEmail(res.getString("EMAIL"));
				student.setPassword(res.getString("PASSWORD"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!hasStudent) {
			return null;
		}
		return student;
	}

	public boolean CheckprimaryKey(String username) {

		String query = "select * from software.student where USERNAME='" + username + "';";
		ResultSet res;
		PreparedStatement st;
		try {
			st = (java.sql.PreparedStatement) ((java.sql.Connection) connection).prepareStatement(query);
			res = st.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}
		boolean hasStudent = false;

		try {
			if (res.next()) {
				hasStudent = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hasStudent;
	}

	public boolean SaveStudentAchievement() { // need to know what is the Game
												// Data
		// to save it
		return true;
	}

	public boolean CheckValidUser(String Username, String Password) {

		String query = "select * from software.student where USERNAME='" + Username + "'and password='" + Password
				+ "';";
		ResultSet res;
		PreparedStatement st;
		try {

			st = (java.sql.PreparedStatement) ((java.sql.Connection) connection).prepareStatement(query);
			res = st.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}

		boolean hasStudent = false;

		try {
			if (res.next()) {
				hasStudent = true;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hasStudent;
	}

}
