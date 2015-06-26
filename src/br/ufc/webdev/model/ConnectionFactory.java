package br.ufc.webdev.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Qask",
					"root","");
		} catch (SQLException e) {
			throw new RuntimeException(e);			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

}
