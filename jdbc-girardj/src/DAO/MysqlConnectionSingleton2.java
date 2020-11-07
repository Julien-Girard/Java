package DAO;

import java.sql.*;

public final class MysqlConnectionSingleton2 {
	
	private static volatile Connection instance=null; 
		
	public MysqlConnectionSingleton2() {
		String nomPilote = "org.mariadb.jdbc.Driver" ;	
		String url = "jdbc:mariadb://localhost:3306/jdbc?";
		String user = "admin";
		String password = "admin";
			
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
		if(MysqlConnectionSingleton2.instance==null) {
			synchronized(MysqlConnectionSingleton2.class) {
				if (MysqlConnectionSingleton2.instance==null) {
					new MysqlConnectionSingleton2();
				}
			}
		}
		return MysqlConnectionSingleton2.instance;
	}
}