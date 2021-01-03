package com.logic.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.logic.Model.Nota;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class NoteController {

	public void inserisciNota(String contenuto) {
		
		//carico la classe Driver in memoria
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.print("Il Driver non esiste.\n");
		}
		
		String connectionString = "jdbc:mysql://localhost:3306/gestioneuni?user=root&password=Monte_2020.&serverTimezone=UTC";
		
		Connection connection = null;
		
		
		try {
			
			//Richiedo la connessione al DB
			connection = DriverManager.getConnection(connectionString);
			
			
			//preparo la query
			String queryString = "insert into note(contenuto) values('"+contenuto +"');";
			PreparedStatement st = connection.prepareStatement(queryString);
			
			//Catturo i risultati della query
			st.executeUpdate();
			
			st.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Eccezione SQL.\n");
		}	

	}
	
	public ObservableList<Nota> caricaNota() {
		
		
		//carico la classe Driver in memoria
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					System.out.print("Il Driver non esiste.\n");
				}
				
				String connectionString = "jdbc:mysql://localhost:3306/gestioneuni?user=root&password=Monte_2020.&serverTimezone=UTC";
				
				Connection connection = null;
				ObservableList<Nota> esami = FXCollections.observableArrayList();
				
				try {
					
					//Richiedo la connessione al DB
					connection = DriverManager.getConnection(connectionString);
					
					
					//preparo la query
					String queryString = "SELECT * from note";
					PreparedStatement st = connection.prepareStatement(queryString);
					
					//Catturo i risultati della query
					ResultSet rs = st.executeQuery();
					
					//costruisco la lista di risultati
					while(rs.next()) {
						esami.add(new Nota(rs.getString(1)));				
					}			
					
					rs.close();
					connection.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Eccezione SQL.\n");
				}
				
				return esami;
	}
}
