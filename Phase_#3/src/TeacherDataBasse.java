import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDataBasse extends DataBaseConnection {

	public boolean SaveTeacherData(Teacher teacher) {

		String query = "INSERT INTO `software`.`teacher`(`NAME`,`USERNAME`,`AGE`,`GENDER`,`EMAIL`,`PASSWORD`,`SCHOOLNAME`,`SCHOOLADDRESS`)VALUES("
				+ "'" + teacher.getName() + "','" + teacher.getUserName() + "','" + teacher.getAge() + "','"
				+ teacher.getGender() + "','" + "" + teacher.getEmail() + "','" + teacher.getPassword() + "','"
				+ teacher.getSchoolName() + "','" + teacher.getSchoolAddress() + "'); ";

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

	public boolean UpdateTeacher(Teacher teacher) {

		String query = "UPDATE `software`.`teacher` SET `NAME` = '" + teacher.getName() + "',`USERNAME` = '"
				+ teacher.getUserName() + "',`AGE` = '" + teacher.getAge() + "'," + "`GENDER` = '" + teacher.getGender()
				+ "',`EMAIL` = '" + teacher.getEmail() + "', `PASSWORD` = '" + teacher.getPassword() + "',"
				+ "`SCHOOLNAME` = '" + teacher.getSchoolName() + "', `SCHOOLADDRESS` = '" + teacher.getSchoolAddress()
				+ "' " + "WHERE `USERNAME` = '" + teacher.getUserName() + "';";

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

	public Teacher LoadTeacherData(String username, String password) {

		Teacher teacher = new Teacher();
		String query = "select * from software.teacher where USERNAME='" + username + "'and password='" + password
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
		boolean hasTeacher = false;
		try {
			if (res.next()) {
				hasTeacher = true;
				teacher.setName(res.getString("NAME"));
				teacher.setUserName(res.getString("USERNAME"));
				teacher.setAge(res.getInt("AGE"));
				teacher.setGender(res.getString("GENDER").charAt(0));
				teacher.setEmail(res.getString("EMAIL"));
				teacher.setPassword(res.getString("PASSWORD"));
				teacher.setSchoolName(res.getString("SCHOOLNAME"));
				teacher.setSchoolAddress(res.getString("SCHOOLADDRESS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (!hasTeacher) {
			return null;
		}
		return teacher;

	}

	public boolean CheckprimaryKey(String username) {

		String query = "select * from software.teacher where USERNAME='" + username + "';";
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
			return false;

		}

		return hasStudent;
	}

	public boolean CheckValidUser(String Username, String Password) {

		String query2 = "select * from software.teacher where USERNAME='" + Username + "'and password='" + Password
				+ "';";
		ResultSet res2;
		PreparedStatement st2;
		try {

			st2 = (java.sql.PreparedStatement) ((java.sql.Connection) connection).prepareStatement(query2);
			res2 = st2.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}

		boolean hasTeacher = false;

		try {

			if (res2.next()) {
				hasTeacher = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hasTeacher;
	}

}
