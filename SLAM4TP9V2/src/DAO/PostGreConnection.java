package DAO;

import java.sql.*;

public final class PostGreConnection {
	
	private static volatile Connection instance=null; 
		
	public PostGreConnection() {
		String nomPilote = "org.postgresql.Driver" ;	
		String url = "jdbc:postgresql://servbd/tonerexpress_girardj";
		String user = "girardj";
		String password = "Jmftcipdr0";
			
		try {
			Class.forName(nomPilote);
			instance = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e){ 
			System.out.println("problème lors de la connexion à la bd "+e);
		}
	}
	
	public final static Connection getInstance() {
		if(PostGreConnection.instance==null) {
			synchronized(PostGreConnection.class) {
				if (PostGreConnection.instance==null) {
					new PostGreConnection();
				}
			}
		}
		return PostGreConnection.instance;
	}
}


/*public class PostGreConnection {
	
	public Connection getConnection() {
		
		String nomPilote = "org.postgresql.Driver" ;	
		String url = "jdbc:postgresql://servbd/tonerexpress_girardj";
		String user = "girardj";
		String password = "Jmftcipdr0";
		
		Connection connection = null;
		try {
			Class.forName(nomPilote);
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e){ 
			System.out.println("problème lors de la connexion à la bd "+e);
		}
		return connection;
	}
}*/