package fr.istic.master.wego.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HsqlDBInMemoryDatabase {

	private Connection connection;
	private String url;
	private String user;
	private String password;
	
	public HsqlDBInMemoryDatabase(String url,
	        String user, String password) {
        this.url = url;
		this.user = user;
		this.password = password;
	}
	
	public void initialize() {
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void closeDatabase() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
