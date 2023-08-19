package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMysql {

	public Connection Connect() throws ClassNotFoundException, SQLException {
		// Step 1: Register JDBC driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Step 2: Open a connection
		String DB_URL = "jdbc:mysql://localhost:3306/student";
		// Database credentials
		String USERNAME = "root";
		String PASSWORD = "mysql123456";
		Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		return connection;
	}
}
