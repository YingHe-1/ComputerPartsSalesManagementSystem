package dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectMySql {
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
	private static final String DATABASE_USER = "root";
	private static final String DATABASE_PASSWORD = "123456";

	public static Connection getConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DRIVER_CLASS);
			dbConnection = DriverManager.getConnection(DATABASE_URL,
					DATABASE_USER, DATABASE_PASSWORD);
		} catch (ClassNotFoundException | SQLException e){
			System.out.println("无法找到驱动类");
		}
		return dbConnection;
	}

	public static void closeConnection(Connection dbConnection) {
		try {
			if (dbConnection != null && (!dbConnection.isClosed())) {
				dbConnection.close();
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
	}

	public static void closeResultSet(ResultSet res) {
		try {
			if (res != null) {
				res.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeStatement(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
