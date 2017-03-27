import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

	protected Connection connection = null;

	public boolean ConnectDataBase() {
		try {
			connection = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/software?" + "user=root&password=sameh&characterEncoding=utf8");

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public void DisconnectDataBase() {
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
