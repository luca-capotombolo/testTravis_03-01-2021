package com.logic.Controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {

	public boolean login(String username, String password) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.print("Non esiste il driver.\n");
		}
		
		
		String connectionString = "jdbc:mysql://localhost:3306/gestioneuni?user=root&password=Monte_2020.&serverTimezone=UTC";
		
		Connection connection = null;
		
		try {
			
			//Cerco di istaurare la connessione
			connection = DriverManager.getConnection(connectionString);
			
			String query = "select count(*) as numero from utenti  where username=\""+username+"\" and password = \""+password+"\"";
			System.out.print(query);
			
			Statement cmdStatement = connection.createStatement();
			ResultSet rs = cmdStatement.executeQuery(query);
			rs.next();
			System.out.print(rs.getString("numero"));
			if(!(rs.getString("numero").equals("1"))) {
				System.out.print("Sbagliato.\n");
				return false;
			}
			
			
			
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
}
